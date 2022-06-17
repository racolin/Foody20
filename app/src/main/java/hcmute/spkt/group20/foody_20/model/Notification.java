package hcmute.spkt.group20.foody_20.model;

import java.io.Serializable;
import java.util.Date;

import hcmute.spkt.group20.foody_20.Support;

public class Notification implements Serializable {

    private int id;
    private int user_id;
    private String title;
    private String description;
    private Date time_created;

    public Notification() {

    }

    public Notification(int id, int user_id, String title, String description, Date time_created) {
        this.id = id;
        this.user_id = user_id;
        this.title = title;
        this.description = description;
        this.time_created = time_created;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getTime_created() {
        return time_created;
    }

    public void setTime_created(Date time_created) {
        this.time_created = time_created;
    }

    public String toSaveString() {
        return String.format("INSERT INTO notification VALUES(null, %d, '%s', '%s', '%s')",
                user_id, title, description, Support.toDateString(time_created, "yyyy-MM-dd HH:mm:ss"));
    }
}