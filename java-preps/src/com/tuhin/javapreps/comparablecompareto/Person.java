package com.tuhin.javapreps.comparablecompareto;


import java.util.*;

/**
 * Created by tuhinmandal on 18/07/16.
 */


public class Person implements Comparable<Person> {

    private int id;
    String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Comparable is used for natural ordering of the objects
     * in this example we have made that natural ordering based on the id.
     * @param o
     * @return
     */
    @Override
    public int compareTo(Person o) {
        return id - o.id;
    }

    /**
     * Comparator is used for custom sorting.
     * For example we need to sort employees based on different criteria
     * such as their name, email, or department or whatever for that matter
     * can be done using Comparator
     */
    public static final Comparator<Person> NameComparator = new Comparator<Person>() {

        @Override
        public int compare(Person o1, Person o2) {
            return o1.name.compareTo(o2.name);
        }

    };


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (id != person.id) return false;
        return name.equals(person.name);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        return result;
    }


    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    private static void printCollection(List<Person> list) {

        for (Person person : list) {
            System.out.print(person.id + " :: name ::: " + person.name);
        }
        System.out.println();

    }

    public static void main(String args[]) {

        Person one = new Person(2, "jimy");
        Person two = new Person(1, "angus");
        Person three = new Person(5, "eric");
        System.out.println("three.compareTo(two) = " + three.compareTo(two));
        List<Person> list = new ArrayList<>();
        list.add(one);
        list.add(three);
        list.add(two);
        System.out.println("before::::::::::");
        printCollection(list);
        Collections.sort(list);
        System.out.println("after::::::::::");
        printCollection(list);

        Collections.sort(list, Person.NameComparator);
        System.out.println("after passing name compartor::::::::::");
        printCollection(list);

    }
}
