package demo08_completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description: 计算完成时会调
 * @Author: wangchao
 * @Date: 2021/3/10
 */
public class Test01 {
    public static ExecutorService executorService = Executors.newFixedThreadPool(10);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("main....start.....");
//        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
//            System.out.println("当前线程 ：" + Thread.currentThread().getId());
//            int i = 10 / 2;
//            System.out.println("运行结果：" + i);
//        }, executorService);

        /**
         * 方法完成后的感知
         */
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("当前线程 ：" + Thread.currentThread().getId());
            int i = 10 / 0;
            System.out.println("运行结果：" + i);
            return i;
        }, executorService).whenComplete((res, exception) -> {
            // 虽然能得到异常信息，但是没法修改结果
            System.out.println("异步任务成功完成了....结果是:" + res + "异常是:" + exception);
        }).exceptionally(throwable -> {
            // 感知异常，同时返回默认值
            return 10;
        });
        Integer integer = future.get();
        System.out.println("main....end...." + integer);
    }
}
