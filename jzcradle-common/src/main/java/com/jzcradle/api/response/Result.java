package com.jzcradle.api.response;

import java.io.Serial;
import java.io.Serializable;

public class Result<T> implements Serializable {

    @Serial
    private static final long serialVersionUID = -7804054241710086L;

    /**
     * 状态码
     */
    private Integer code;
    /**
     * 响应数据
     */
    private T data;

    /**
     * 返回消息
     */
    private String message;


    public Result() {
    }

    public Result(Integer code, T data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public Result<T> setCode(Integer code) {
        this.code = code;
        return this;
    }

    public T getData() {
        return data;
    }

    public Result<T> setData(T data) {
        this.data = data;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Result<T> setMessage(String message) {
        this.message = message;
        return this;
    }

    public static <T> Result<T> success(T data) {
        return new Result<>(200, data, "success");
    }

    public static <T> Result<T> error(String message) {
        return new Result<>(500, null, message);
    }

    public static <T> Result<T> of(Integer code, T data, String message) {
        return new Result<>(code, data, message);
    }

}
