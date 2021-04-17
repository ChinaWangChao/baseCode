package demo02;

/**
 * @description: 测试自定义枚举
 * @Author: wangchao
 * @Date: 2020/11/29
 */
public class CustomEnumSeasonTest {
    public static void main(String[] args) {
        CustomEnumSeason customEnumSeason = CustomEnumSeason.SPRING;
        System.out.println(customEnumSeason);
        System.out.println(customEnumSeason.getSeasonDesc());
        System.out.println(customEnumSeason.getSeasonName());
    }
}
