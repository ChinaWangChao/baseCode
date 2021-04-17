package demo01;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @description:
 * @Author: wangchao
 * @Date: 2020/12/13
 */
public class Test01 {

    @Test
    public void test1() {
        Order<String> order = new Order<>();
        Integer[] arr = new Integer[]{1, 2, 3, 4, 5, 5};
        List<Integer> list = Order.copyFromArrayToList(arr);
        list.forEach(System.out::println);
    }

    /**
     * list<?>无法添加元素
     */
    @Test
    public void test2() {
        List<Object> list1 = null;
        List<String> list2 = null;

        List<?> list = null;
        list = list1;
        list = list2;
//        print1(list1);
//        print2(list2);

        //
        List<String> list3 = new ArrayList<>();
        list3.add("asd");
        list3.add("a1");
        list3.add("ff");
        list = list3;
        // 对于list<?>不能向其内部添加数据
//        list.add("dd");
//        list.add(null);
        print1(list);
        print2(list);

    }

    /**
     * 泛型方法
     * @param list
     * @param <E>
     */
    public <E> void print1(List<E> list) {
        Iterator<E> iterator = list.iterator();
        while (iterator.hasNext()) {
            Object o = iterator.next();
            System.out.println(o);
        }
    }

    /**
     * 通配符：？
     *
     * @param list
     */
    public void print2(List<?> list) {
        Iterator<?> iterator = list.iterator();
        while (iterator.hasNext()) {
            Object o = iterator.next();
            System.out.println(o);
        }
    }

    /**
     * 有限制条件的通配符使用,见demo02
     */


}
