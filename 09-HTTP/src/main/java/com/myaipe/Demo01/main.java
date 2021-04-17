package com.myaipe.Demo01;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 用jdk11
 * @Author: wangchao
 * @Date: 2021/2/7
 */
public class main {
    public static void main(String[] args) throws InterruptedException {
        List<String> groupIds = new ArrayList<>(Arrays.asList("10907434497308356067", "10907434497308367075", "10907434497308367263", "10907434497308379130", "10907434497309641621", "10907434497309647011", "10907434497309823004"));
        List<List<String>> partition = Lists.partition(groupIds, 1);
        for (List<String> list : partition) {
            LocalDateTime now = LocalDateTime.now();
            String tome = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            System.out.println(tome + "-执行完:" + JSON.toJSONString(list));
            Thread.sleep(1000 * 60);
        }
        System.out.println();
    }
}
