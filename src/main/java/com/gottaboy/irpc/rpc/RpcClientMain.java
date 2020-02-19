package com.gottaboy.irpc.rpc;

public class RpcClientMain {
    public static void main(String[] args) throws Exception{
        HelloService service = RpcProxy.consume(HelloService.class, "127.0.0.1", 8081);
        for (int i = 0; i < 1000; i++) {
            String hello = service.sayHello("rpc_" + i);
            System.out.println(hello);
            Thread.sleep(1000);
        }
    }
}
