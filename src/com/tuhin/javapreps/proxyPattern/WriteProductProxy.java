package com.tuhin.javapreps.proxyPattern;

/**
 * Only write access
 *
 * @author tuhinmandal on 09/08/16.
 */
public class WriteProductProxy extends Product {

    public String getProductName() {
        throw new UnsupportedOperationException("you do not have read permission");
    }

    public double getPrice() {
        throw new UnsupportedOperationException("you do not have read permission");
    }
}
