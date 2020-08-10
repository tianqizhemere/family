package top.tianqi.annotation;

import java.lang.annotation.*;

/**
 * 记录调用时间
 * @Author wkh
 * @Date 2020/8/10 16:51
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ExecuteTime {
    String value() default "";
}
