package com.carney.movie.cloudmoviegateway;

import com.carney.movie.cloudmoviegateway.filter.RequestUrlFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy  //开启网关zuul代理，该代理使用ribbon定位注册服务，hystrix容错;
// 路由转发规则 http://{Zuul_host}:{zull_port}/服务serviceID/xxx
public class CloudMovieGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudMovieGatewayApplication.class, args);
        System.out.println("Gateway has started !!!");
    }

    @Bean
    public RequestUrlFilter requestUrlFilter(){
        return new RequestUrlFilter();
    }

}

