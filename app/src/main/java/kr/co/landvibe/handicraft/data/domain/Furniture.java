package kr.co.landvibe.handicraft.data.domain;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Furniture implements Serializable {

    private static final long serialVersionUID = 1L;

    @SerializedName("fid")
    private long id;
    @SerializedName("title")
    private String title;
    @SerializedName("state")
    private String state; // 판매 or 공유
    @SerializedName("grade")
    private String grade; // 제품 상태 (A,B,C,F)
    @SerializedName("description")
    private String description;
    @SerializedName("images")
    private List<String> imageUrl;
    @SerializedName("type")
    private String type; // 가구 타입(의자, 쇼파, 책장, ...)
    @SerializedName("brand")
    private String brand; // 브랜드
    @SerializedName("periodOfUse")
    private int periodOfUse; // 사용 기간c
    @SerializedName("price")
    private long price; // 판매가( 공유시 0원)
    @SerializedName("width")
    private int width; // 가로, x
    @SerializedName("length")
    private int length; // 세로, y
    @SerializedName("height")
    private int height; // 높이, z
    @SerializedName("location")
    private String location; // 거래지역
    @SerializedName("lat")
    private double lat; // 위도
    @SerializedName("lon")
    private double lon; // 경도
    @SerializedName("createAt")
    private Date createAt; // 업로드 날짜

    public Furniture() {
    }

    public Furniture(long id, String title, String state, String grade, String description, List<String> imageUrl, String type, String brand, int periodOfUse, long price, int width, int length, int height, String location, double lat, double lon, Date createAt) {
        this.id = id;
        this.title = title;
        this.state = state;
        this.grade = grade;
        this.description = description;
        this.imageUrl = imageUrl;
        this.type = type;
        this.brand = brand;
        this.periodOfUse = periodOfUse;
        this.price = price;
        this.width = width;
        this.length = length;
        this.height = height;
        this.location = location;
        this.lat = lat;
        this.lon = lon;
        this.createAt = createAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(List<String> imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPeriodOfUse() {
        return periodOfUse;
    }

    public void setPeriodOfUse(int periodOfUse) {
        this.periodOfUse = periodOfUse;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
}
