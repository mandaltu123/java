package com.tuhin.javapreps.collectionsUsages;

import java.io.Serializable;

/**
 * Created by tuhinmandal on 17/07/16.
 */
public class Student implements Serializable {

    private String name;
    private Long rollNumber;
    private String email;
    private Integer marks;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(Long rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getMarks() {
        return marks;
    }

    public void setMarks(Integer marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", rollNumber=" + rollNumber +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (!name.equals(student.name)) return false;
        if (!rollNumber.equals(student.rollNumber)) return false;
        return email.equals(student.email);

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + rollNumber.hashCode();
        result = 31 * result + email.hashCode();
        return result;
    }
}
