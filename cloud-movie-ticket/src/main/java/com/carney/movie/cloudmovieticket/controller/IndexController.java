package com.carney.movie.cloudmovieticket.controller;

import com.carney.movie.cloudmovieticket.pojo.User;
import com.carney.movie.cloudmovieticket.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author Joe
 * @version V1.0
 * @Description: TODO
 * @date 2018/12/18
 */
@RestController
@Slf4j
public class IndexController {
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    LoadBalancerClient loadBalancerClient;
    @Autowired
    UserService userService;

    @GetMapping("/index/{id}")
    public User userInfo(@PathVariable Long id){
        return restTemplate.getForObject("http://CLOUD-MOVIE-USER/user/"+id,User.class);
    }

    @HystrixCommand(fallbackMethod = "findUserByIdFallBack")
    @GetMapping("/user/{id}")
    public User find(@PathVariable Long id){
        return userService.findUserById(id);
    }


    //断路器更详细的配置，设计短路阀值，超时，线程等

//    @HystrixCommand(fallbackMethod = "findUserByIdFallBack",
//            commandProperties = {
//            @HystrixProperty(name="execution.isolation.strategy",value = "THREAD"),   //hysrix隔离策略，线程和信号量；默认线程
//                    //正常情况下，使用默认配置；若出现找不到上下文情况，使用信号量隔离
////            @HystrixProperty(name="execution.isolation.strategy",value = "SEMAPHORE"),
//            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "5000"),  //线程策略下，超时设置
//            @HystrixProperty(name="metrics.rollingStats.timeInMilliseconds",value = "10000")},  //
//            threadPoolProperties = {
//            @HystrixProperty(name="coreSize",value = "1"),
//            @HystrixProperty(name = "maxQueueSize",value = "10")
//    })
//    @GetMapping("/user/{id}")
//    public User find2(@PathVariable Long id){
//        return userService.findUserById(id);
//    }


    @GetMapping("/user-instance")
    public void logUserInstance(){
        ServiceInstance serviceInstance = loadBalancerClient.choose("CLOUD-MOVIE-USER");
        log.info("{}:{}:{}",serviceInstance.getServiceId(),serviceInstance.getHost(),serviceInstance.getPort());
    }

    //熔断处理方法
    private User findUserByIdFallBack(Long id){
        User user = new User();
        user.setId(-1L);
        user.setName("游客");
        return user;
    }

}
