package Guava;

import com.google.common.base.Preconditions;

public class Test01 {
    public static void main(String[] args) {
        int a = 1;
        int b = 1;
        if (!(a == 1 && b == 1)) {
            System.out.println("ok");
        } else {
            System.out.println("false");
        }
        Preconditions.checkArgument(a == 1 || b == 1, "不允许同时为1");
    }
}
