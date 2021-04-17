package Fork_Join;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * Fork、Join框架 新的线程框架：
 * 1、分治法、工作窃取算法
 */
public class Test01 {

    /**
     * 使用fork/Join框架计算1-10000的和，当一个任务的计算量大于3000时就拆分任务，数量小于3000时计算
     */
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        ForkJoinPool pool = new ForkJoinPool();
        SumRecursiveTask task = new SumRecursiveTask(1, 999999999999L);
        Long result = pool.invoke(task);
        System.out.println("result:" + result);
        long end = System.currentTimeMillis();
        System.out.println("消耗时间：" + (end - start));
    }
}
// 1、创建一个求和任务
// RecursiveTask：一个任务

class SumRecursiveTask extends RecursiveTask<Long> {
    // 要拆分的临界值
    private static final long THRESHOLD = 3000L;

    //起始值
    private final long start;
    private final long end;

    SumRecursiveTask(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        long length = end - start;
        if (length < THRESHOLD) {
            // 计算
            long sum = 0;
            for (long i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        } else {
            // 拆分
            long mid = (start + end) / 2;
            SumRecursiveTask left = new SumRecursiveTask(start, mid);
            left.fork();
            SumRecursiveTask right = new SumRecursiveTask(mid + 1, end);
            right.fork();
            return left.join() + right.join();
        }
    }
}
