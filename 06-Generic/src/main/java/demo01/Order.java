package demo01;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @Author: wangchao
 * @Date: 2020/12/13
 */
public class Order<T> {
    String orderName;
    int orderId;
    T orderT;

    public Order() {
        T[] arr = (T[]) new Object[10];
    }

    public Order(String orderName, int orderId, T orderT) {
        this.orderName = orderName;
        this.orderId = orderId;
        this.orderT = orderT;
    }

    public T getOrderT() {
        return orderT;
    }

    public void setOrderT(T orderT) {
        this.orderT = orderT;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderName='" + orderName + '\'' +
                ", orderId=" + orderId +
                ", orderT=" + orderT +
                '}';
    }

    // 静态方法中不能使用类的泛型,因为静态方法先与类加载
//    public static void show(T orderT){
//        System.out.println(orderT);
//    }

    public <E> void show(E orderE) {
        System.out.println(orderE);
    }


    /**
     * 泛型方法:将数组中的值放到集合中去
     * 1、在方法中出现的泛型结构，泛型参数与类的泛型参数没有任何关系。
     * 2、换句话说，泛型方法所属的类是不是泛型类多没有泛型
     * 3、泛型方法可以声明为静态的，原因：泛型参数是在调用方法时确定的，并非在实例化时确定的
     *
     * @param arr
     * @param <E>
     * @return
     */
    public static <E> List<E> copyFromArrayToList(E[] arr) {
        List<E> list = new ArrayList<E>();
        for (E e : arr) {
            list.add(e);
        }
        return list;
    }

}
