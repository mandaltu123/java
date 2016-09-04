package com.tuhin.javapreps.proxyPattern;

/**
 * Only read access
 * @author  tuhinmandal on 09/08/16.
 */
public class ReadProductProxy extends Product {

    public void setProductName(String productName) {
        throw new UnsupportedOperationException("you do not have write permission");
    }

    public void setPrice(double price) {
        throw new UnsupportedOperationException("you do not have write permission");
    }
}
