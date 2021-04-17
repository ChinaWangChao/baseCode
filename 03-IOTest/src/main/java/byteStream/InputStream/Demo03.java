package byteStream.InputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @description:
 * @Author: wangchao
 * @Date: 2021/4/17
 */
public class Demo03 {
    public static void main(String[] args) {
        File sourceFile = new File("03-IOTest" + File.separator + "test.jpg");
        File targetFile = new File("03-IOTest" + File.separator + "test2.jpg");
        try (FileInputStream fis = new FileInputStream(sourceFile)) {
            try (FileOutputStream fos = new FileOutputStream(targetFile)) {
                int len;
                byte[] b = new byte[1024];
                while (((len = fis.read(b)) != -1)) {
                    fos.write(b, 0, len);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
