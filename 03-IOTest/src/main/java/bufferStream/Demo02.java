package bufferStream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @description:
 * @Author: wangchao
 * @Date: 2021/4/17
 */
public class Demo02 {
    public static void main(String[] args) throws IOException {
        File sourceFile = new File("03-IOTest" + File.separator + "5.txt");
        BufferedReader br = new BufferedReader(new FileReader(sourceFile));
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();
    }
}
