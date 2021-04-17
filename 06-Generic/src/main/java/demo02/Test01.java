package demo02;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @Author: wangchao
 * @Date: 2020/12/13
 */
public class Test01 {

    /**
     * 有界通配符
     * ? extend Person
     * ? super Person
     */
    @Test
    public void test01() {
        // <= Person
        List<? extends Person> list1 = new ArrayList<>();
        // >= Person
        List<? super Person> list2 = new ArrayList<>();

        List<Student> list3 = new ArrayList<>();
        List<Person> list4 = new ArrayList<>();
        List<Object> list5 = new ArrayList<>();

        list1 = list3;
        list1 = list4;
//        list1 = list5;

//        list2 = list3;
        list2 = list4;
        list2 = list5;

        Person person = list1.get(0);
        Object object = list2.get(0);

//        list1.add(new Person());
        list2.add(new Person());
        list2.add(new Student());

    }
}
