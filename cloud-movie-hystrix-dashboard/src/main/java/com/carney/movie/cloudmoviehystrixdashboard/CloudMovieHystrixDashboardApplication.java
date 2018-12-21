package com.carney.movie.cloudmoviehystrixdashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * hystrix 可视化监控平台
 *
 *  地址：host:port/hystrix
 */

@SpringBootApplication
@EnableHystrixDashboard
public class CloudMovieHystrixDashboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudMovieHystrixDashboardApplication.class, args);
        System.out.println("Hystrix Dashboard has started");
    }

}

