package com.lwj.mvc.annotation;

import java.lang.annotation.*;

/**
 * @author Linwj
 * @date 2019/7/12 14:35
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LwjService {
    String value() default "";
}
