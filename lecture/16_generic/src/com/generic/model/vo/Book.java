package com.generic.model.vo;

public class Book {
    private String title;
    private String authoe;
    private int price;
    private double discount;

    public Book() {
    }

    public Book(String title, String authoe, int price, double discount) {
        this.title = title;
        this.authoe = authoe;
        this.price = price;
        this.discount = discount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthoe() {
        return authoe;
    }

    public void setAuthoe(String authoe) {
        this.authoe = authoe;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", authoe='" + authoe + '\'' +
                ", price=" + price +
                ", discount=" + discount +
                '}';
    }

}
