package hcmute.spkt.group20.foody_20.model;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.Exclude;

import java.io.Serializable;
import java.util.List;
import java.util.Random;

/*OK*/

public class Shop implements Serializable {
    private String name;
    private ShopChain shop_chain; //
    private String shop_chain_id;
    private String time_open;
    private String description;
    private String phone_number;
    private String address;
    private String image_src;
    private byte[] image; //
    private List<Meal> meals; //
    private List<String> meals_id;
    private List<Shop> related_shops; //

    public Shop() {

    }

    public Shop(String name, ShopChain shop_chain, String shop_chain_id, String time_open,
                String description, String phone_number, String address, String image_src,
                byte[] image, List<Meal> meals, List<String> meals_id, List<Shop> related_shops) {
        this.name = name;
        this.shop_chain = shop_chain;
        this.shop_chain_id = shop_chain_id;
        this.time_open = time_open;
        this.description = description;
        this.phone_number = phone_number;
        this.address = address;
        this.image_src = image_src;
        this.image = image;
        this.meals = meals;
        this.meals_id = meals_id;
        this.related_shops = related_shops;
    }

    public List<String> getMeals_id() {
        return meals_id;
    }

    public void setMeals_id(List<String> meals_id) {
        this.meals_id = meals_id;
    }

    public String getShop_chain_id() {
        return shop_chain_id;
    }

    public void setShop_chain_id(String shop_chain_id) {
        this.shop_chain_id = shop_chain_id;
    }

    public String getImage_src() {
        return image_src;
    }

    public void setImage_src(String image_src) {
        this.image_src = image_src;
    }

    @Exclude
    public String getDistance() {
        Random rd = new Random();
        return String.valueOf(((int) (rd.nextFloat() * 10)) )+ "km";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Exclude
    public ShopChain getShop_chain() {
        return shop_chain;
    }

    @Exclude
    public void setShop_chain(ShopChain shop_chain) {
        this.shop_chain = shop_chain;
    }

    public String getTime_open() {
        return time_open;
    }

    public void setTime_open(String time_open) {
        this.time_open = time_open;
    }

    @Exclude
    public float getRated() {
        if (meals != null) {

            float r = 0;
            for (Meal meal : meals) {
                r += meal.getRated();
            }
            return r / meals.size();
        }
        return 0;
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

    @Exclude
    public byte[] getImage() {
        return image;
    }

    @Exclude
    public void setImage(byte[] image) {
        this.image = image;
    }

    @Exclude
    public List<Meal> getMeals() {
        return meals;
    }

    @Exclude
    public void setMeals(List<Meal> meals) {
        this.meals = meals;
    }

    @Exclude
    public List<Shop> getRelated_shops() {
        return related_shops;
    }

    @Exclude
    public void setRelated_shops(List<Shop> related_shops) {
        this.related_shops = related_shops;
    }
}
