package com.tuhin.javapreps.innerClasses;

import com.tuhin.javapreps.utils.PrintUtil;

/**
 * Created by tuhinmandal on 22/07/16.
 */
public class Demo extends OuterClass {

    public static void main(String[] args) {

        StaticInner staticInner = new StaticInner();
        NonStaticInner nonStaticInner = new OuterClass().new NonStaticInner();

        PrintUtil.print("staticInner instance ", staticInner.getClass());
        PrintUtil.print("nonStaticInner instance ", nonStaticInner.getClass());
    }
}
