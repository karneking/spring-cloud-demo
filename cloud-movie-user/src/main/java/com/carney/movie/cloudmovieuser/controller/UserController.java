package com.carney.movie.cloudmovieuser.controller;

import com.carney.movie.cloudmovieuser.dao.UserRepository;
import com.carney.movie.cloudmovieuser.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @author Joe
 * @version V1.0
 * @Description: TODO
 * @date 2018/12/17
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserRepository userRepository;


    @GetMapping("/{id}")
    public User findById(@PathVariable Long id){
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.orElse(null);
    }
}
