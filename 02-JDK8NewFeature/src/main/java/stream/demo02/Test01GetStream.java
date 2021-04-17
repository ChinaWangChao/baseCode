package stream.demo02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

/**
 * stream的常用方法分为两类：终结方法、函数拼接方法
 * 三个注意事项：
 * 1、Stream只能操作一次
 * 2、Stream方法返回的是最新的流
 * 3、Stream不调用终结方法，中间操作不会执行
 */
public class Test01GetStream {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Stream<String> stream1 = list.stream();

        Set<String> set = new HashSet<>();
        Stream<String> stream2 = set.stream();

        /**
         * 获取map的流
         */
        Map<String, String> map = new HashMap<>();
        Stream<String> stream3 = map.keySet().stream();
        Stream<String> stream4 = map.values().stream();
        Stream<Map.Entry<String, String>> stream5 = map.entrySet().stream();


        // Stream中的静态方法of获取流
        // static<T> Stream<T> of(T... values)
        Stream<String> stream6 = Stream.of("aa", "bb", "cc");

        String[] strs = {"aa", "bb", "cc"};
        Stream<String> stream7 = Stream.of(strs);

        // 基本数据类型的数组不行，会将整个数组看成一个元素进行操作
        int[] arr = {22, 33, 44};
        Stream<int[]> stream8 = Stream.of(arr);

        // OK
        Integer[] arr2 = {22, 33, 44};
        Stream<Integer> stream9 = Stream.of(arr2);
    }
}
