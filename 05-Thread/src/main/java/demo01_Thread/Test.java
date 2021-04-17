package demo01_Thread;

/**
 * @description: 调用Thread类中的start方法，开启新的线程，执行run方法
 * void start() 使该线程开始执行  java虚拟机调用该线程的run方法。
 * 多次启动一个线程是非法的
 * @Author: wangchao
 * @Date: 2020/12/6
 */
public class Test {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        for (int i = 0; i < 30; i++) {
            System.out.println(Thread.currentThread().getName());
        }
    }
}
