package Lambda.Demo02;

public class Test01 {
    public static void main(String[] args) {

        goSwimming(new Swimmable() {
            @Override
            public void swimming() {
                System.out.println("我是匿名内部类");
            }
        });

        goSwimming(()->System.out.println("Lambda--我是匿名内部类"));
    }

    public static void goSwimming(Swimmable s){
        s.swimming();
    }
}
