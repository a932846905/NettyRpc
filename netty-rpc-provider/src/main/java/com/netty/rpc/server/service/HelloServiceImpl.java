package com.netty.rpc.server.service;

import com.djk.netty.rpc.common.annotation.RpcService;
import com.djk.netty.rpc.common.api.HelloService;

@RpcService
public class HelloServiceImpl implements HelloService {
    @Override
    public String hello(String name) {
        return "hello,"+name;
    }
}
