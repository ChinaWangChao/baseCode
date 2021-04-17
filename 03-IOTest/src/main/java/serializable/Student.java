package serializable;

import java.io.Serializable;

/**
 * @description:
 * @Author: wangchao
 * @Date: 2021/4/17
 */
public class Student implements Serializable {

    private static final long serialVersionUID = 601503895126171547L;

    String name;
    int age;
    String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}
