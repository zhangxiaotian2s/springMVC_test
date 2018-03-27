package com.test.filter;

import java.lang.annotation.*;

/**
 * Created by zhangxiaotian on 18/3/9.
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface NeedLogin {
}
