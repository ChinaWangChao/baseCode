package byteStream.OutputStream;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;

/**
 * @description:
 * @Author: wangchao
 * @Date: 2021/4/17
 */
public class Demo04 {
    public static void main(String[] args) {
        File file = new File("03-IOTest" + File.separator + "4.txt");
        try (FileOutputStream fos = new FileOutputStream(file)) {
            // 写出从索引2开始，2个字节。索引2是c，两个字节，也就是cd。
            fos.write("abcde".getBytes(StandardCharsets.UTF_8), 2, 2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
