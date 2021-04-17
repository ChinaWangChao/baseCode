package byteStream.InputStream;

import java.io.File;
import java.io.FileInputStream;

/**
 * @description:
 * @Author: wangchao
 * @Date: 2021/4/17
 */
public class Demo01 {
    public static void main(String[] args) {
        File file = new File("03-IOTest" + File.separator + "5.txt");
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            int b;
            while ((b = fileInputStream.read()) != -1) {
                System.out.println((char) b);
            }
        } catch (Exception e) {

        }

    }
}
