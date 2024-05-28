package com.my.java.config;

import fi.solita.clamav.ClamAVClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
 
/**
 * ClamAV 客户端配置
 *
 * @author 
 */
@Configuration
public class ClamAVClientConfig {
 
    @Value("${clamav.ipAddress}")
    private String ipAddress;
 
    @Value("${clamav.port}")
    private Integer port;
 
    @Value("${clamav.timeout}")
    private Integer timeout;
 
    @Bean
    public ClamAVClient clamAVClient() {
        return new ClamAVClient(ipAddress, port, timeout);
    }
}