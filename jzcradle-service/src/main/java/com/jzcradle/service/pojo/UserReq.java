package com.jzcradle.service.pojo;

import com.jzcradle.anno.Contains;
import jakarta.validation.constraints.NotBlank;
import jdk.jfr.DataAmount;
import lombok.Data;

@Data
public class UserReq {

    private String username;
    @NotBlank(message = "性别不能为空")
    @Contains(value = {"M", "F"}, message = "性别只能是 M(男) 或 F(女)")
    private String gender;
    private Integer age;
}
