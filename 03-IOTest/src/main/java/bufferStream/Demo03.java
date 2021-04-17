package bufferStream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @description:
 * @Author: wangchao
 * @Date: 2021/4/17
 */
public class Demo03 {
    public static void main(String[] args) throws IOException {
        File sourceFile = new File("03-IOTest" + File.separator + "5.txt");
        // 创建流对象
        BufferedWriter bw = new BufferedWriter(new FileWriter(sourceFile));
        // 写出数据
        bw.write("南京");
        // 写出换行
        bw.newLine();
        bw.write("程序");
        bw.newLine();
        bw.write("员");
        bw.newLine();
        // 释放资源
        bw.close();
    }
}
