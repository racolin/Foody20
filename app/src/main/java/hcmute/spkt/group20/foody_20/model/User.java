package hcmute.spkt.group20.foody_20.model;

public class User {
    private String uid;
    private String fullname;
    private boolean gender;
    private String DOB;
    private String phone;
    private String gmail;
    private String facebook;
    private String address;

    public User(String uid, String fullname, boolean gender, String DOB, String phone, String gmail, String facebook, String address) {
        this.uid = uid;
        this.fullname = fullname;
        this.gender = gender;
        this.DOB = DOB;
        this.phone = phone;
        this.gmail = gmail;
        this.facebook = facebook;
        this.address = address;
    }

    public User() {
        this.fullname = "";
        this.gender = true;
        this.DOB = "";
        this.phone = "";
        this.gmail = "";
        this.facebook = "";
        this.address = "";
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid='" + uid + '\'' +
                ", fullname='" + fullname + '\'' +
                ", gender=" + gender +
                ", DOB='" + DOB + '\'' +
                ", phone='" + phone + '\'' +
                ", gmail='" + gmail + '\'' +
                ", facebook='" + facebook + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
