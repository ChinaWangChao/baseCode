package byteStream.InputStream;


import java.io.File;
import java.io.FileInputStream;

/**
 * @description: 使用数组读取，每次读取多个字节，减少了系统间的IO操作次数，从而提高了读写的效率，建议开发中使用。
 * @Author: wangchao
 * @Date: 2021/4/17
 */
public class Demo02 {
    public static void main(String[] args) {
        File file = new File("03-IOTest" + File.separator + "5.txt");
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            byte[] b = new byte[1024];
            int len;
            // fileInputStream.read(b) 返回有效个数
            while ((len = fileInputStream.read(b)) != -1) {
                System.out.println(new String(b, 0, len));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
