package byteStream.OutputStream;

import java.io.File;
import java.io.FileOutputStream;

/**
 * @description:
 * @Author: wangchao
 * @Date: 2021/4/17
 */
public class Demo02 {
    public static void main(String[] args) {
        // 使用try会自动关闭流
        try (FileOutputStream fos = new FileOutputStream("03-IOTest" + File.separator + "1.txt")) {
            // a
            fos.write(2);
            // b
            fos.write(3);
            // c
            fos.write(4);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
