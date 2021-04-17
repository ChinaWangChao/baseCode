package demo02_Runnable;

/**
 * @description:
 * @Author: wangchao
 * @Date: 2020/12/6
 */
public class Test {
    public static void main(String[] args) {
        Thread thread = new Thread(new RunnableImpl());
        thread.start();
        for (int i = 0; i < 30; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }

}
