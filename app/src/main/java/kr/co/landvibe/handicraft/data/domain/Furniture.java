package kr.co.landvibe.handicraft.data.domain;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Furniture implements Serializable {

    private static final long serialVersionUID = 1L;

    private long id;
    private String title;
    private String state; // 판매 or 공유
    private String grade; // 제품 상태 (A,B,C,F)
    private String description;
    private List<String> imageUrl;
    private String type; // 가구 타입(의자, 쇼파, 책장, ...)
    private String brand; // 브랜드
    private int periodOfUse; // 사용 기간
    private long price; // 판매가( 공유시 0원)
    private int width; // 가로, x
    private int length; // 세로, y
    private int height; // 높이, z
    private String location; // 거래지역
    private double lat; // 위도
    private double lon; // 경도
    private Date createAt; // 업로드 날짜

    private int resId; //임시

    public Furniture() {}

    public Furniture(long id, String title, String state, String grade, String description, List<String> imageUrl, String type, String brand, int periodOfUse, long price, int width, int length, int height, String location, double lat, double lon, Date createAt, int resId) {
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
        this.resId = resId;
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

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }
}
