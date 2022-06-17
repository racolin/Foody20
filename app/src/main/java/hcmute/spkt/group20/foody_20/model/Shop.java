package hcmute.spkt.group20.foody_20.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*OK*/

public class Shop implements Serializable {

    private int id;
    private String name;
    private int shop_chain_id;
    private String time_open;
    private String description;
    private String phone_number;
    private String address;
    private String distance;
    private int image;

    public Shop() {

    }

    public Shop(int id, String name, int shop_chain_id, String time_open, String description,
                String phone_number, String address, String distance, int image) {
        this.id = id;
        this.name = name;
        this.shop_chain_id = shop_chain_id;
        this.time_open = time_open;
        this.description = description;
        this.phone_number = phone_number;
        this.address = address;
        this.distance = distance;
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

    public int getShop_chain_id() {
        return shop_chain_id;
    }

    public void setShop_chain_id(int shop_chain_id) {
        this.shop_chain_id = shop_chain_id;
    }

    public String getTime_open() {
        return time_open;
    }

    public void setTime_open(String time_open) {
        this.time_open = time_open;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
