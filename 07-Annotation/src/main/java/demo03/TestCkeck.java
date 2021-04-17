package demo03;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @description:
 * 简单测试框架，当主方法执行后，会自动检测加了check注解的方法，判断该方法是否有异常，并记录到文件中
 * @Author: wangchao
 * @Date: 2020/12/27
 */
public class TestCkeck {

    public static void main(String[] args) throws IOException {
        // 1、创建计算器对象
        Calculator calculator = new Calculator();

        // 2、获取字节码文件对象
        Class aClass = calculator.getClass();

        // 3、获取所有的方法
        Method[] methods = aClass.getMethods();

        // 记录异常的次数
        int num = 0;

        BufferedWriter bw = new BufferedWriter(new FileWriter("bug.txt"));

        for (Method method : methods) {
            // 4、判断方上是否有Check注解
            if (method.isAnnotationPresent(Check.class)) {
                try {
                    // 5、执行方法
                    method.invoke(calculator);
                } catch (Exception e) {
                    // 6、捕获异常
                    num++;
                    bw.write(method.getName() + "方法异常了");
                    bw.newLine();
                    bw.write("异常的名称:" + e.getClass().getName());
                    bw.newLine();
                    bw.write("异常的原因:" + e.getMessage());
                    bw.newLine();
                    bw.write("------------------------");

                }

            }
        }

        bw.write("本次测试一共出现" + num + "次异常！");
        bw.flush();
        bw.close();


    }
}
