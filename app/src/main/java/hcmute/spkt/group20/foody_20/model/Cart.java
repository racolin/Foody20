package hcmute.spkt.group20.foody_20.model;

import java.util.List;

import hcmute.spkt.group20.foody_20.Support;

public class Cart {
    private String shop;
    private String distance;
    private List<CartItem> items;

    public Cart(String shop, String distance, List<CartItem> items) {
        this.shop = shop;
        this.distance = distance;
        this.items = items;
    }

    public String getTotal() {
        int price = 0;
        for (CartItem item : items) {
            price += item.getPrice();
        }
        return Support.toCurrency(price);
    }

    public String getShop() {
        return shop;
    }

    public void setShop(String shop) {
        this.shop = shop;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public List<CartItem> getItems() {
        return items;
    }

    public void setItems(List<CartItem> items) {
        this.items = items;
    }
}

