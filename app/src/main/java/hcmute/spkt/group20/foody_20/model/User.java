package hcmute.spkt.group20.foody_20.model;

/*OK*/

import android.util.Log;

import java.io.Serializable;
import java.util.Date;

import hcmute.spkt.group20.foody_20.R;
import hcmute.spkt.group20.foody_20.Support;

public class User implements Serializable {

    private int id;
    private String full_name;
    private int gender;
    private Date dob;
    private String phone;
    private String gmail;
    private String facebook;
    private String address;
    private String username;
    private String password;
    private int image;

    public User() {
        this.id = -1;
        this.full_name = "";
        this.gender = 1;
        this.dob = new Date();
        this.phone = "";
        this.gmail = "";
        this.facebook = "";
        this.address = "";
        this.username = "";
        this.password = "";
        this.image = R.drawable.avatar_user_default;
    }

    public User(int id, String full_name, int gender, Date dob, String phone,
                String gmail, String facebook, String address, String username, String password, int image) {
        this.id = id;
        this.full_name = full_name;
        this.gender = gender;
        this.dob = dob;
        this.phone = phone;
        this.gmail = gmail;
        this.facebook = facebook;
        this.address = address;
        this.username = username;
        this.password = password;
        this.image = image;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String toSaveString() {
        return String.format("INSERT INTO user VALUES(null, '%s', %d, '%s', '%s', '%s', '%s', '%s', '%s', '%s', %d)",
                full_name, gender, Support.toDateString(dob, "yyyy-MM-dd HH:mm:ss"),
                phone, gmail, facebook, address, username, password, image);
    }

    public String toUpdateString() {
        return String.format("UPDATE user SET full_name='%s', gender=%d, dob='%s', phone='%s', " +
                        "gmail='%s', facebook='%s', address='%s', username='%s', password='%s', image=%d WHERE id=%d",
                full_name, gender, Support.toDateString(dob, "yyyy-MM-dd HH:mm:ss"),
                phone, gmail, facebook, address, username, password, image, id);
    }
}
