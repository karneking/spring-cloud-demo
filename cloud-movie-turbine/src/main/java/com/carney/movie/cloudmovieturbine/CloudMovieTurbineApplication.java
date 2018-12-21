package com.carney.movie.cloudmovieturbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * 聚合hystrix 监控信息
 */

@SpringBootApplication
@EnableTurbine  //开启聚合监控
public class CloudMovieTurbineApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudMovieTurbineApplication.class, args);
        System.out.println("Turbine has started ...");
    }

}

