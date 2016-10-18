package com.tuhin.javapreps.collectionsUsages;

import java.io.Serializable;

/**
 * Created by tuhinmandal on 17/07/16.
 */
public class Employee implements Serializable {

    private String name;
    private int age;
    public enum SEX {MALE, FEMALE};
    private SEX gender;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public SEX getGender() {
        return gender;
    }

    public void setGender(SEX gender) {
        this.gender = gender;
    }
}
