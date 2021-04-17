package demo05_ThreadPool.ExectorsTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description: newFixedThreadPool 指定线程池数
 * @Author: wangchao
 * @Date: 2020/12/6
 */
public class newFixedThreadPoolTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 100; i++) {
            executorService.execute(() -> {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());

            });
        }
        executorService.shutdown();
    }
}
