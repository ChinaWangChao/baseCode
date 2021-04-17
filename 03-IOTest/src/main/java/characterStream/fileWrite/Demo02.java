package characterStream.fileWrite;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @description: 字符流写入
 * @Author: wangchao
 * @Date: 2021/4/17
 */
public class Demo02 {
    public static void main(String[] args) throws IOException {
        File file = new File("03-IOTest" + File.separator + "2.txt");
        // 使用文件名称创建流对象
        FileWriter fw = new FileWriter(file);
        // 字符串
        String msg = "江苏丹阳";

        // 写出字符数组
        fw.write(msg); //江苏丹阳

        // 写出从索引2开始，2个字节。索引2是'丹'，两个字节，也就是'丹阳'。
        fw.write(msg,2,2);	// 丹阳

        // 关闭资源
        fw.close();

    }
}
