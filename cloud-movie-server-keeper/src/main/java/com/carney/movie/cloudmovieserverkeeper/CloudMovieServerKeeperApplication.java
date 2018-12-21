package com.carney.movie.cloudmovieserverkeeper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer  //声明是一个服务中心
public class CloudMovieServerKeeperApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudMovieServerKeeperApplication.class, args);
        System.out.println("Server Keeper has started!!");
    }

}

