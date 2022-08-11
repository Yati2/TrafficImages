package sg.edu.rp.c346.id20028056.trafficimages;

public class Traffic {
    private String area;
    private String imageURL;

    public Traffic(String area, String imageURL) {
        this.area = area;
        this.imageURL=imageURL;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
