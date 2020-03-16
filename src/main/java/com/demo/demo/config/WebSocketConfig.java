package com.demo.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @author luwenxin
 * @create 2020-03-13
 */
@Configuration
public class WebSocketConfig {
    /**
     * @author: LWX
     * @date: 2020-03-13 17:10
     * 服务节点
     * 
     */
    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
}
