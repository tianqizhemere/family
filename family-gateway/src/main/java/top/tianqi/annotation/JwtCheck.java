package top.tianqi.annotation;

import java.lang.annotation.*;

/**
 * Jwt 检查注解
 * @Author wkh
 * @Date 2020/8/10 16:49
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface JwtCheck {
    String value() default "";
}
