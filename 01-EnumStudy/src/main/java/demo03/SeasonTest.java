package demo03;

/**
 * @description:
 * @Author: wangchao
 * @Date: 2020/11/29
 */
public class SeasonTest {
    public static void main(String[] args) {
        Season spring = Season.SPRING;
        System.out.println(spring);
        System.out.println(spring.getSeasonName());
        System.out.println(spring.getSeasonDesc());
        System.out.println(spring.getClass().getSuperclass());
        /**
         * 结果如下：
         *
         * SPRING
         * 春天
         * 春暖花开
         * class java.lang.Enum
         */

        System.out.println("=============================================================");

        /**
         * 遍历所有枚举
         */
        Season[] seasons = Season.values();
        for (Season season : seasons) {
            System.out.println(season);
        }

        System.out.println("------Thread中的枚举---------");
        Thread.State[] values = Thread.State.values();
        for (Thread.State state : values) {
            System.out.println(state);
        }

        System.out.println("=============================================================");

        /**
         * valueOf创建枚举
         */
        Season AUTUMN = Season.valueOf("AUTUMN");
        System.out.println(AUTUMN);
        AUTUMN.show();
    }
}
