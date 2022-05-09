package hcmute.spkt.group20.foody_20.model;

import com.google.firebase.firestore.Exclude;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/*OK*/

public class Order implements Serializable {
    private String code;//
    private String shop_name;//
    private Date time_end;
    private Date time_start;
    private int price;
    private String status;
    private String cause;
    List<OrderItem> order_items;

    public Order() {

    }

    public Order(Order order) {
        this.code = order.code;
        this.shop_name = order.shop_name;
        this.time_end = order.time_end;
        this.time_start = order.time_start;
        this.price = order.price;
        this.status = order.status;
        this.cause = order.cause;
        this.order_items = order.order_items;
    }

    public Order(String shop_name, Date time_end, Date time_start, int price,
                 String status, String cause, List<OrderItem> order_items) {
        this.shop_name = shop_name;
        this.time_end = time_end;
        this.time_start = time_start;
        this.price = price;
        this.status = status;
        this.cause = cause;
        this.order_items = order_items;
    }

    @Exclude
    public String getShop_name() {
        return shop_name;
    }

    @Exclude
    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
    }

    @Exclude
    public String getCode() {
        return code;
    }

    @Exclude
    public void setCode(String code) {
        this.code = code;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
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

    public List<OrderItem> getOrder_items() {
        return order_items;
    }

    public void setOrder_items(List<OrderItem> order_items) {
        this.order_items = order_items;
    }
}
