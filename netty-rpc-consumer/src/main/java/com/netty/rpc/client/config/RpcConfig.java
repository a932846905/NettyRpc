package com.netty.rpc.client.config;

import com.djk.netty.rpc.common.RpcProxy;
import com.djk.netty.rpc.common.ServiceDiscovery;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RpcConfig {

    @Value("${rpc.registry.address}")
    private String address;

    @Bean
    public ServiceDiscovery serviceDiscovery (){
        return new ServiceDiscovery(address);
    }

    @Bean
    public RpcProxy rpcProxy (ServiceDiscovery serviceDiscovery){
        return new RpcProxy(serviceDiscovery);
    }
}
