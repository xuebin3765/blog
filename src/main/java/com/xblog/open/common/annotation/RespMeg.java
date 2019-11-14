package com.xblog.open.common.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
public @interface RespMeg {
    public String value() default "未知错误";
}
