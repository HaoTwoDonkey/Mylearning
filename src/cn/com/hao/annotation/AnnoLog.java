package cn.com.hao.annotation;

import java.lang.annotation.*;

/**
 * @author : hao
 * @description :
 * @time : 2018/3/13 16:27
 */

@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AnnoLog {
    //http://www.cnblogs.com/leifei/p/8194644.html
    /** 要执行的操作类型比如：add操作 **/
    public String operationType() default "";
}
