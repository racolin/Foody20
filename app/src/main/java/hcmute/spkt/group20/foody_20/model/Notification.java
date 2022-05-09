package hcmute.spkt.group20.foody_20.model;

import java.io.Serializable;
import java.util.Date;

public class Notification implements Serializable {
    private String title;
    private String description;
    private Date time_created;

    public Notification() {

    }

    public Notification(String title, String description, Date time_created) {
        this.title = title;
        this.description = description;
        this.time_created = time_created;
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
}