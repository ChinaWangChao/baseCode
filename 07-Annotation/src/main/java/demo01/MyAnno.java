package demo01;

/**
 * @description: 注解学习：
 * <p>
 * 注解的本质
 * javap myAnno.class
 * public interface demo01.myAnno extends java.lang.annotation.Annotation {}
 * 注解本质上就是一个接口，默认继承java.lang.annotation.Annotation
 * <p>
 * 属性：接口中的抽象方法
 * *   要求:
 * *      1、属性的返回值类型：基本数据类型、String、枚举、注解、以上类型的数组
 * *      2、禁止返回类型：void，各种对象Work等
 * *      3、定义属性时，使用default给属性默认值
 * *      4、只有一个属性名为value时，在注解的括号内可以省略名字
 * *      5、数组赋值使用大括号
 * <p>
 * 元注解：用于描述注解的注解
 * * @Target：描述注解能够作用的位置
 * * @Retention：描述注解被保留的阶段
 * * @Document：描述注解是否被抽取到api文档中
 * * @Inherited：描述注解是否被子类继承
 * <p>
 * 注解给谁使用
 * 1、编译器
 * 2、给解析程序用
 * 3、注解不是程序的一部分，可以理解为注解就是一个小标签
 * @Author: wangchao
 * @Date: 2020/12/27
 */
public @interface MyAnno {

//    int age();

    int value();

//    String name() default "";

    //    String show2();
    Person per();

    MyAnno2 anno2();

    String[] strs();
}
