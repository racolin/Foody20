package hcmute.spkt.group20.foody_20.model;


import java.io.Serializable;
import java.util.List;
/*OK*/
public class ShopChain implements Serializable {

    private int id;
    private String name;
    private String description;
    private int image;

    public ShopChain() {

    }

    public ShopChain(int id, String name, String description, int image) {
        this.id = id;
        this.name = name;
        this.description = description;
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
}
