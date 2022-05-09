package hcmute.spkt.group20.foody_20.model;

import java.io.Serializable;

/*OK*/
public class Slider implements Serializable {
    private byte[] image;

    public Slider() {

    }

    public Slider(byte[] image) {
        this.image = image;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}

