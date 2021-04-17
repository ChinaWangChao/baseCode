package demo01;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: 反射超越泛型检查 赋值
 * @Author: wangchao
 * @Date: 2020/11/29
 */
public class Test01 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(123);
        list.add(12213);
        list.add(12434253);

        try {
            Class clazz = Class.forName("java.util.ArrayList");
            Method method = clazz.getMethod("add", Object.class);
            method.invoke(list, "abc");
            System.out.println(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
