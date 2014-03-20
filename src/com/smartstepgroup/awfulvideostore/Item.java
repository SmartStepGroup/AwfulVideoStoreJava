package com.smartstepgroup.awfulvideostore;

public class Item {
    private String name;
    private String price;
    private String rating;
    private String code;

    public void setName(String name) {
        this.name = name;
    }
    public void setRating(String rating) {
        this.rating = rating;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public void setPrice(String price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getRating() {
        return rating;
    }

    public String getCode() {
        return code;
    }

    public String getPrice() {
        return price;
    }

    public String toString() {
        return "Film [Name=" + name + ", Price=" + price + ", Rating="
                + rating + ", code=" + code + "]";
    }
}
