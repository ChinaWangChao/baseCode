package demo06_ThreadSecurity.Test02_lock;

import demo06_ThreadSecurity.Test03_synchronized.RunnableImpl2;

/**
 * 这里是非安全的
 */
public class demo {
    public static void main(String[] args) {
        Runnable runnable = new RunnableImpl2();
        Thread t0 = new Thread(runnable);
        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);

        t0.start();
        t1.start();
        t2.start();
    }
}
