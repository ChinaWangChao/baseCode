package Lambda.Demo01;

/**
 * Lambda的前提条件：方法的参数或者变量的类型是接口；这个接口中只能有一个抽象方法。
 */
public class Test01 {
    public static void goSmoking(Smokeable smokeable) {
        int i = smokeable.smoking("中华");
        System.out.println("返回值" + i);
    }

    public static void main(String[] args) {
        goSmoking(new Smokeable() {
            @Override
            public int smoking(String name) {
                System.out.println("匿名内部抽了" + name + "的香烟");
                return 5;

            }
        });

        goSmoking((String name) -> {
            System.out.println(name);
            return 0;
        });


    }


}
