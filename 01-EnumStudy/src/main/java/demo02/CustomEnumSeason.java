package demo02;

/**
 * @description: 自定义枚举类
 * @Author: wangchao
 * @Date: 2020/11/29
 */
public class CustomEnumSeason {

    private final String seasonName;
    private final String seasonDesc;

    /**
     * 私有构造方法 无法new
     * @param seasonName
     * @param seasonDesc
     */
    private CustomEnumSeason(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    /**
     * 提供当前多个枚举对象 通过CustomEnumSeason.xxx 获取
     */
    public static final CustomEnumSeason SPRING = new CustomEnumSeason("春天", "春暖花开");
    public static final CustomEnumSeason SUMMER = new CustomEnumSeason("夏天", "夏日炎炎");
    public static final CustomEnumSeason AUTUMN = new CustomEnumSeason("秋天", "秋高气爽");
    public static final CustomEnumSeason WINTER = new CustomEnumSeason("冬天", "冰天雪地");

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    @Override
    public String toString() {
        return "CustomEnumSeason{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }
}
