package stream.demo05;


import java.util.Objects;

public class Student {
    private String id;
    private String name;
    private String techId;
    // 重写hashCode及equals方法(id及name相同就为同一个学生)


    public Student(String id, String name, String techId) {
        this.id = id;
        this.name = name;
        this.techId = techId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTechId() {
        return techId;
    }

    public void setTechId(String techId) {
        this.techId = techId;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Student)) {
            return false;
        }
        Student student = (Student) obj;
        return Objects.equals(id, student.getId()) && Objects.equals(name, student.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", techId='" + techId + '\'' +
                '}';
    }
}