package hcmute.spkt.group20.foody_20.model;

import java.io.Serializable;
import java.util.Date;

import hcmute.spkt.group20.foody_20.Support;

/*OK*/

public class Comment implements Serializable {

    private int id;
    private int user_id;
    private int meal_id;
    private Date time_created;
    private float rate;
    private String content;

    public Comment() {

    }

    public Comment(int id, int user_id, int meal_id, Date time_created, float rate, String content) {
        this.id = id;
        this.user_id = user_id;
        this.meal_id = meal_id;
        this.time_created = time_created;
        this.rate = rate;
        this.content = content;
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

    public int getMeal_id() {
        return meal_id;
    }

    public void setMeal_id(int meal_id) {
        this.meal_id = meal_id;
    }

    public Date getTime_created() {
        return time_created;
    }

    public void setTime_created(Date time_created) {
        this.time_created = time_created;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String toSaveString() {
        return String.format("INSERT INTO comment VALUES(null, %d, %d, '%s', %s, '%s')", user_id, meal_id,
                Support.toDateString(time_created, "yyyy-MM-dd HH:mm:ss"), String.valueOf(rate).replace(',','.'), content);
    }
}
