package demo04;

import java.lang.reflect.Field;

/**
 * @description: 反射 改值
 * @Author: wangchao
 * @Date: 2020/11/29
 */
public class Test01 {
    public static void main(String[] args) throws Exception {
        Student student = new Student("小王", 22);
        Field field = student.getClass().getDeclaredField("name");
        field.setAccessible(true);
        Object o = field.get(student);
        String name = field.getName();
        System.out.println(name + ":" + o);
    }
}
