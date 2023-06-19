package com.quangpao.sqlite;

public class ProductModal {

    private int id;
    private String name;
    private String description;
    private String price;

    public ProductModal(String name, String description, String price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    //Getter & Setter methods
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
