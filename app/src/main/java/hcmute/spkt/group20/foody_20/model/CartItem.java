package hcmute.spkt.group20.foody_20.model;

import com.google.firebase.firestore.Exclude;

public class CartItem {
    private Meal meal;//
    private String meal_id;
    private int amount;

    public CartItem() {

    }

    public CartItem(Meal meal, String meal_id, int amount) {
        this.meal = meal;
        this.meal_id = meal_id;
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

    public String getMeal_id() {
        return meal_id;
    }

    public void setMeal_id(String meal_id) {
        this.meal_id = meal_id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
