package hcmute.spkt.group20.foody_20.model;

public class Order {
    private String id;
    private String title;
    private String time_end;
    private String time_start;
    private String status;
    private String cause;
    private int image;
    private String price;
    private String amount;

    public Order() {

    }

    public Order(Order order) {
        this.id = order.id;
        this.title = order.title;
        this.time_end = order.time_end;
        this.time_start = order.time_start;
        this.status = order.status;
        this.cause = order.cause;
        this.image = order.image;
        this.price = order.price;
        this.amount = order.amount;
    }

    public Order(String id, String title, String time_end, String time_start, String status, String cause, int image, String price, String amount) {
        this.id = id;
        this.title = title;
        this.time_end = time_end;
        this.time_start = time_start;
        this.status = status;
        this.cause = cause;
        this.image = image;
        this.price = price;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime_end() {
        return time_end;
    }

    public void setTime_end(String time_end) {
        this.time_end = time_end;
    }

    public String getTime_start() {
        return time_start;
    }

    public void setTime_start(String time_start) {
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

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
