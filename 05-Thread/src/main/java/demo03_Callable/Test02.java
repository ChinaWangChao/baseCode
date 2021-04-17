package demo03_Callable;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @description:
 * @Author: wangchao
 * @Date: 2020/12/6
 */
public class Test02 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestCallable2 testCallable = new TestCallable2();
        // FutureTask是Callable最重要的类，run方法在这里
        FutureTask futureTask = new FutureTask(testCallable);
        Thread thread = new Thread(futureTask);
        thread.start();
        // 00000.。。 不阻塞
        System.out.println("000000000000");
        System.out.println(futureTask.get());
    }
}

class TestCallable2 implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        Thread.sleep(2000);
        return new Random().nextInt(10);
    }
}
