package com.netty.rpc.server.config;

import com.djk.netty.rpc.common.RpcServer;
import com.djk.netty.rpc.common.ServiceRegistry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RegisrtyConfig {

    @Value("${rpc.registry.address}")
    private String address;

    @Value("${rpc.port}")
    private Integer exposePort;

    @Bean
    public ServiceRegistry serviceRegistry(){
        return new ServiceRegistry(address);
    }

    @Bean
    public RpcServer rpcServer(ServiceRegistry serviceRegistry){
        return new RpcServer(exposePort,serviceRegistry);
    }
}
