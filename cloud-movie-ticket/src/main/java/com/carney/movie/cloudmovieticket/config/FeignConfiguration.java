//package com.carney.movie.cloudmovieticket.config;
//
//import feign.Contract;
//import feign.Logger;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.client.support.BasicAuthorizationInterceptor;
//
///**
// * @author Joe
// * @version V1.0
// * @Description: TODO
// * @date 2018/12/19
// * Feign自定义配置类
// * 如果在主程序上下文的componentScan包中，会全局生效
// *
// */
//@Configuration
//public class FeignConfiguration {
//    /**
//     * feign默认使用springmvc的注解，此处修改为使用feign的原生注解
//     */
//    @Bean
//    public Contract feignContract(){
//        return new feign.Contract.Default();
//    }
//
//    @Bean
//    Logger.Level feignLoggerLevel(){
//        return Logger.Level.FULL;
//    }
//
////    基于Http Basic的认证接口
////    @Bean
////    public BasicAuthorizationInterceptor basicAuthorizationInterceptor(){
////        return new BasicAuthorizationInterceptor("user","password");
////    }
//}
