package hcmute.spkt.group20.foody_20.model;

import java.io.Serializable;

/*OK*/
public class Slider implements Serializable {
    private int image;

    public Slider() {

    }

    public Slider(int image) {
        this.image = image;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}

