package demo08_completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description: 线程组合，前两个必须都完成，才执行下一个
 * <p>
 * <p>
 * *1、feature1.runAfterBothAsync当feature1和feature2都完成之后,执行，无法感知前两个的结果，自己无返回值
 * *2、feature1.thenAcceptBothAsync 当feature1和feature2都完成之后,执行，感知前两个的结果，自己无返回值
 * *3、feature1.thenCombineAsync  当feature1和feature2都完成之后,执行，感知前两个的结果，自己有返回值
 * @Author: wangchao
 * @Date: 2021/3/10
 */
public class Test04 {
    public static ExecutorService executorService = Executors.newFixedThreadPool(10);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("main....start.....");

        CompletableFuture<Integer> feature1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("任务1线程 ：" + Thread.currentThread().getId());
            int i = 10 / 2;
            System.out.println("任务1结果：" + i);
            return i;
        }, executorService);

        CompletableFuture<String> feature2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("任务2线程 ：" + Thread.currentThread().getId());
            System.out.println("任务2结果：");
            return "Hello";
        }, executorService);

        /**
         * 当feature1和feature2都完成之后,执行，无法感知前两个的结果
         */
//        feature1.runAfterBothAsync(feature2, () -> {
//            System.out.println("任务3线程"+Thread.currentThread().getId());
//        }, executorService);
//        System.out.println("main....end....");


//        feature1.thenAcceptBothAsync(feature2, (f1, f2) -> {
//            System.out.println("任务3线程" + Thread.currentThread().getId());
//            System.out.println("任务3，之前的结果" + "f1:" + f1 + ";f2:" + f2);
//        }, executorService);
//        System.out.println("main....end....");


        CompletableFuture<String> stringCompletableFuture = feature1.thenCombineAsync(feature2, (f1, f2) -> {
            System.out.println("任务3线程" + Thread.currentThread().getId());
            return "f1:" + f1 + ";f2:" + f2;
        }, executorService);
        System.out.println("main....end...." + stringCompletableFuture.get());
    }
}
