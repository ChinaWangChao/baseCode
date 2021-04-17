package stream.demo03;

import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @description:
 * @Author: wangchao
 * @Date: 2020/11/29
 */
public class StreamFunctionToOther {
    /**
     * 分组
     */
    @Test
    public void testGroup() {
        Stream<Person> personStream = Stream.of(
                new Person("貂蝉", 18),
                new Person("杨玉环", 20),
                new Person("杨颖", 20),
                new Person("西施", 17),
                new Person("东施", 17),
                new Person("王昭君", 25)
        );

        // 根据年龄分组
//        Map<Integer, List<Person>> map = personStream.collect(Collectors.groupingBy(s -> s.getAge()));
//        Map<Integer, List<Person>> map = personStream.collect(Collectors.groupingBy(Person::getAge));

        // 变换分组条件
        Map<String, List<Person>> map = personStream.collect(Collectors.groupingBy((s) -> {
            if (s.getAge() < 18) {
                return "未成年";
            } else {
                return "成年";
            }
        }));

        map.forEach((k, v) -> {
            System.out.println(k + "<-->" + v);
        });
    }

    /**
     * 多级分组
     */
    @Test
    public void testCustomGroup() {
        Stream<Person> personStream = Stream.of(
                new Person("貂蝉", 18, 67),
                new Person("杨玉环", 20, 22),
                new Person("杨颖", 20, 55),
                new Person("西施", 17, 89),
                new Person("东施", 17, 45),
                new Person("王昭君", 25, 60)
        );

        // 先根据年龄分组 ，每组中再根据成绩分组
        Map<Integer, Map<String, List<Person>>> map = personStream.
                collect(Collectors.groupingBy(Person::getAge, Collectors.groupingBy(s -> {
                    if (s.getScore() >= 60) {
                        return "及格";
                    } else {
                        return "不及格";
                    }
                })));
        map.forEach((k, v) -> {
            System.out.println(k);
            v.forEach((k1, v1) -> {
                System.out.println("\t" + k1 + ":" + v1);
            });
        });
    }

    /**
     * 分区
     */
    @Test
    public void testPartitionGroup() {
        Stream<Person> personStream = Stream.of(
                new Person("貂蝉", 18, 67),
                new Person("杨玉环", 20, 22),
                new Person("杨颖", 20, 55),
                new Person("西施", 17, 89),
                new Person("东施", 17, 45),
                new Person("王昭君", 25, 60)
        );
        Map<Boolean, List<Person>> map = personStream.collect(Collectors.partitioningBy(p -> {
            return p.getScore() > 60;
        }));
        map.forEach((k, v) -> {
            System.out.println(k + "<-->" + v);
        });
    }

    /**
     * 拼接
     */
    @Test
    public void testJoin() {
        Stream<Person> personStream = Stream.of(
                new Person("貂蝉", 18, 67),
                new Person("杨玉环", 20, 22),
                new Person("杨颖", 20, 55),
                new Person("西施", 17, 89),
                new Person("东施", 17, 45),
                new Person("王昭君", 25, 60)
        );
        Stream<String> stream = personStream.map(Person::getName);
//        String str = stream.collect(Collectors.joining("__"));
        String str = stream.collect(Collectors.joining("__","pre","suffix"));
        System.out.println(str);

    }
}
