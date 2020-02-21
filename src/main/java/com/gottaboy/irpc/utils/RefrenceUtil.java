package com.gottaboy.irpc.utils;

import java.util.Map;

import com.gottaboy.irpc.core.RpcContext;
import com.gottaboy.irpc.spring.BaseRefrence;
import com.gottaboy.irpc.spring.Refrence;
import com.gottaboy.irpc.spring.SpringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** 
 * 引用工具类
 * 
 * @author minyi
 */
public class RefrenceUtil {

	/**
	 * 日志记录器
	 */
	private static Logger logger = LoggerFactory.getLogger(RefrenceUtil.class);

	/**
	 * 查找引用信息
	 * @param refrenceName
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static BaseRefrence getBaseRefrence(String refrenceName) {
		/**
		 * spring管理的所有引用
		 */
		Map<String, Refrence> refrenceMap = (Map<String, Refrence>)SpringUtil.
				getApplicationContext().getBeansOfType(Refrence.class);
		logger.info("spring管理的所有引用:" + refrenceMap);
		
		Refrence refrence = null;//引用
		
		for(String key : refrenceMap.keySet()) {
			if(refrenceMap.get(key).getName().equals(refrenceName)) {
				refrence = refrenceMap.get(key);
				logger.info("根据[" + refrenceName + "]查找到引用信息:" + refrence);
			}
		}
		
		/**
		 * 本地有配置引用分：正常配置 和 配置泛化调用
		 * 本地没配置引用分：设置上下文泛化调用引用 和 就是没配
		 */
		if(null == refrence) {
			return RpcContext.generalBaseRefrenceMap.get(refrenceName);
		} else {
			return refrence.toBaseRefrence();
		}
	}
}
