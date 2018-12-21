package com.carney.movie.cloudmovieticket.service;

import com.carney.movie.cloudmovieticket.component.FeignClientFallback;
import com.carney.movie.cloudmovieticket.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Joe
 * @version V1.0
 * @Description: TODO
 * @date 2018/12/19
 *  当依赖了hystrix，feign会自动被包裹
 *  fallback配置回退方法类
 */
@FeignClient(name = "cloud-movie-user",fallback = FeignClientFallback.class)
public interface UserWithHysrixService {

    @GetMapping("/user/{id}")
    User findUserById(@PathVariable("id") Long id);
}
