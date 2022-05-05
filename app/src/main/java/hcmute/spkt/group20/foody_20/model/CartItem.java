package hcmute.spkt.group20.foody_20.model;

import hcmute.spkt.group20.foody_20.Support;

public class CartItem {
    private String title;
    private int price;
    private int amount;
    private int image;

    public CartItem(String title, int price, int amount, int image) {
        this.title = title;
        this.price = price;
        this.amount = amount;
        this.image = image;
    }

    public String getAmount() {
        return String.valueOf(amount);
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getTitle() {
        return title;
    }

    public String getPriceCurrency() {
        return Support.toCurrency(price) + "đ";
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}

