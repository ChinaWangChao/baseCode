package demo05_ThreadPool;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @description: 线程生命周期：新生、就绪、运行、死亡
 * 10个线程 -》任务
 * 线程池是为了节省新生、就绪、死亡的时间
 * @Author: wangchao
 * @Date: 2020/12/6
 */
public class ThreadPool02 {
    public static void main(String[] args) {
        ExecutorService executorService = new ThreadPoolExecutor(
                5,
                5,
                60,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(5),
                new ThreadFactoryBuilder().setNameFormat("itemPushThread-%d").setDaemon(true).build(),
                new ThreadPoolExecutor.DiscardPolicy()
        );
    }
}
