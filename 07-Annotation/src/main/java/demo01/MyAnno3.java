package demo01;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @description: 元注解：用于描述注解的注解
 * * <p>
 * * * @Target：描述注解能够作用的位置
 * * *   TYPE：可以作用于类上
 * * *   METHOD：可以作用于方法上
 * * *   FIELD：可以作用于成员变量上
 * * * @Retention：描述注解被保留的阶段
 * * *   RetentionPolicy.RUNTIME 当前被描述的注解，会保留到class到字节码文件中，并且被JVM读取到
 * * * @Document：描述注解是否被抽取到api文档中
 * * * @Inherited：描述注解是否被子类继承
 * * <p>
 * @Author: wangchao
 * @Date: 2020/12/27
 */

@Target(value = {ElementType.TYPE, ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface MyAnno3 {
}
