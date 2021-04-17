package stream.demo04;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test02StreamToCollection {

    @Test
    public void testStreamToList() {
        Stream<String> stream = Stream.of("aa", "bb", "cc", "dd");
        List<String> list = stream.collect(Collectors.toList());
        System.out.println(list);
    }

    @Test
    public void testStreamToSet() {
        Stream<String> stream = Stream.of("aa", "aa", "cc", "dd");
        Set<String> set = stream.collect(Collectors.toSet());
        System.out.println(set);
    }

    @Test
    public void testStreamToArray() {
        Stream<String> stream = Stream.of("aa", "aa", "cc", "dd");
        String[] array = stream.toArray(String[]::new);
        for (String str : array) {
            System.out.println(str);
        }

    }

    @Test
    public void ss() {
        List<Person> personList = new ArrayList<>();
        personList.stream().collect(Collectors.toMap(Person::getName, aa -> aa));
    }

}
