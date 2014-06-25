package com.huawei.lecture;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class LambdaExpressionDemo_FirstLook {

    public static void main(String[] args) {
        List<Person> personList = Arrays.asList(new Person("Steve Jobs"));
        PersonManager.filter(personList, p -> {return null != p.name;}, (p) -> {p.payment += 10000;});

    }

}


class Person {
    String name;

    Date dateOfBirth;

    boolean gender;

    int payment;

    public Person() {}

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", gender=" + gender +
                ", payment=" + payment +
                '}';
    }
}


interface Criteria {
    boolean matches(Person person);
}

interface Operation {

    void raisePayment(Person person);

    default void praise(Person person) {
        System.out.println(null == person.name ? "You are" : (person.name + " is") + " so cool!");
    }
}

class PersonManager {

    public static void filter(List<Person> list, Criteria criteria, Operation operation) {
        if (null == list) {
            return;
        }

        list.forEach(person -> {
            if (criteria.matches(person)) {
                operation.praise(person);
                operation.raisePayment(person);
            }
        });

    }
}
