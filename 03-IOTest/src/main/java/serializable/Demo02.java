package serializable;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * @description: ObjectInputStream 对象输入流
 * @Author: wangchao
 * @Date: 2021/4/17
 */
public class Demo02 {
    public static void main(String[] args) throws Exception {
        File file = new File("03-IOTest" + File.separator + "student.txt");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        Student student = (Student) ois.readObject();
        System.out.println(student);
    }
}
