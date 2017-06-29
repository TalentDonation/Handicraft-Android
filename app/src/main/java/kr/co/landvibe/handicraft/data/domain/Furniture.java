package kr.co.landvibe.handicraft.data.domain;


import java.io.Serializable;

public class Furniture implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String title;

    private String state;

    private String description;

    private String imageUrl;

    private int resId;

    public Furniture(){}

    public Furniture(String id, String title, String state, String description, String imageUrl, int resId) {
        this.id = id;
        this.title = title;
        this.state = state;
        this.description = description;
        this.imageUrl = imageUrl;
        this.resId = resId;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }
}
