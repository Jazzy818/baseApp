package com.jzcradle.api.request;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdvice;

import java.io.IOException;
import java.lang.reflect.Type;

@RestControllerAdvice
public class DefaultBaseRequest extends AbstractRequest implements RequestBodyAdvice {
    private static final Logger log = LoggerFactory.getLogger(DefaultBaseRequest.class);

    @Override
    public boolean supports(MethodParameter methodParameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        return AbstractJackson2HttpMessageConverter.class.isAssignableFrom(converterType);
    }

    @Override
    public HttpInputMessage beforeBodyRead(HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) throws IOException {
        // 这里可以对请求体进行预处理，比如解密

        // 封装traceId

        return new RepeatableHttpInputMessage(inputMessage);
    }

    @Override
    public Object afterBodyRead(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        String methodName = parameter.getMethod() != null ? parameter.getMethod().getName() : "unknown";
        String url = parameter.getMethod() != null ? parameter.getMethod().getDeclaringClass().getSimpleName() + "#" + methodName : "unknown";
        long requestTime = System.currentTimeMillis();
        log.info("接口: {}, 请求参数: {}, 请求时间: {}", url, body, requestTime);
        // 日志记录 接口url，请求参数，请求时间

        return body;
    }

    @Override
    public Object handleEmptyBody(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        return null;
    }

}
