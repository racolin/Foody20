package hcmute.spkt.group20.foody_20.model;

import com.google.firebase.firestore.Exclude;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/*OK*/

public class Meal implements Serializable {
    private String name;
    private Shop shop;//
    private String shop_id;
    private String description;
    private String type;
    private byte[] image;//
    private String image_src;
    private int origin_price;
    private List<Discount> discounts;
    private List<Comment> comments;
    private int saved_count;
    private int shared_count;
    private List<Meal> related_meals; //

    public Meal() {

    }

    public Meal(String name, Shop shop, String shop_id, String type, String description,
                byte[] image, String image_src, int origin_price,
                List<Discount> discounts, List<Comment> comments, int saved_count,
                int shared_count, List<Meal> related_meals) {
        this.name = name;
        this.shop = shop;
        this.shop_id = shop_id;
        this.type = type;
        this.description = description;
        this.image = image;
        this.image_src = image_src;
        this.origin_price = origin_price;
        this.discounts = discounts;
        this.comments = comments;
        this.saved_count = saved_count;
        this.shared_count = shared_count;
        this.related_meals = related_meals;
    }

    public String getShop_id() {
        return shop_id;
    }

    public void setShop_id(String shop_id) {
        this.shop_id = shop_id;
    }

    @Exclude
    public int getPrice() {
        if (discounts != null) {
            for (Discount discount : discounts) {
                switch (discount.getType()) {
                    case DiscountType.MONEY_FROM_SHOP:
                    case DiscountType.MONEY_FROM_SYSTEM:
                    case DiscountType.MONEY_FROM_SHOP_CHAIN:
                        return origin_price - discount.getValue();
                    case DiscountType.PERCENT_FROM_SHOP:
                    case DiscountType.PERCENT_FROM_SYSTEM:
                    case DiscountType.PERCENT_FROM_SHOP_CHAIN:
                        return origin_price * discount.getValue() / 100;
                }
            }
        }
        return origin_price;
    }

    public String getImage_src() {
        return image_src;
    }

    public void setImage_src(String image_src) {
        this.image_src = image_src;
    }

    @Exclude
    public int getComment_count() {
        return comments == null ? 0 : comments.size();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Exclude
    public Shop getShop() {
        return shop;
    }

    @Exclude
    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public String getDescription() {
        return description;
    }

    @Exclude
    public String getDescription(int limit) {
        if (description.length() > limit) {
            return description.substring(0, limit - 3) + "...";
        }
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
    public float getRated() {
        if (comments != null && comments.size() != 0) {
            float r = 0;
            for (Comment comment : comments) {
                r += comment.getRate();
            }
            return r / comments.size();
        }
        return 5;
    }

    @Exclude
    public String getAddress() {
        return shop.getAddress();
    }


    public int getOrigin_price() {
        return origin_price;
    }

    public void setOrigin_price(int origin_price) {
        this.origin_price = origin_price;
    }

    public List<Discount> getDiscounts() {
        return discounts;
    }

    public void setDiscounts(List<Discount> discounts) {
        this.discounts = discounts;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
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

    @Exclude
    public List<Meal> getRelated_meals() {
        return related_meals;
    }

    @Exclude
    @Override
    public String toString() {
        return "Meal{" +
                "name='" + name + '\'' +
                ", shop=" + shop +
                ", shop_id='" + shop_id + '\'' +
                ", description='" + description + '\'' +
                ", type='" + type + '\'' +
                ", image=" + Arrays.toString(image) +
                ", image_src='" + image_src + '\'' +
                ", origin_price=" + origin_price +
                ", discounts=" + discounts +
                ", comments=" + comments +
                ", saved_count=" + saved_count +
                ", shared_count=" + shared_count +
                ", related_meals=" + related_meals +
                '}';
    }

    @Exclude
    public void setRelated_meals(List<Meal> related_meals) {
        this.related_meals = related_meals;
    }
}
