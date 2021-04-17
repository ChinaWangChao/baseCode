package demo02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * @description: 通过反射获取对象
 * @Author: wangchao
 * @Date: 2020/11/29
 */
public class Test01 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("04-Relect" + File.separator + "config.properties"));
        String line;
        while ((line = br.readLine()) != null) {
            Class aClass = Class.forName(line);
            Fruit fruit = (Fruit) aClass.newInstance();
            fruit.squeeze();
        }
    }

}
