package com.gottaboy.irpc.register;

import java.util.List;

//import org.I0Itec.zkclient.IZkChildListener;
import com.github.zkclient.IZkChildListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** 
 * 注册服务变化监听类
 * @author minyi
 */
public class ServiceChangeListener implements IZkChildListener {

	/**
	 * 日志处理器
	 */
	Logger logger = LoggerFactory.getLogger(ServiceChangeListener.class);
	
	/**
	 * 服务名称
	 */
	private String refrenceName;
	
	public String getRefrenceName() {
		return refrenceName;
	}

	public void setRefrenceName(String refrenceName) {
		this.refrenceName = refrenceName;
	}

	/**
	 * 构造方法
	 * @param refrenceName
	 */
	public ServiceChangeListener(String refrenceName) {
		this.refrenceName = refrenceName;
	}

	/**
	 * 监听子元素变化
	 */
	@Override
	public void handleChildChange(String parentPath, List<String> currentChilds) throws Exception {
		logger.info("[注册服务监听]到变动，目标目录:[" + parentPath + "]，子元素:[" + currentChilds + "]");
		/**
		 * 同步最新引用服务
		 */
		RegisterUtils.synRefrenceService(refrenceName);
	}

}
