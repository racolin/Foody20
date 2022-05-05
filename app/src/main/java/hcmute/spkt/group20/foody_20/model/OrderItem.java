package hcmute.spkt.group20.foody_20.model;

import hcmute.spkt.group20.foody_20.Support;

public class OrderItem {
    private Meal meal;
    private int amount;
    private int price;

    public OrderItem(Meal meal, int amount, int price) {
        this.meal = meal;
        this.amount = amount;
        this.price = price;
    }

    public Meal getMeal() {
        return meal;
    }

    public String getPriceCurrency() {
        return Support.toCurrency(price);
    }

    public void setMeal(Meal meal) {
        this.meal = meal;
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
}
