package hcmute.spkt.group20.foody_20.model;

import java.io.Serializable;

public class CartItem implements Serializable {

    private int id;
    private int cart_id;
    private int meal_id;
    private int amount;

    public CartItem() {

    }

    public CartItem(int id, int cart_id, int meal_id, int amount) {
        this.id = id;
        this.cart_id = cart_id;
        this.meal_id = meal_id;
        this.amount = amount;
    }

    public int getCart_id() {
        return cart_id;
    }

    public void setCart_id(int cart_id) {
        this.cart_id = cart_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String toSaveString() {
        return String.format("INSERT INTO cart_item VALUES(null, %d, %d, %d)", cart_id, meal_id, amount);
    }

    public String toUpdateString() {
        return String.format("UPDATE cart_item SET cart_id=%d, meal_id=%d, amount=%d WHERE id=%d", cart_id, meal_id, amount, id);
    }

    public String toDeleteString() {
        return String.format("DELETE FROM cart_item WHERE id=%d", id);
    }
}
