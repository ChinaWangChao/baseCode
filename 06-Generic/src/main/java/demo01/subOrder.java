package demo01;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @Author: wangchao
 * @Date: 2020/12/13
 */
public class subOrder extends Order<Integer> {
    public static <E> List<E> copyFromArrayToList(E[] arr) {
        List<E> list = new ArrayList<E>();
        for (E e : arr) {
            list.add(e);
        }
        return list;
    }
}
