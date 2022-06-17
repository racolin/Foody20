package hcmute.spkt.group20.foody_20.model;


public class RatingClass {
    private String type;
    private float max;
    private float min;

    public RatingClass() {

    }

    public RatingClass(String type, float max, float min) {
        this.type = type;
        this.max = max;
        this.min = min;
    }

    public boolean isThisType(float rate) {
        return (rate > min) && (rate <= max);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getMax() {
        return max;
    }

    public void setMax(float max) {
        this.max = max;
    }

    public float getMin() {
        return min;
    }

    public void setMin(float min) {
        this.min = min;
    }
}
