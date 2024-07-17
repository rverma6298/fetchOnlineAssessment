package com.example.application.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ReceiptInfo {
    @JsonProperty(value = "retailer")
    private String retailer;
    @JsonProperty(value = "purchaseDate")
    private String purchaseDate;
    @JsonProperty(value = "purchaseTime")
    private String purchaseTime;
    @JsonProperty(value = "items")
    private List<Item> items;
    @JsonProperty(value = "total")
    private String total;

    public ReceiptInfo() {
    }

    public ReceiptInfo(String retailer, String purchaseDate, String purchaseTime, List<Item> items, String total) {
        this.retailer = retailer;
        this.purchaseDate = purchaseDate;
        this.purchaseTime = purchaseTime;
        this.items = items;
        this.total = total;
    }

    public String getRetailer() {
        return retailer;
    }

    public void setRetailer(String retailer) {
        this.retailer = retailer;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getPurchaseTime() {
        return purchaseTime;
    }

    public void setPurchaseTime(String purchaseTime) {
        this.purchaseTime = purchaseTime;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
