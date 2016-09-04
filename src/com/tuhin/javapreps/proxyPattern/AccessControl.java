package com.tuhin.javapreps.proxyPattern;

/**
 * This class provides the objects back to clients based
 * on their access rights
 *
 * @author tuhinmandal on 09/08/16.
 */
public class AccessControl {

    public static Object getInstance(Rights right) {

        Object proxy;

        switch (right) {
            case READ:
                proxy = new ReadProductProxy();
                break;
            case WRITE:
                proxy = new WriteProductProxy();
                break;
            default:
                throw new UnsupportedOperationException();
        }

        return proxy;
    }

}
