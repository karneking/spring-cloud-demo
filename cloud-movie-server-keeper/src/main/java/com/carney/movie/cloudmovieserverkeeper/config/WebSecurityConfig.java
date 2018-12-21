package com.carney.movie.cloudmovieserverkeeper.config;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author Joe
 * @version V1.0
 * @Description: TODO
 * @date 2018/12/18
 */
@Configuration
@EnableWebSecurity
@Order(SecurityProperties.BASIC_AUTH_ORDER)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    /**
     * 高版本中舍弃了 security.basic.enable=true 配置
     * @param http
     * @throws Exception
     */
    @Override
    public void configure(HttpSecurity http) throws Exception {
//        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER);

        //关闭csrf验证
        http.csrf().disable();
//        super.configure(http);
        //开启basic,才支持 http://${user}:${password}方式登录
//        http.authorizeRequests().anyRequest().authenticated().and().httpBasic();
//        http.authorizeRequests().anyRequest().authenticated().and().httpBasic();
    }
}
