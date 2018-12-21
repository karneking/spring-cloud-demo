package com.carney.movie.cloudmovieticket.config;

import feign.Feign;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author Joe
 * @version V1.0
 * @Description: TODO
 * @date 2018/12/19
 * 在@FeignClient 配置中，添加此bean配置，即可禁用hystrix
 */
@Configuration
public class FeignDisableHystrixConfiguration {
    @Bean
    @Scope("prototype")
    public Feign.Builder feignBuilder(){
        return Feign.builder();
    }
}
