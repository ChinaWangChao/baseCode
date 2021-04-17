package byteStream.OutputStream;

import java.io.File;
import java.io.FileOutputStream;

/**
 * @description: 数据追加
 * @Author: wangchao
 * @Date: 2021/4/17
 */
public class Demo05 {
    public static void main(String[] args) {
        File file = new File("03-IOTest" + File.separator + "4.txt");
        try (FileOutputStream fos = new FileOutputStream(file,true)) {
            // 写出从索引2开始，2个字节。索引2是c，两个字节，也就是cd。
            fos.write("abcde".getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
