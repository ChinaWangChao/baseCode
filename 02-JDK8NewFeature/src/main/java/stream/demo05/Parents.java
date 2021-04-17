package stream.demo05;

public class Parents {
    private String id;
    private String name;
    private String chirldId;
    private String email;

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

    public String getChirldId() {
        return chirldId;
    }

    public void setChirldId(String chirldId) {
        this.chirldId = chirldId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Parents{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", chirldId='" + chirldId + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}