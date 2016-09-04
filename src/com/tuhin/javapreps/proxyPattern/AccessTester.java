package com.tuhin.javapreps.proxyPattern;

/**
 * Created by tuhinmandal on 09/08/16.
 */
public class AccessTester {

    public static void main(String[] args) {

        Product prod = (Product) AccessControl.getInstance(Rights.READ);
        Product prod1 = (Product) AccessControl.getInstance(Rights.WRITE);


        prod1.setPrice(100);
        prod1.setProductName("beer");
        System.out.println(prod.getPrice() + " " + prod.getProductName());

        try {
            prod.setProductName("trying to set some name");
        } catch (UnsupportedOperationException e) {
            System.err.println(e.getMessage());
        }
        try {
            prod1.getProductName();
        } catch (UnsupportedOperationException e) {
            System.err.println(e.getMessage());
        }
    }
}
