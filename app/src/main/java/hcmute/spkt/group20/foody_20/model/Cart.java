package hcmute.spkt.group20.foody_20.model;

import com.google.firebase.firestore.Exclude;

import java.io.Serializable;
import java.util.List;

/*OK*/

public class Cart implements Serializable {
    private Shop shop;//
    private String shop_id;
    private List<OrderItem> items;

    public Cart(Shop shop, List<OrderItem> items) {
        this.shop = shop;
        this.items = items;
    }

    public int getTotal_price() {
        if (items != null) {
            int r = 0;
            for (OrderItem item : items) {
                r += item.getMeal().getPrice();
            }
            return r;
        }
        return 0;
    }

    public String getShop_id() {
        return shop_id;
    }

    public void setShop_id(String shop_id) {
//        load shop
        this.shop_id = shop_id;
    }

    @Exclude
    public Shop getShop() {
        return shop;
    }

    @Exclude
    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }
}

