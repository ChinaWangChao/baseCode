package byteStream.OutputStream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @description:
 * @Author: wangchao
 * @Date: 2021/4/17
 */
public class Demo01 {
    public static void main(String[] args) throws IOException {
        // 使用File对象创建流对象
        File file = new File("a.txt");
        FileOutputStream fos = new FileOutputStream(file);

        // 使用文件名称创建流对象
        FileOutputStream fos2 = new FileOutputStream("b.txt");
    }

}
