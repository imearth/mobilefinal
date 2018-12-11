package th.ac.kmitl.a59070161.User;

public class User {
    private static User userInstance;
    private int primaryid;
    private String username = null;
    private String password;
    private String name;
    private String age;

    private User() {}
    public static User getUserInstance() {
        if (userInstance == null) {
            userInstance = new User();
        }
        return userInstance;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAge() {
        return age;
    }
    public void setAge(String phonenumber) {
        this.age = phonenumber;
    }
    public int getPrimaryid() {
        return primaryid;
    }
    public void setPrimaryid(int primaryid) {
        this.primaryid = primaryid;
    }
}
