package characterStream.fileReader;

import java.io.File;
import java.io.FileReader;

/**
 * @description: 字符流读取，方便读取中文
 * @Author: wangchao
 * @Date: 2021/4/17
 */
public class Demo01 {
    public static void main(String[] args) {
        File file = new File("03-IOTest" + File.separator + "2.txt");
        try (FileReader fileReader = new FileReader(file)) {
            int b;
            while (((b = fileReader.read()) != -1)) {
                System.out.println((char) b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
