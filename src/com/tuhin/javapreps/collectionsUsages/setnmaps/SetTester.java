package com.tuhin.javapreps.collectionsUsages.setnmaps;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by tuhinmandal on 24/07/16.
 */
public class SetTester {
    public static void main(String[] args) {
        Set<Employee> set = new HashSet<>();
        Employee employee = new Employee(1);
        set.add(employee);
        for (int i = 0 ; i < 5; i++) {
            Employee employee2 = new Employee(i);
            set.add(employee2);
        }

        System.out.println(set.size());
        for (Employee emp : set) {
            System.out.println(emp.getNumber());
        }
    }
}
