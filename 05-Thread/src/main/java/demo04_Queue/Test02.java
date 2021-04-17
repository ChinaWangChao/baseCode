package demo04_Queue;

import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * @description: 无边界队列（非阻塞队列）
 * @Author: wangchao
 * @Date: 2020/12/6
 */
public class Test02 {
    public static void main(String[] args) {
        ConcurrentLinkedDeque<Object> queue = new ConcurrentLinkedDeque<>();
        queue.add("java");
        queue.add("html");
        queue.add("js");
        queue.add("python");
        // poll 去除
        System.out.println(queue.poll());
        System.out.println(queue.size());
        // 瞥一眼
        System.out.println(queue.peek());
        System.out.println(queue.size());

    }
}
