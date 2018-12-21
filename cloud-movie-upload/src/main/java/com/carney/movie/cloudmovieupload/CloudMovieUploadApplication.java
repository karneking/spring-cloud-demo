package com.carney.movie.cloudmovieupload;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 文件上传模块
 */
@EnableEurekaClient
@SpringBootApplication
public class CloudMovieUploadApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudMovieUploadApplication.class, args);
        System.out.println("upload has started ...");
    }

}

