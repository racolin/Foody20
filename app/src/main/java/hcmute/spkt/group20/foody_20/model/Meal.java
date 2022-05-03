package hcmute.spkt.group20.foody_20.model;

public class Meal {
    private String name;
    private String description;
    private String distance;
    private String shop;
    private int image;

    public Meal(String name, String description, String distance, String shop, int image) {
        this.name = name;
        this.description = description;
        this.distance = distance;
        this.shop = shop;
        this.image = image;
    }

    public String getShop() {
        return shop;
    }

    public void setShop(String shop) {
        this.shop = shop;
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
}
