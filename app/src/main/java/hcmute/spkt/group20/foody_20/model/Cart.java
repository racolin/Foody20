package hcmute.spkt.group20.foody_20.model;

import android.content.Context;

import java.io.Serializable;
import java.util.List;

import hcmute.spkt.group20.foody_20.dao.CartDao;

/*OK*/

public class Cart implements Serializable {
    private int id;
    private int user_id;
    private int shop_id;

    public Cart() {

    }

    public Cart(int id, int user_id, int shop_id) {
        this.id = id;
        this.user_id = user_id;
        this.shop_id = shop_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getShop_id() {
        return shop_id;
    }

    public void setShop_id(int shop_id) {
        this.shop_id = shop_id;
    }

    public String toSaveString() {
        return String.format("INSERT INTO cart VALUES(null, %d, %d)", user_id, shop_id);
    }

    public String toDeleteString() {
        return String.format("DELETE FROM cart WHERE id=%d", id);
    }
}

