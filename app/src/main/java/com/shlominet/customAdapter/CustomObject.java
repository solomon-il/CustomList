package com.shlominet.customAdapter;

public class CustomObject {
    private int imgID;
    private String bookName, bookWriter;
    private int price;

    public CustomObject(int imgID, String bookName, String bookWriter, int price) {
        this.imgID = imgID;
        this.bookName = bookName;
        this.bookWriter = bookWriter;
        this.price = price;
    }

    public int getImgID() {
        return imgID;
    }

    public void setImgID(int imgID) {
        this.imgID = imgID;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookWriter() {
        return bookWriter;
    }

    public void setBookWriter(String bookWriter) {
        this.bookWriter = bookWriter;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
