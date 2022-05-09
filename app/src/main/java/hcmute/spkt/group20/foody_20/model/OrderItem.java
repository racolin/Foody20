package hcmute.spkt.group20.foody_20.model;

import com.google.firebase.firestore.Exclude;

import java.io.Serializable;

/*OK*/
public class OrderItem implements Serializable {
    private Meal meal;//
    private String meal_id;
    private int amount;
    private int price;

    public OrderItem() {

    }

    public OrderItem(Meal meal, int amount, int price) {
        this.meal = meal;
        this.amount = amount;
        this.price = price;
    }

    public String getMeal_id() {
        return meal_id;
    }

    public void setMeal_id(String meal_id) {
//        Load meal
        this.meal_id = meal_id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAmount() {
        return String.valueOf(amount);
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Exclude
    public Meal getMeal() {
        return meal;
    }

    @Exclude
    public void setMeal(Meal meal) {
        this.meal = meal;
    }
}

