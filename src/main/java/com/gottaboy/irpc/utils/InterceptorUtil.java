package com.gottaboy.irpc.utils;

import java.util.HashMap;
import java.util.Map;

import com.gottaboy.irpc.core.Interceptor;

/** 
 * 拦截器工具类
 * 
 * @author minyi
 */
public class InterceptorUtil {

	/**
	 * 拦截器类
	 */
	public static Map<String, Interceptor> interceptorMap = new HashMap<>();
}
