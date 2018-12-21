package com.carney.movie.cloudmovieticket.service;

//import com.carney.movie.cloudmovieticket.config.FeignConfiguration;
import com.carney.movie.cloudmovieticket.pojo.User;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import java.util.Map;


/**
 * @author Joe
 * @version V1.0
 * @Description: TODO
 * @date 2018/12/19
 *  此处主机名大小写敏感
 */
@FeignClient(name="cloud-movie-user")
//启动自定义feign配置
//@FeignClient(name = "cloud-movie-user",configuration = FeignConfiguration.class)
public interface UserService {
    //mvc注解
    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    User findUserById(@PathVariable("id") Long id);

    /********************************/
    //feign原生注解
//    @RequestLine("GET /user/{id}")
//    User findUserById(@Param("id") Long id);

//    @RequestMapping(value = "/getTest",method=RequestMethod.GET)
//    User findUserById(Map<String,Object> paramMap);
//
//    @PostMapping("/postTest")
//    User postForUser(@RequestBody User user);
}
