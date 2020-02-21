package com.gottaboy.irpc.core;

import com.gottaboy.irpc.proxy.InterfaceInvoke;

/** 
 * 泛化调用服务
 * @author minyi
 */
public class GeneralService {

	/**
	 * 构造方法
	 */
	public GeneralService() {}
	
	/**
	 * 代理调用
	 */
	public Object invoke(String className, String methodName, String[] types, Object[] args) throws Throwable {
		return new InterfaceInvoke().invoke(className, methodName, types, args, true, null);
	}
}
