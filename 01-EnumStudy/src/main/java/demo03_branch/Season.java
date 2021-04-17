package demo03_branch;

/**
 * @description:
 * @Author: wangchao
 * @Date: 2020/11/29
 */
public enum Season implements Info {

    /**
     * 提供当前枚举类的多个对象
     */
    SPRING("春天","春暖花开"){
        public void show() {
            System.out.println("春天在哪里？");
        }
    },
    SUMMER("夏天","夏日炎炎"){
        public void show() {
            System.out.println("夏天在哪里？");
        }
    },
    AUTUMN("秋天","秋高气爽"){
        public void show() {
            System.out.println("秋天在哪里");
        }
    },
    WINTER("冬天","冰天雪地"){
        public void show() {
            System.out.println("大约在冬季");
        }
    };

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
}
