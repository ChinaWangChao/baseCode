package Guava;

import com.google.common.collect.Maps;

import java.util.Map;

public class test {
    public static void main(String[] args) {
        Map<String, String> map = Maps.newHashMapWithExpectedSize(0);
        System.out.println(map);
    }
}
