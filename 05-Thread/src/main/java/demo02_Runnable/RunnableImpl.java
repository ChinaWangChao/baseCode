package demo02_Runnable;

/**
 * @description:
 * @Author: wangchao
 * @Date: 2020/12/6
 */
public class RunnableImpl implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 30; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }
}
