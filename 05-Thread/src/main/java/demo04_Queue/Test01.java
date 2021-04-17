package demo04_Queue;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 * @description: 阻塞队列
 * @Author: wangchao
 * @Date: 2020/12/6
 */
public class Test01 {
    public static void main(String[] args) throws InterruptedException {
        // 阻塞队列设置最多容纳3个
        BlockingDeque<String> queue = new LinkedBlockingDeque<>(3);
        queue.offer("css");
        queue.offer("html");
        queue.offer("java");
        System.out.println(queue.poll());
        // 三秒之内能不能进队列，能的话就进去
        queue.offer("python", 3, TimeUnit.SECONDS);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }
}
