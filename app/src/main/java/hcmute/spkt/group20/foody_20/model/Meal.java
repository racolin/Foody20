package hcmute.spkt.group20.foody_20.model;

import java.io.Serializable;
import java.util.List;

/*OK*/

public class Meal implements Serializable {

    private int id;
    private String name;
    private int shop_id;
    private String description;
    private int price;
    private int saved_count;
    private int shared_count;
    private int image;

    public Meal() {

    }

    public Meal(int id, String name, int shop_id, String description, int price, int saved_count, int shared_count, int image) {
        this.id = id;
        this.name = name;
        this.shop_id = shop_id;
        this.description = description;
        this.price = price;
        this.saved_count = saved_count;
        this.shared_count = shared_count;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getShop_id() {
        return shop_id;
    }

    public void setShop_id(int shop_id) {
        this.shop_id = shop_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSaved_count() {
        return saved_count;
    }

    public void setSaved_count(int saved_count) {
        this.saved_count = saved_count;
    }

    public int getShared_count() {
        return shared_count;
    }

    public void setShared_count(int shared_count) {
        this.shared_count = shared_count;
    }
}
