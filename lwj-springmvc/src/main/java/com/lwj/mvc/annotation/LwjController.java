package com.lwj.mvc.annotation;

import java.lang.annotation.*;

/**
 * @author Linwj
 * @date 2019/7/12 15:23
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LwjController {
    String value() default "";
}
