package hcmute.spkt.group20.foody_20.model;

import java.util.List;

public class Shop {
    private String ownerName;
    private String name;
    private String description;
    private String address;
    private String time_open;
    private String distance;
    private int image;
    private List<Meal> meals;

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getTime_open() {
        return time_open;
    }

    public void setTime_open(String time_open) {
        this.time_open = time_open;
    }

    public List<Meal> getMeals() {
        return meals;
    }

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Shop(String name, String description, String distance, String address, int image) {
        this.name = name;
        this.address = address;
        this.description = description;
        this.image = image;
        this.distance = distance;
    }

    public Shop(String ownerName, String name, String description, String distance, String address, String time_open, int image, List<Meal> meals) {
        this.ownerName = ownerName;
        this.name = name;
        this.description = description;
        this.address = address;
        this.time_open = time_open;
        this.image = image;
        this.meals = meals;
        this.distance = distance;
    }

    public Shop() {

    }
}
