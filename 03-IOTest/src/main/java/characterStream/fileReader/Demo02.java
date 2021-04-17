package characterStream.fileReader;


import java.io.File;
import java.io.FileReader;

/**
 * @description:
 * @Author: wangchao
 * @Date: 2021/4/17
 */
public class Demo02 {
    public static void main(String[] args) {
        File file = new File("03-IOTest" + File.separator + "2.txt");
        try (FileReader fileReader = new FileReader(file)) {
            int len;
            char[] cbuf = new char[2];
            while (((len = fileReader.read(cbuf)) != -1)) {
                System.out.println(new String(cbuf,0,len));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
