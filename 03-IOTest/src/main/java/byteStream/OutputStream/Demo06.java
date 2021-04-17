package byteStream.OutputStream;

import java.io.File;
import java.io.FileOutputStream;

/**
 * @description: 数据追加
 * @Author: wangchao
 * @Date: 2021/4/17
 */
public class Demo06 {
    public static void main(String[] args) {
        File file = new File("03-IOTest" + File.separator + "5.txt");
        try (FileOutputStream fos = new FileOutputStream(file,true)) {
            // 定义字节数组
            byte[] words = {97,98,99,100,101};
            // 遍历数组
            for (int i = 0; i < words.length; i++) {
                // 写出一个字节
                fos.write(words[i]);
                // 写出一个换行, 换行符号转成数组写出
                fos.write("\r\n".getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
