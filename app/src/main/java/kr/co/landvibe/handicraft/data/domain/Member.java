package kr.co.landvibe.handicraft.data.domain;

import java.io.Serializable;
import java.util.Date;

public class Member implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String name;

    private String phone;

    private String gender;

    private String address;

    private String feature;

    private Date joinAt;

    public Member() {
    }

    public Member(String id, String name, String phone, String gender, String address, String feature, Date joinAt) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.gender = gender;
        this.address = address;
        this.feature = feature;
        this.joinAt = joinAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public Date getJoinAt() {
        return joinAt;
    }

    public void setJoinAt(Date joinAt) {
        this.joinAt = joinAt;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Member [id=" + id + ", name=" + name + ", phone=" + phone + ", gender=" + gender + ", address=" + address
                + ", feature" + feature + ", joinAt" + joinAt + "]\n";
    }
}
