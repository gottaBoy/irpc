package com.gottaboy.irpc.rpc;

public class RpcServerMain {
    public static void main(String[] args) throws Exception{
        HelloService service = new HelloServiceImpl();
        RpcServer.newRpcServer(service,8081);
    }
}
