package com.carney.movie.cloudmovieticket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient //微服务客户端
@EnableFeignClients(basePackages = "com.carney.movie.cloudmovieticket.*") //开启feign
@EnableHystrix   //开启断路器
public class CloudMovieTicketApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudMovieTicketApplication.class, args);
        System.out.println("Ticket has started ...");
    }

    @Bean  //注入一个rest服务bean
    @LoadBalanced //开启负载均衡的功能
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

}

