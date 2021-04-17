package byteStream.OutputStream;

import java.io.File;
import java.io.FileOutputStream;

/**
 * @description:
 * @Author: wangchao
 * @Date: 2021/4/17
 */
public class Demo03 {
    public static void main(String[] args) {
        File file = new File("03-IOTest" + File.separator + "2.txt");
        try (FileOutputStream fos = new FileOutputStream(file)) {
            fos.write("南京".getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
