package demo05_ThreadPool.ExectorsTest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @description: 制造阻塞 ** 启动一个线程，执行一个线程 **
 * @Author: wangchao
 * @Date: 2020/12/6
 */
public class callableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 50; i++) {
            Future<String> future = executorService.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    Thread.sleep(2000);
                    return Thread.currentThread().getName();
                }
            });
            // 每次执行一个线程
            System.out.println(future.get());
        }

        executorService.shutdown();
    }
}
