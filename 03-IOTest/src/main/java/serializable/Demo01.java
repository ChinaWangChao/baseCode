package serializable;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @description: ObjectOutputStream 对象输出流
 * @Author: wangchao
 * @Date: 2021/4/17
 */
public class Demo01 {
    public static void main(String[] args) throws IOException {
        File file = new File("03-IOTest" + File.separator + "student.txt");
        Student student = new Student();
        student.setAddress("南京");
        student.setAge(20);
        student.setName("小王");

        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(file));
        os.writeObject(student);
        os.close();
    }
}
