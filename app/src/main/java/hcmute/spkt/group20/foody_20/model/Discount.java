package hcmute.spkt.group20.foody_20.model;

import java.io.Serializable;

/*OK*/
public class Discount implements Serializable {
    private String type;
    private int value;

    public Discount() {

    }

    public Discount(String  type, int value) {
        this.type = type;
        this.value = value;
    }

    public String  getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
