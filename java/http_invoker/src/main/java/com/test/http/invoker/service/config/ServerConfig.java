package com.test.http.invoker.service.config;

import com.test.interfaces.TestService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.httpinvoker.HttpInvokerServiceExporter;

@Configuration
public class ServerConfig {

    @Bean("/test")
    public HttpInvokerServiceExporter rpcService(TestService testService) {
        HttpInvokerServiceExporter httpInvokerServiceExporter = new HttpInvokerServiceExporter();
        httpInvokerServiceExporter.setService(testService);
        httpInvokerServiceExporter.setServiceInterface(TestService.class);
        return httpInvokerServiceExporter;
    }

}
