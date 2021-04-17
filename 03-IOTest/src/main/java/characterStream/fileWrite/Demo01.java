package characterStream.fileWrite;

import java.io.File;
import java.io.FileWriter;

/**
 * @description: 字符流写入
 * @Author: wangchao
 * @Date: 2021/4/17
 */
public class Demo01 {
    public static void main(String[] args) {
        File file = new File("03-IOTest" + File.separator + "6.txt");
        try (FileWriter fw = new FileWriter(file)) {
            fw.write(97);
            fw.write('b');
            fw.write('c');
            fw.write(30000);
            // 刷新缓冲区，流对象可以继续使用。
            fw.flush();
            // 继续写出第2个字符，写出成功
            fw.write("开");
            fw.write("关");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
