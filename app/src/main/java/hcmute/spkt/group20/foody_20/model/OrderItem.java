package hcmute.spkt.group20.foody_20.model;


import java.io.Serializable;

/*OK*/
public class OrderItem implements Serializable {

    private int id;
    private int order_id;
    private int meal_id;
    private int amount;
    private int price;

    public OrderItem() {

    }

    public OrderItem(int id, int order_id, int meal_id, int amount, int price) {
        this.id = id;
        this.order_id = order_id;
        this.meal_id = meal_id;
        this.amount = amount;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getMeal_id() {
        return meal_id;
    }

    public void setMeal_id(int meal_id) {
        this.meal_id = meal_id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String toSaveString() {
        return String.format("INSERT INTO order_item VALUES(null, %d, %d, %d, %d)",order_id, meal_id, amount, price);
    }
}

