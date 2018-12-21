package com.carney.movie.cloudmovieticket.component;

import com.carney.movie.cloudmovieticket.pojo.User;
import com.carney.movie.cloudmovieticket.service.UserWithHysrixService;

/**
 * @author Joe
 * @version V1.0
 * @Description: TODO
 * @date 2018/12/19
 *  回退类实现响应的接口
 */
public class FeignClientFallback implements UserWithHysrixService {
    @Override
    public User findUserById(Long id) {
        User user = new User();
        user.setId(-1L);
        user.setName("游客");
        return user;
    }
}
