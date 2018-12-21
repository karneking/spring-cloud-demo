//package com.carney.movie.cloudmovieticket.config;
//
//import com.netflix.loadbalancer.IRule;
//import com.netflix.loadbalancer.RandomRule;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * @author Joe
// * @version V1.0
// * @Description: TODO
// * @date 2018/12/18
// *  此代码是利用java代码实现Ribbon 配置；亦可以使用属性配置来完成此功能
// *  该类Ribbon配置类
// *  该类不应该在主应用程序上下文的 @componentScan中,否则会被所有的RibbonClient共享！！
// *  正确的做法，应将此配置类放在主应用程序Scan路径之外
// */
//@Configuration
//public class RibbonConfiguration {
//
//    @Bean
//    public IRule ribbonRule(){
//        //负载均衡规则改为随机
//        return new RandomRule();
//    }
//}
