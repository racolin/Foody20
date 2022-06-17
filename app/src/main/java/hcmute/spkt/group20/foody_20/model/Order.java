package hcmute.spkt.group20.foody_20.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import hcmute.spkt.group20.foody_20.Support;

public class Order implements Serializable {

    private int id;
    private int user_id;
    private int shop_id;
    private Date time_start;
    private Date time_end;
    private String status;
    private String cause;

    public Order() {

    }

    public Order(int id, int user_id, int shop_id, Date time_start, Date time_end, String status, String cause) {
        this.id = id;
        this.user_id = user_id;
        this.shop_id = shop_id;
        this.time_start = time_start;
        this.time_end = time_end;
        this.status = status;
        this.cause = cause;
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

    public int getShop_id() {
        return shop_id;
    }

    public void setShop_id(int shop_id) {
        this.shop_id = shop_id;
    }

    public Date getTime_end() {
        return time_end;
    }

    public void setTime_end(Date time_end) {
        this.time_end = time_end;
    }

    public Date getTime_start() {
        return time_start;
    }

    public void setTime_start(Date time_start) {
        this.time_start = time_start;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public String toSaveString() {
        return String.format("INSERT INTO `order` VALUES(null, %d, %d, '%s', '%s', '%s', '%s')", user_id, shop_id,
                Support.toDateString(time_start, "yyyy-MM-dd HH:mm:ss"),
                Support.toDateString(time_end, "yyyy-MM-dd HH:mm:ss"),
                status, cause);
    }

    public String toUpdateString() {
        return String.format("UPDATE `order` SET status='%s', cause='%s' WHERE id=%d",
                status, cause, id);
    }
}
