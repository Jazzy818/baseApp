package com.jzcradle.service.controller;

import cn.hutool.json.JSONUtil;
import com.jzcradle.api.response.Result;
import com.jzcradle.service.pojo.UserReq;
import jakarta.validation.Valid;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {

    // 写一个简单的测试接口
    @RequestMapping("/hello")
    public String hello() {
        return "Hello, JZCradle!";
    }

    @PostMapping("/user")
    public Result<String> user(@Valid @RequestBody UserReq req) {
        return Result.success(JSONUtil.toJsonStr(req));
    }
}
