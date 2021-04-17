package transformationStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @description: java.io.InputStreamReader
 * * * 转换流`java.io.InputStreamReader`，是Reader的子类，
 * * * * 是从字节流到字符流的桥梁。它读取字节，并使用指定的字符集将其解码为字符。它的字符集可以由名称指定，也可以接受平台的默认字符集
 * @Author: wangchao
 * @Date: 2021/4/17
 */
public class Demo01 {
    public static void main(String[] args) throws IOException {
        File sourceFile = new File("03-IOTest" + File.separator + "5.txt");
        InputStreamReader inputStreamReader1 = new InputStreamReader(new FileInputStream(sourceFile));
        InputStreamReader inputStreamReader2 = new InputStreamReader(new FileInputStream(sourceFile), "GBK");
        int read;
        // 使用默认编码字符流读取,乱码
        while ((read = inputStreamReader1.read()) != -1) {
            System.out.println((char) read);
        }
        inputStreamReader1.close();

        // 使用指定编码字符流读取,正常解析
        while ((read = inputStreamReader2.read()) != -1) {
            System.out.println((char) read);
        }
        inputStreamReader2.close();


    }
}
