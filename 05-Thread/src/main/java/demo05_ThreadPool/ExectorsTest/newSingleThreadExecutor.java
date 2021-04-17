package demo05_ThreadPool.ExectorsTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description: newSingleThreadExecutor 单个线程执行
 * @Author: wangchao
 * @Date: 2020/12/6
 */
public class newSingleThreadExecutor {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 100; i++) {
            executorService.execute(() -> System.out.println(Thread.currentThread().getName()));
        }
        executorService.shutdown();
    }
}
