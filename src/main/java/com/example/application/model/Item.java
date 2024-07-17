package com.example.application.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Item {
    @JsonProperty(value = "shortDescription")
    private String shortDescription;
    @JsonProperty(value = "price")
    private String price;

    public Item() {
    }

    public Item(String description, String price) {
        this.shortDescription = description;
        this.price = price;
    }

    public String getDescription() {
        return shortDescription;
    }

    public void setDescription(String description) {
        this.shortDescription = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
