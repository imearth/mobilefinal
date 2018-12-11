package th.ac.kmitl.a59070161.myfriends;

public class myfriend {
    private int id;
    private String title;
    private String email;
    private String phone;
    private String website;


    public myfriend() {

    }

    public myfriend(int id, String title, String email, String phone, String website) {
        this.id = id;
        this.title = title;
        this.email = email;
        this.phone = phone;
        this.website = website;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getWebsite() {
        return website;
    }

    public void setBody(String website) {
        this.website = website;
    }

}

