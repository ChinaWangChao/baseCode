package stream.demo01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HelloStream {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "张无忌", "周芷若", "赵敏", "张强", "张三丰");

        //找出所有姓张的
        List<String> zhang = new ArrayList<>();
        for (String name : list) {
            if (name.startsWith("张")) {
                System.out.println(name);
                zhang.add(name);
            }
        }

        //找出三个字的str
        List<String> three = new ArrayList<>();
        for (String name : zhang) {
            if (name.length() == 3) {
                three.add(name);
                System.out.println(name);
            }
        }

        System.out.println(",,,,,,,,,,,,,,,,,,,,.......");
        list.stream()
                .filter((s) -> {
                    return s.startsWith("张");
                })
                .filter((s) -> {
                    return s.length() == 3;
                })
                .forEach(System.out::println);

        System.out.println(",,,,,,,,,,,,,,,,,,,,.......");
        list.stream()
                .filter(s -> s.startsWith("张"))
                .filter(s -> s.length() == 3)
                .forEach(System.out::println);
    }

}
