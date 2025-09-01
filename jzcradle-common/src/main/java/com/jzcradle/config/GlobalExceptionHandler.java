package com.jzcradle.config;

import com.jzcradle.api.response.Result;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;
import java.util.stream.Stream;


@RestControllerAdvice(basePackages = "com.jzcradle")
public class GlobalExceptionHandler {


    @ExceptionHandler(Exception.class)
    public Result<String> handleException(Exception e) {
        return Result.error("服务器异常，请联系管理员: " + e.getMessage());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Result<String> handleHttpMessageNotReadable(HttpMessageNotReadableException e) {
        return Result.error("请求参数体缺失或格式错误，请检查请求: " + e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result<String> handleRuntimeException(MethodArgumentNotValidException e) {
        String msg = e.getAllErrors().stream().map(error -> error.getDefaultMessage())
                .collect(Collectors.joining("; "));
        return Result.error("参数绑定异常: " + msg);
    }

    @ExceptionHandler(BindException.class)
    public Result<String> handleBindException(BindException e) {
        String msg = e.getAllErrors().stream().map(error -> error.getDefaultMessage())
                .collect(Collectors.joining("; "));
        return Result.error("参数绑定异常: " + msg);
    }
}
