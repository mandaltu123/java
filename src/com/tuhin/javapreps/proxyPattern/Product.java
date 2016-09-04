package com.tuhin.javapreps.proxyPattern;

/**
 * Product class is the class for which users will get either read or write permission
 *
 * @author tuhinmandal on 09/08/16.
 */
public class Product {

    private String productName = "cola";
    private double price = 10;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
