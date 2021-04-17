package demo08_completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description: 线程串行化方法
 * <p>
 * <p>
 * *线程串行化
 * *1、thenRun：不能获取到上一步的执行结果
 * *2、thenAcceptAsync 能接受上一步结果，但是无返回值
 * *3、thenApplyAsync 能接受上一步结果，且有返回值
 * @Author: wangchao
 * @Date: 2021/3/10
 */
public class Test03 {
    public static ExecutorService executorService = Executors.newFixedThreadPool(10);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("main....start.....");


//        CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> {
//            System.out.println("当前线程 ：" + Thread.currentThread().getId());
//            int i = 10 / 2;
//            System.out.println("运行结果：" + i);
//            return i;
//        }, executorService).thenRunAsync(() -> {
//            System.out.println("任务二启动了");
//        }, executorService);

//        System.out.println("main....end....");
//
//
//        CompletableFuture.supplyAsync(() -> {
//            System.out.println("当前线程 ：" + Thread.currentThread().getId());
//            int i = 10 / 2;
//            System.out.println("运行结果：" + i);
//            return i;
//        }, executorService).thenAcceptAsync(res -> {
//            System.out.println("任务三执行。。。。" + res);
//        }, executorService);


        CompletableFuture<String> feature = CompletableFuture.supplyAsync(() -> {
            System.out.println("当前线程 ：" + Thread.currentThread().getId());
            int i = 10 / 2;
            System.out.println("运行结果：" + i);
            return i;
        }, executorService).thenApplyAsync(res -> {
            System.out.println("任务四启动了。。。" + res);
            return "hello" + res;
        }, executorService);
        System.out.println("main....end...." + feature.get());
    }
}
