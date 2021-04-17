package demo05_ThreadPool.ExectorsTest;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @description: newScheduledThreadPool 可计划执行任务，例如选择三秒收执行，如下
 * @Author: wangchao
 * @Date: 2020/12/6
 */
public class newScheduledThreadPoolTest {
    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(3);
        for (int i = 0; i < 100; i++) {
            executorService.schedule(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
                // 三秒后执行
            }, 3, TimeUnit.SECONDS);
        }
        executorService.shutdown();
    }
}
