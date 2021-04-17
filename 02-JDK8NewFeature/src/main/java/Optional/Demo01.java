package Optional;

import org.junit.Test;

import java.util.Optional;

public class Demo01 {

    @Test
    public void test01(){
        String username = "king";
        if(username != null){
            System.out.println("welecome "+username);
        }else {
            System.out.println("error.....");
        }
    }

    @Test
    public void test02(){
        /**
         * ofNullable：可以传入空值
         */
        Optional<Object> op = Optional.ofNullable(null);
        Optional<Object> op2 = Optional.ofNullable("king");
        System.out.println(op2);
        System.out.println(op2.get());
        System.out.println(op);
    }

    @Test
    public void test03(){
        Optional<String> o1 = Optional.of("凤姐");
        Optional<String> o2 = Optional.empty();

        o2.ifPresent(s->{
            System.out.println("有值："+s);
        });
    }

    @Test
    public void test04(){
        Optional<String> o1 = Optional.of("凤姐");
        Optional<String> o2 = Optional.empty();

    }

}
