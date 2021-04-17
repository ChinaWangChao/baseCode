import java.io.File;
import java.io.IOException;

/**
 * @description:
 * @Author: wangchao
 * @Date: 2021/4/11
 */
public class baseMain {
    public static void main(String[] args) throws IOException {
        String property = System.getProperty("user.dir");
        System.out.println(property);
        File file = new File("..");
        System.out.println(file.getCanonicalPath());

        String s = baseMain.class.getResource("/").toString();
        String ss = baseMain.class.getResource("/").getPath();
        String s2 = baseMain.class.getResource("").toString();
        System.out.println(s);
        System.out.println(s2);

    }
}
