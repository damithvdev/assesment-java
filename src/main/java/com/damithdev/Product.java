package com.damithdev;


public class Product {
    private int id;
    private String productName;
    private String unitType;
    private int productQuantity;

    public Product(int id, String productName, int productQuantity, String unitType) {
        this.id = id;
        this.productName = productName;
        this.productQuantity = productQuantity;
        this.unitType = unitType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public String getUnitType() {
        return unitType;
    }

    public void setUnitType(String unitType) {
        this.unitType = unitType;
    }
}
