package demo06_ThreadSecurity.Test01;

/**
 * 这里是非安全的
 */
public class demo {
    public static void main(String[] args) {
        RunnableImpl runnable = new RunnableImpl();
        Thread t0 = new Thread(runnable);
        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);

        t0.start();
        t1.start();
        t2.start();
    }
}
