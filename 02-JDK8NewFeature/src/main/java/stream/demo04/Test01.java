package stream.demo04;


import com.sun.tools.javac.util.List;

import java.util.ArrayList;
import java.util.stream.Stream;

public class Test01 {
    public static void main(String[] args) {
        List<String> one = List.of("地理热吗", "镁光", "宋园桥", "老子好", "庄子", "洪七公");
        List<String> two = List.of("老子", "李四", "张小王", "张小美", "张三", "老子", "李四", "洪七公");

        // 第一只队伍：名字三个字的前两位
        Stream<String> stream1 = one.stream().filter(str -> str.length() == 3).limit(2);
//        stream1.forEach(System.out::println);

        // 第二支队伍：只要姓张的，不要前两个
        Stream<String> stream2 = two.stream().filter(str -> str.startsWith("张")).skip(2);
//        stream2.forEach(System.out::println);

        // 将两个队伍合并为一个队伍
        Stream<String> concat = Stream.concat(stream1, stream2);

        // 根据姓名创建Person对象
        // 打印整个队伍的Person对象信息
        concat.map(Person::new).forEach(System.out::println);

    }
}
