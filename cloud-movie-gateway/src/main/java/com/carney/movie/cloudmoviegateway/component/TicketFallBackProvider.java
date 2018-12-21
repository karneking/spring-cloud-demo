package com.carney.movie.cloudmoviegateway.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/**
 * @author Joe
 * @version V1.0
 * @Description: TODO
 * @date 2018/12/20
 */
@Slf4j
@Component
public class TicketFallBackProvider implements FallbackProvider {
    @Override
    public String getRoute() {
        //表明为哪个微服务提供回退
        return "cloud-movie-ticket";
    }

    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {
                //回退时的状态码
                return HttpStatus.OK;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                //数字类型状态码，200，204等
                return this.getStatusCode().value();
            }

            @Override
            public String getStatusText() throws IOException {
                //返回状态文本内容
                return this.getStatusCode().getReasonPhrase();
            }

            @Override
            public void close() {

            }

            @Override
            public InputStream getBody() throws IOException {
                //响应体
                return new ByteArrayInputStream("电影票服务不可用，请稍后重试".getBytes());
            }

            @Override
            public HttpHeaders getHeaders() {
                //响应头信息设置
                HttpHeaders httpHeaders = new HttpHeaders();
                MediaType mediaType = new MediaType("application","json",Charset.forName("UTF-8"));
                httpHeaders.setContentType(mediaType);
                return httpHeaders;
            }
        };
    }
}
