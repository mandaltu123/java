package com.tuhin.javapreps.collectionsUsages;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by tuhinmandal on 17/07/16.
 * <p>
 * https://docs.oracle.com/javase/tutorial/collections/interfaces/collection.html
 * <p>
 * some of the java features here
 */
public class AggregateOperations {


    public static void main(String args[]) {

        List<Student> list = new ArrayList<>();
        Student student = new Student();
        student.setEmail("jimi@rocknroll.com");
        student.setName("jimmy hendrix");
        student.setRollNumber(1234L);
        student.setMarks(60);

        Student student1 = new Student();
        student1.setEmail("angus@rocknroll.com");
        student1.setName("angus young");
        student1.setRollNumber(1235L);
        student1.setMarks(61);

        Student student3 = new Student();
        student3.setEmail("james@heavymetal.com");
        student3.setName("james patrik page");
        student3.setRollNumber(1236L);
        student3.setMarks(65);

        list.add(student);
        list.add(student1);
        list.add(student3);

        /**
         * Lambdas are really cool feature
         * In JDK 8 and later, the preferred method of iterating over a collection is to obtain a stream and perform
         * aggregate operations on it. Aggregate operations are often used in conjunction with lambda expressions to
         * make programming more expressive, using less lines of code. The following code sequentially iterates through
         * a collection of shapes and prints out the red objects:
         *
         *
         * The Collections framework has always provided a number of so-called "bulk operations" as part of its API.
         * These include methods that operate on entire collections, such as containsAll, addAll, removeAll, etc.
         * Do not confuse those methods with the aggregate operations that were introduced in JDK 8. The key difference
         * between the new aggregate operations and the existing bulk operations (containsAll, addAll, etc.) is that
         * the old versions are all mutative, meaning that they all modify the underlying collection. In contrast,
         * the new aggregate operations do not modify the underlying collection. When using the new aggregate operations
         * and lambda expressions, you must take care to avoid mutation so as not to introduce problems in the future, 
         * should your code be run later from a parallel stream.
         */
        list.stream()
                .filter(e -> e.getEmail().contains("rocknroll"))
                .forEach(e -> System.out.println(e.getName() + " " + e.getEmail()));

        //Likewise, you could easily request a parallel stream, which might make sense if the collection is large enough
        // and your computer has enough cores:
        list.parallelStream()
                .filter(e -> !e.getEmail().contains("rocknroll"))
                .forEach(e -> System.out.println(e.getName() + " " + e.getEmail()));


        /**
         * There are many different ways to collect data with this API. For example, you might want to convert the
         * elements of a Collection to String objects, then join them, separated by commas:
         */

        String joined = list.stream()
                            .map(Objects::toString)
                            .collect(Collectors.joining(", "));

        System.out.println(joined);


        int total = list.stream()
                        .collect(Collectors.summingInt(Student::getMarks));
        System.out.println("total marks obtained by all "+ list.size() + " is : " + total);

        list.stream().forEach((e -> System.out.println(e.getName())));

    }
}
