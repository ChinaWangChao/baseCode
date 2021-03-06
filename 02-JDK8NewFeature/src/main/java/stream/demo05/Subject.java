package stream.demo05;

public enum Subject {

    Math("1","数学"),

    Chinese("2","汉语"),

    Music("3","音乐"),

    English("4","英语");

    private String value;
    private String desc;

    Subject(String value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public String getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }

}