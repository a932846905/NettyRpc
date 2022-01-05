package com.netty.rpc.client.controller;

import com.djk.netty.rpc.common.RpcProxy;
import com.djk.netty.rpc.common.api.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private RpcProxy rpcProxy;

    @RequestMapping("/hello")
    public String hello(){
        HelloService helloService = rpcProxy.create(HelloService.class);
        String result = helloService.hello("World");
        return result;
    }
}
