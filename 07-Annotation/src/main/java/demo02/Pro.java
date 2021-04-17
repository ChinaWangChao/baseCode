package demo02;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @description: 描述需要执行的类名和方法名
 * @Author: wangchao
 * @Date: 2020/12/27
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Pro {
    String className();

    String methodName();
}

/**
 * * public class ProImpl implements Pro{
 * *    String className(){
 * *        return "demo02.Demo1";
 * *    }
 * *
 * *     String methodName(){
 * *         return "show";
 * *     }
 * * }
 */
