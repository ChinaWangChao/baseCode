package printStream;

import java.io.IOException;
import java.io.PrintStream;

/**
 * @description:
 * @Author: wangchao
 * @Date: 2021/4/17
 */
public class Demo01 {
    public static void main(String[] args) throws IOException {
        System.out.println(97);
        PrintStream ps = new PrintStream("12.txt");
        System.setOut(ps);
        System.out.println(99);
    }
}
