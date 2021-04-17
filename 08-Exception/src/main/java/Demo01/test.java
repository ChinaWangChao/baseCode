package Demo01;

/**
 * @description: JDK1.7开始，java引入了 try-with-resources 声明，将 try-catch-finally 简化为 try-catch，这其实是一种语法糖，
 * 在编译时会进行转化为 try-catch-finally 语句。
 * 新的声明包含三部分：try-with-resources 声明、try 块、catch 块。
 * 它要求在 try-with-resources 声明中定义的变量实现了 AutoCloseable 接口，这样在系统可以自动调用它们的close方法，从而替代了finally中关闭资源的功能
 * @Author: wangchao
 * @Date: 2021/1/31
 */
public class test {
    public static void main(String[] args) {
        try (MyAutoCloseA a = new MyAutoCloseA();
             MyAutoCloseB b = new MyAutoCloseB()) {
            a.test();
            b.test();
        } catch (Exception e) {
            System.out.println("Main: exception");
            System.out.println(e.getMessage());
            Throwable[] suppressed = e.getSuppressed();
            // 输出close的异常
            for (int i = 0; i < suppressed.length; i++) {
                System.out.println(suppressed[i].getMessage());
            }
        }
    }
}
