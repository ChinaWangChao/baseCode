package demo02;

import java.lang.reflect.Method;

/**
 * @description: 获取注解的值
 * 内存中产生了一个该注解接口的子类实现对象，如下
 * <p>
 * * * public class ProImpl implements Pro{
 * * *    String className(){
 * * *        return "demo02.Demo1";
 * * *    }
 * * *
 * * *     String methodName(){
 * * *         return "show";
 * * *     }
 * * * }
 * @Author: wangchao
 * @Date: 2020/12/27
 */

@Pro(className = "demo02.Demo1", methodName = "show")
public class ReflectTest {
    public static void main(String[] args) throws Exception {
        // 1、解析注解
        //  1.1 获取该类的字节码文件对象
        Class<ReflectTest> reflectTestClass = ReflectTest.class;
        // 2、获取上边的字节码文件对象；其实就是在内存中产生了一个该注解接口的子类实现对象
        Pro an = reflectTestClass.getAnnotation(Pro.class);
        // 3、调用注解对象中定义的抽象方法，获取返回值
        String classname = an.className();
        String methodName = an.methodName();
        System.out.println(classname);
        System.out.println(methodName);

        // 加载该类进内存
        Class clz = Class.forName(classname);
        // 创建对象
        Object obj = clz.newInstance();
        // 获取方法对象
        Method method = clz.getMethod(methodName);
        method.invoke(obj);
    }
}
