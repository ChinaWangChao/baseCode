package demo05_ThreadPool.ExectorsTest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @description: 制造阻塞 ** 先启动所有线程，然后在再执行 ** 这个速度快于一个一个线程启动执行
 * * 阻塞之后，3个任务在核心线程，其他的都在阻塞队列里面
 * * 将返回结果放到list里面，2000ms阻塞结束 就会三个任务一起打印
 * @Author: wangchao
 * @Date: 2020/12/6
 */
public class callableTest02 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        List<Future> list = new ArrayList<>();
        // 先启动所有线程，然后在再执行
        for (int i = 0; i < 50; i++) {
            Future<String> future = executorService.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    // 制造阻塞
                    Thread.sleep(2000);
                    return Thread.currentThread().getName();
                }
            });
            list.add(future);
        }
        // 将执行的结果放到list里面，通过list打印，及每次执行线程池中的三个核心线程
        list.forEach(future -> {
            try {
                System.out.println(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });
        executorService.shutdown();
    }
}
