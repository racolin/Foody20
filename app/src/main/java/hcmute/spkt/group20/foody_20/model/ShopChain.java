package hcmute.spkt.group20.foody_20.model;

import com.google.firebase.firestore.Exclude;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/*OK*/
public class ShopChain implements Serializable {
    private String name;
    private String description;
    private List<Shop> shops; //
    private List<String> shops_id;
    private byte[] image;
    private String image_src;

    public ShopChain() {

    }

    public ShopChain(String name, String description, List<Shop> shops, List<String> shops_id) {
        this.name = name;
        this.description = description;
        this.shops = shops;
        this.shops_id = shops_id;
    }

    @Exclude
    public byte[] getImage() {
        return image;
    }

    @Exclude
    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getImage_src() {
        return image_src;
    }

    public void setImage_src(String image_src) {
        this.image_src = image_src;
    }

    public List<String> getShops_id() {
        return shops_id;
    }

    public void setShops_id(List<String> shops_id) {
        this.shops_id = shops_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Exclude
    public float getRated() {
        if (shops != null) {
            int count = 0;
            for (Shop shop : shops) {
                count += shop.getRated();
            }
            return count / shops.size();
        }
        return 0;
    }

    @Exclude
    public int getShop_count() {
        return shops == null ? 0 :shops.size();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Exclude
    public List<Shop> getShops() {
        return shops;
    }

    @Exclude
    public void setShops(List<Shop> shops) {
        this.shops = shops;
    }
}
