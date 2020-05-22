package PresentCloud.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//  新建两个注解 用于标识请求是否需要进行Token 验证
/***
 * 用来跳过验证的 PassToken
 * @author MRC
 * @date 2019年4月4日 下午7:01:25
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface PassToken {
    boolean required() default true;
}
