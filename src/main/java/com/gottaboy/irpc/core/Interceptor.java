package com.gottaboy.irpc.core;

import com.gottaboy.irpc.spring.BaseRefrence;

/** 
 * 拦截器
 * @author minyi
 */
public interface Interceptor {

	/**
	 * rpc调用前执行
	 * @param baseRefrence
	 * @param rpcRequest
	 */
	public void preHandle(BaseRefrence baseRefrence, RpcRequest rpcRequest);

	/**
	 * rpc调用后执行
	 * @param baseRefrence
	 * @param rpcRequest
	 * @param result
	 */
	public void postHandle(BaseRefrence baseRefrence, RpcRequest rpcRequest, Object result);

	/**
	 * rpc调用异常后执行
	 * @param baseRefrence
	 * @param rpcRequest
	 * @param throwable
	 */
	public void exceptionHandle(BaseRefrence baseRefrence, RpcRequest rpcRequest, Throwable throwable);
}
