package com.gottaboy.irpc.utils;

import java.util.ArrayList;
import java.util.List;

import com.gottaboy.irpc.register.DegradeServiceChangeListener;
import com.gottaboy.irpc.register.ZookeeperClient;
import com.gottaboy.irpc.spring.Register;
import com.gottaboy.irpc.spring.SpringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** 
 * 服务降级工具类
 * @author minyi
 */
public class ServiceDegradeUtil {

	/**
	 * 日志记录器
	 */
	private static Logger logger = LoggerFactory.getLogger(ServiceDegradeUtil.class);
	
	/**
	 * 服务降级值
	 */
	private static final String SERVICE_DEGRADE_VALUE = "DEGRADE";
	
	/**
	 * 降级服务集合
	 */
	public static List<String> degradeServiceList = new ArrayList<>();

	/**
	 * 同步最新降级服务
	 */
	public static void synDegradeService() {
		/**
		 * 判断配置注册中心
		 */
		if(!SpringUtil.getApplicationContext().containsBean("register")) {
			return;
		}
		String path = "/irpc/degrade_service";
		logger.info("同步最新降级服务");
		/**
		 * 获取注册中心
		 */
		Register register = (Register)SpringUtil.getApplicationContext().getBean("register");
		if("zookeeper".equals(register.getType())) {
			List<String> tempDegradeServiceList = ZookeeperClient.getInstance().getChildNodes(path);
			if(null == tempDegradeServiceList) {
				tempDegradeServiceList = new ArrayList<>();
			}
			degradeServiceList = new ArrayList<>(tempDegradeServiceList);
		}
	}

	/**
	 * 订阅降级服务变化
	 */
	public static void subscribeDegradeServiceChanges() {
		/**
		 * 判断配置注册中心
		 */
		if(!SpringUtil.getApplicationContext().containsBean("register")) {
			return;
		}
		String path = "/irpc/degrade_service";
		logger.info("订阅降级服务变化:[" + path + "]");
		/**
		 * 订阅子目录变化
		 */
		ZookeeperClient.getInstance().subscribeChildChanges(path, new DegradeServiceChangeListener());
	}

	/**
	 * 降级服务新增
	 * @param refrence
	 */
	public static void add(String refrence) {
		/**
		 * 判空直接返回
		 */
		if(null == refrence || "".equals(refrence)) {
			return;
		}
		String path = "/irpc/degrade_service/" + refrence;
		/**
		 * 创建节点
		 */
		ZookeeperClient.getInstance().createOrUpdateNodePersistent(path, SERVICE_DEGRADE_VALUE);
	}

	/**
	 * 降级服务删除
	 * @param refrence
	 */
	public static void remove(String refrence) {
		String path = "/irpc/degrade_service/" + refrence;
		/**
		 * 删除节点
		 */
		ZookeeperClient.getInstance().delete(path);
	}
}
