package com.tuhin.javapreps.collectionsUsages.setnmaps;

/**
 * Created by tuhinmandal on 24/07/16.
 */
public class Employee {

    private int number;

    public Employee(int number) {
        this.number = number;
    }

    public int getNumber(){
        return this.number;
    }

    /**
     *
     * @param o
     * @return true if objects are same with same employee number, else returns false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        return number == employee.number;

    }

    /**
     *
     * @return the inserted number through Employee constructor
     */
    @Override
    public int hashCode() {
        return number;
    }
}
