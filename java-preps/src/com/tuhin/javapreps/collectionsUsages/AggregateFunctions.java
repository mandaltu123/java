package com.tuhin.javapreps.collectionsUsages;

import java.util.ArrayList;

/**
 * Created by tuhinmandal on 17/07/16.
 * <p>
 * In this class we will see ease of use using aggregate functions.
 * <p>
 * we will create few employees and calculate average age of
 * the female employees.
 * <p>
 * Reference: https://docs.oracle.com/javase/tutorial/collections/streams/index.html#pipelines
 * <p>
 * Differences Between Aggregate Operations and Iterators
 * <p>
 * Aggregate operations, like forEach, appear to be like iterators. However, they have several fundamental differences:
 * <p>
 * They use internal iteration: Aggregate operations do not contain a method like next to instruct them to process the
 * next element of the collection. With internal delegation, your application determines what collection it iterates,
 * but the JDK determines how to iterate the collection. With external iteration, your application determines both what
 * collection it iterates and how it iterates it. However, external iteration can only iterate over the elements of a
 * collection sequentially. Internal iteration does not have this limitation. It can more easily take advantage of
 * parallel computing, which involves dividing a problem into subproblems, solving those problems simultaneously, and
 * then combining the results of the solutions to the subproblems. See the section Parallelism for more information.
 * <p>
 * They process elements from a stream: Aggregate operations process elements from a stream, not directly from a
 * collection. Consequently, they are also called stream operations.
 * <p>
 * They support behavior as parameters: You can specify lambda expressions as parameters for most aggregate operations.
 * This enables you to customize the behavior of a particular aggregate operation.
 */
public class AggregateFunctions {
    public static void main(String args[]) {

        //create few employees
        Employee jenny = new Employee();
        jenny.setName("jenny");
        jenny.setAge(25);
        jenny.setGender(Employee.SEX.FEMALE);

        Employee serra = new Employee();
        serra.setName("serra");
        serra.setAge(23);
        serra.setGender(Employee.SEX.FEMALE);


        Employee arya = new Employee();
        arya.setName("arya");
        arya.setAge(24);
        arya.setGender(Employee.SEX.FEMALE);

        Employee forest = new Employee();
        forest.setName("forest");
        forest.setAge(24);
        forest.setGender(Employee.SEX.MALE);

        Employee bubba = new Employee();
        bubba.setName("bubba");
        bubba.setAge(24);
        bubba.setGender(Employee.SEX.MALE);

        ArrayList<Employee> list = new ArrayList<>();
        list.add(jenny);
        list.add(serra);
        list.add(arya);
        list.add(forest);
        list.add(bubba);


        double avegaeFemaleEmployeeAge = list.stream()
                .filter(e -> e.getGender() == Employee.SEX.FEMALE)
                .mapToInt(Employee::getAge)
                .average().getAsDouble();

        System.out.print(avegaeFemaleEmployeeAge);

    }
}


