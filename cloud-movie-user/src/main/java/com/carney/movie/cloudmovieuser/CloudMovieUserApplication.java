package com.carney.movie.cloudmovieuser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableDiscoveryClient //声明自己是个eureka微服务客户端
@EnableHystrix
public class CloudMovieUserApplication {
    public static void main(String[] args) {
        SpringApplication.run(CloudMovieUserApplication.class, args);
        System.out.println("user module has started ...");
    }

}

