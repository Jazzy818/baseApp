package com.jzcradle.api.response;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@RestControllerAdvice
public class DefaultBaseResponse implements ResponseBodyAdvice<Object> {


    @Override
    public boolean supports(org.springframework.core.MethodParameter returnType, Class<? extends org.springframework.http.converter.HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, org.springframework.core.MethodParameter returnType, org.springframework.http.MediaType selectedContentType, Class<? extends org.springframework.http.converter.HttpMessageConverter<?>> selectedConverterType, org.springframework.http.server.ServerHttpRequest request, org.springframework.http.server.ServerHttpResponse response) {

        // 已经是 CommonRes 类型则直接返回
        if (body instanceof Result) {
            return body;
        }
        // 加密扩展点


        // 自动封装为统一响应
        return Result.success(body);

    }
}
