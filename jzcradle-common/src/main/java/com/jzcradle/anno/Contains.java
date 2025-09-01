package com.jzcradle.anno;


import com.jzcradle.validator.ContainsValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

/**
 * 用于@Valid 注解的自定义校验注解，校验字符串是否包含指定的值
 */
@Documented
@Inherited
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {ContainsValidator.class})
public @interface Contains {

    public String[] value() default "";

    public String message() default "";

    public Class<?>[] groups() default {};

    public Class<? extends Payload>[] payload() default {};


}
