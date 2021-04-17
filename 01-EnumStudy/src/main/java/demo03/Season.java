package demo03;

/**
 * @description:
 * @Author: wangchao
 * @Date: 2020/11/29
 */
public enum Season implements Info {

    /**
     * 提供多个枚举对象
     */
    SPRING("春天", "春暖花开"),
    SUMMER("夏天", "夏日炎炎"),
    AUTUMN("秋天", "秋高气爽"),
    WINTER("冬天", "冰天雪地");

    private final String seasonName;
    private final String seasonDesc;

    Season(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    public void show() {
        System.out.println("这是一个季节");
    }
}
