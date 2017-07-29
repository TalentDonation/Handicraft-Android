package kr.co.landvibe.handicraft.data.support;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Pagination<T> {

    @SerializedName("content")
    private List<T> contents;
    @SerializedName("totalElements")
    private int totalElements;
    @SerializedName("totalPages")
    private int totalPages;
    @SerializedName("number")
    private int number;
    @SerializedName("numberOfElements")
    private int numberOfElements;
    @SerializedName("size")
    private int perPage;

    public Pagination() {
    }

    public Pagination(List<T> contents, int totalElements, int totalPages, int number, int numberOfElements, int perPage) {
        this.contents = contents;
        this.totalElements = totalElements;
        this.totalPages = totalPages;
        this.number = number;
        this.numberOfElements = numberOfElements;
        this.perPage = perPage;
    }

    public List<T> getContents() {
        return contents;
    }

    public void setContents(List<T> contents) {
        this.contents = contents;
    }

    public int getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(int totalElements) {
        this.totalElements = totalElements;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumberOfElements() {
        return numberOfElements;
    }

    public void setNumberOfElements(int numberOfElements) {
        this.numberOfElements = numberOfElements;
    }

    public int getPerPage() {
        return perPage;
    }

    public void setPerPage(int perPage) {
        this.perPage = perPage;
    }
}
