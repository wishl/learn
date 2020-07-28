package com.test.http.invoker.client;

import com.test.interfaces.TestService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;

@Configuration
public class ClientConfig {

    @Bean
    public HttpInvokerProxyFactoryBean rpcService() {
        HttpInvokerProxyFactoryBean httpInvokerProxyFactoryBean = new HttpInvokerProxyFactoryBean();
        httpInvokerProxyFactoryBean.setServiceUrl("http://localhost:8081/test");
        httpInvokerProxyFactoryBean.setServiceInterface(TestService.class);
        return httpInvokerProxyFactoryBean;
    }

}
