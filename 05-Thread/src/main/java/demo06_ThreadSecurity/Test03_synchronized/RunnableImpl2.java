package demo06_ThreadSecurity.Test03_synchronized;

/**
 * @description:
 * @Author: wangchao
 * @Date: 2020/12/6
 */
public class RunnableImpl2 implements Runnable {
    private int ticket = 500;

    @Override
    public void run() {
        while (true) {
            sellTicket();
        }
    }

    public synchronized void sellTicket() {
        if (ticket > 0) {
            System.out.println(Thread.currentThread().getName() + "-->正在卖第" + ticket + "张票");
            ticket--;
        }
    }
}
