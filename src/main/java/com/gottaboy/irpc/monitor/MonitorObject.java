package com.gottaboy.irpc.monitor;

import java.io.Serializable;
import java.util.Date;

import com.gottaboy.irpc.core.RpcRequest;
import com.gottaboy.irpc.core.RpcResponse;
import com.gottaboy.irpc.spring.BaseRefrence;
import com.gottaboy.irpc.spring.BaseService;

/** 
 * 监控对象
 * @author minyi
 */
public class MonitorObject implements Serializable {

	private static final long serialVersionUID = 1L;

	private BaseRefrence baseRefrence;
	
	private BaseService baseService;
	
	private RpcRequest rpcRequest;
	
	private RpcResponse rpcResponse;
	
	private Date beginTime;
	
	private Date endTime;
	
	private long usedTime;

	public BaseRefrence getBaseRefrence() {
		return baseRefrence;
	}

	public void setBaseRefrence(BaseRefrence baseRefrence) {
		this.baseRefrence = baseRefrence;
	}

	public BaseService getBaseService() {
		return baseService;
	}

	public void setBaseService(BaseService baseService) {
		this.baseService = baseService;
	}

	public RpcRequest getRpcRequest() {
		return rpcRequest;
	}

	public void setRpcRequest(RpcRequest rpcRequest) {
		this.rpcRequest = rpcRequest;
	}

	public RpcResponse getRpcResponse() {
		return rpcResponse;
	}

	public void setRpcResponse(RpcResponse rpcResponse) {
		this.rpcResponse = rpcResponse;
	}

	public Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public long getUsedTime() {
		return usedTime;
	}

	public void setUsedTime(long usedTime) {
		this.usedTime = usedTime;
	}

	@Override
	public String toString() {
		return "MonitorObject [baseRefrence=" + baseRefrence + ", baseService=" + baseService + ", rpcRequest="
				+ rpcRequest + ", rpcResponse=" + rpcResponse + ", beginTime=" + beginTime + ", endTime=" + endTime
				+ ", usedTime=" + usedTime + "]";
	}
}
