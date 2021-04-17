package demo05_ThreadPool;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @description: ThreadPoolExecutor 线程池学习 + 底层原理
 * 队列是所有线程任务公用的
 * 流程：
 * 用户提交任务->判断是否大于核心线程数,两个方案
 * *       (1)小于核心线程数则直接给核心线程执行
 * *       (2)大于核心线程数则放入阻塞队列，没满就等待核心线程任务完成；
 * *                若放满了，就创建新的线程跑任务
 * *                    i:新线程数+核心线程数>最大线程数,报错拒绝任务
 * *                    ii:新线程数+核心线程数<=利用新线程和核心线程分摊任务
 * @Author: wangchao
 * @Date: 2020/12/6
 */
public class ThreadPool03 {
    public static void main(String[] args) {
        // 一个核心线程,最大线程数2，3秒没人用就释放，阻塞队列长度3(阻塞队列里面的任务都在等待一个线程)
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                1,
                2,
                //  线程池维护线程所允许的空闲时间
                3,
                // 单位
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(),
                new ThreadFactoryBuilder().setNameFormat("testThread-%d").setDaemon(true).build(),
                new ThreadPoolExecutor.DiscardPolicy());
        // 第一个任务
        pool.execute(new TestThread(1));
        // 第二个任务
        pool.execute(new TestThread(2));
        // 第三个任务
        pool.execute(new TestThread(3));
        // 第四个任务
        pool.execute(new TestThread(4));

//      ======= 最坏的一种情况，上面1任务在核心线程跑，2\3\4任务在阻塞队列等待核心线程任务释放
//      ======= 最坏的情况下此时队列已满，将开辟新的线程，即第二个线程

        // 第五个任务（这时将出现第二个线程）; 此时已经有两个线程了，且阻塞队列已满
        pool.execute(new TestThread(5));
        pool.execute(new TestThread(6));
        pool.shutdown();
    }
}

class TestThread implements Runnable {

    int i = 0;

    public TestThread(int i) {
        this.i = i;
    }

    @Override
    public void run() {
        System.out.println("第" + i + "个任务" + "--" + Thread.currentThread().getName());
    }
}
