package com.carney.movie.cloudmoviegateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.spi.AbstractLogger;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Joe
 * @version V1.0
 * @Description: TODO
 * @date 2018/12/20
 * 测试路由器的拦截器功能
 */
@Slf4j
//@Configuration
public class RequestUrlFilter extends ZuulFilter{

    /**
     * 路由规则
     */
    private static Map<String,String> routeMap = new HashMap<>();
    static {
      routeMap.put("t","/test");
    }
    public Object run(){
        //当前请求上下文
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        String url = request.getRequestURI();  //获取请求地址
        String[] split = url.split("/",3);

        System.out.println("有请求进来了啊~~~~~~~~~~~~");

        try {
            log.info("请求参数：{}",String.valueOf(request.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(split.length >= 2){
            String val = routeMap.get(split[1]);
            if(!StringUtils.isEmpty(val)){
                url = url.replaceFirst("/"+split[1]+"/",val);  //自定义的路由替换规则
                requestContext.put(FilterConstants.REQUEST_URI_KEY,url);
            }
        }
        return null;
    }

    /**
     * 是否执行过滤
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }


    /**
     * 过滤器类型，
     *  pre:路由之前
     *  routing:路由之时
     *  post:路由之后
     *  error:发送错误调用
     * @return
     */
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }


    /**
     * 过滤的顺序
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }
}
