package com.example.medenjaci;

public class Item {
    private String name;
    private String price;
    private int image;
    private String description;
    private String quantity;
    private String bill;

    public Item(String name, String price, int image, String description) {
        this.name = name;
        this.price = price;
        this.image = image;
        this.description = description;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }


    public String getDescription() {
        return description;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getBill() {
        return bill;
    }

    public void setBill(String bill) {
        this.bill = bill;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
