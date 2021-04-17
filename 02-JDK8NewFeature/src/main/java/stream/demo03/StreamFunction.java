package stream.demo03;

import org.junit.Test;

import java.security.Identity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @description:
 * @Author: wangchao
 * @Date: 2020/11/29
 */
public class StreamFunction {

    @Test
    public void testCount() {
        List<String> one = new ArrayList<>();
        Collections.addAll(one, "张无忌", "周芷若", "赵敏", "张强", "张三丰");
        System.out.println(one.stream().count());
    }

    @Test
    public void testForEach() {
        List<String> one = new ArrayList<>();
        Collections.addAll(one, "张无忌", "周芷若", "赵敏", "张强", "张三丰");
        one.stream().forEach((String str) -> {
            System.out.println(str);
        });
        one.stream().forEach(str -> System.out.println(str));
        one.stream().forEach(System.out::println);
    }

    @Test
    public void testFilter() {
        List<String> one = new ArrayList<>();
        Collections.addAll(one, "张无忌", "周芷若", "赵敏", "张强", "张三丰");
        one.stream().filter((String str) -> {
            return str.length() == 3;
        }).forEach(System.out::println);
        one.stream().filter(str -> str.length() == 3).forEach(System.out::println);
    }

    @Test
    public void testSkip() {
        List<String> one = new ArrayList<>();
        Collections.addAll(one, "张无忌", "周芷若", "赵敏", "张强", "张三丰");
        one.stream().skip(2).forEach(System.out::println);
    }

    /**
     * map可以将一种类型的流转化为另外一种类型的流
     */
    @Test
    public void testMap() {
        List<String> one = new ArrayList<>();
        Collections.addAll(one, "11", "22", "33", "44", "55");
        one.stream().map((String str) -> {
            return Integer.parseInt(str);
        }).forEach(System.out::println);

        // 化简写法
        one.stream().map((Integer::parseInt)).forEach(System.out::println);
    }

    /**
     * 排序
     */
    @Test
    public void testSorted() {
        List<String> one = new ArrayList<>();
        Collections.addAll(one, "22", "41", "44", "33", "13");

        /**
         * map可以将一种类型的流转化为另外一种类型的流
         */
        Stream<Integer> integerStream = one.stream().map((String str) -> {
            return Integer.parseInt(str);
        });

//        integerStream.sorted((Integer o1, Integer o2) -> {
//            return o2 - o1;
//        }).forEach(System.out::println);
        integerStream.sorted((o1, o2) -> o1 - o2).forEach(System.out::println);
    }

    /**
     * 去除重复元素
     */
    @Test
    public void testDistinct() {
        Stream<Integer> integerStream = Stream.of(22, 33, 22, 44, 55, 11, 44);
        integerStream.distinct().forEach(System.out::println);
        Stream<String> stream = Stream.of("aa", "bb", "gg", "dd", "aa", "bb");
        stream.distinct().forEach(System.out::println);
    }

    /**
     * distinct对自定义对象去除重复，自定义对象需要重写hashcode和equal方法
     */
    @Test
    public void testDistinct2() {
        Stream<Person> stream = Stream.of(
                new Person("貂蝉", 18),
                new Person("杨玉环", 20),
                new Person("杨玉环", 21),
                new Person("西施", 17),
                new Person("西施", 17),
                new Person("王昭君", 25)
        );
        stream.distinct().forEach(System.out::println);
    }

    /**
     * allMatch必须全部匹配
     * anyMatch只需要一个满足就行
     * noneMatch 所有都不满足
     */
    @Test
    public void testMatch() {
        Stream<Integer> integerStream = Stream.of(22, 33, 22, 44, 55, 11, 44);
//        boolean b = integerStream.allMatch((Integer i) -> {
//            return i > 33;
//        });
//        System.out.println(b);

//        boolean c = integerStream.anyMatch(ii -> ii > 33);
//        System.out.println(c);

        boolean d = integerStream.noneMatch(ii -> ii > 100);
        System.out.println(d);
    }

    /**
     * 寻找元素
     */
    @Test
    public void testFind() {
        Stream<Integer> stream = Stream.of(33, 11, 22, 5);
//        Optional<Integer> first = stream.findFirst();
        Optional<Integer> first = stream.findAny();
        System.out.println(first.get());
    }

    /**
     * 最大值、最小值
     */
    @Test
    public void testMax_Min() {
        Optional<Integer> max = Stream.of(33, 11, 22, 5, 88, 66).max((o1, o2) -> o1 - o2);
        System.out.println(max.get());

        Optional<Integer> min = Stream.of(33, 11, 22, 5, 88, 66).min((o1, o2) -> o1 - o2);
        System.out.println(min.get());
    }

    /**
     * 求总和
     */
    @Test
    public void testStreamToOther() {
        Stream<Person> stream = Stream.of(
                new Person("貂蝉", 18),
                new Person("杨玉环", 20),
                new Person("杨玉环", 20),
                new Person("西施", 17),
                new Person("西施", 17),
                new Person("王昭君", 25)
        );
//        Optional<Person> max = stream.collect(Collectors.maxBy((s1, s2) -> s1.getAge() - s2.getAge()));
//        System.out.println(max.get());

        // 求总和
        Integer sum = stream.collect(Collectors.summingInt(s -> s.getAge()));
        System.out.println(sum);
    }

    /**
     * T reduce(T identity, BinaryOperator<T> accumulator);
     * T identity：默认值
     * BinaryOperator<T> accumulator：对数据进行处理的方式
     */
    @Test
    public void testReduce() {
        Integer reduce = Stream.of(4, 5, 2, 3).reduce(0, (x, y) -> {
            System.out.println("x=" + x + ",y=" + y);
            return x + y;
        });
        System.out.println("reduce=" + reduce);

        Integer reduce2 = Stream.of(4, 5, 2, 3).reduce(0, (x, y) -> {
            System.out.println("x=" + x + ",y=" + y);
            return x > y ? x : y;
        });
        System.out.println("reduce2=" + reduce2);
    }

    @Test
    public void testMapReduce() {
        /**
         * 找出年龄最大的
         */
        Integer reduce = Stream.of(
                new Person("貂蝉", 18),
                new Person("杨玉环", 20),
                new Person("杨玉环", 20),
                new Person("西施", 17),
                new Person("西施", 17),
                new Person("王昭君", 25))
                .map(Person::getAge)
                .reduce(0, Math::max);
        System.out.println(reduce);

        /**
         * 统计a出现的次数
         */
        Stream<String> aCount = Stream.of("a", "b", "a", "b", "a", "b", "c", "dd");
        Integer count = aCount.map((String str) -> {
            if ("a".equals(str)) {
                return 1;
            } else {
                return 0;
            }
        }).reduce(0, Integer::sum);
        System.out.println(count);
    }

    @Test
    public void testNumericStream() {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);
        stream.filter(n -> n > 3).forEach(System.out::println);

        /**
         * IntStream mapToInt(ToIntFunction<? super T> mapper);
         * IntStream：内部操作的是int类型的数据，就可以节省内存，减少自动装箱和拆箱
         */
        IntStream intStream = Stream.of(1, 2, 3, 4, 5, 6).mapToInt((Integer::intValue));
        intStream.filter(n -> n > 3).forEach(System.out::println);
    }

    @Test
    public void testContact(){
        Stream<String> stream1 = Stream.of("张三");
        Stream<String> stream2 = Stream.of("李四");

        // 两个流合并之后无法操作之前的流
        Stream<String> newStream = Stream.concat(stream1, stream2);
        newStream.forEach(System.out::println);
    }


}
