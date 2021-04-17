package demo03_Callable;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @description: Callalble接口支持返回执行结果，需要调用FutureTask.get()得到，此方法会阻塞主进程的继续往下执行，如果不调用不会阻塞。
 * @Author: wangchao
 * @Date: 2020/12/6
 */
public class Test01 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestCallable testCallable = new TestCallable();

        // FutureTask是Callable最重要的类，run方法在这里
        FutureTask futureTask = new FutureTask(testCallable);
        Thread thread = new Thread(futureTask);
        thread.start();
        System.out.println(futureTask.isDone());
        System.out.println(futureTask.get());
        System.out.println(futureTask.isDone());
    }
}

class TestCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        return new Random().nextInt(10);
    }
}
