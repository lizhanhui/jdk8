package com.huawei.lecture;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

class Student {
    //true for male; false for female.
    boolean gender;

    int age;

    Student() {

    }

    Student(int age, boolean gender) {
        this.age = age;
        this.gender = gender;
    }


    int getAge() {
        return age;
    }
}


public class StreamAPI {

    public static void main(String[] args) {
        List<Student> studentList = Arrays.asList(new Student(12, Boolean.FALSE), new Student(21, Boolean.TRUE),
                new Student(38, Boolean.FALSE), new Student(45, Boolean.TRUE));


        OptionalDouble averageAge = studentList
                .stream()
                .filter(s -> !s.gender)
                .mapToInt(s -> s.age)
                .average();

        System.out.println(averageAge.getAsDouble());



        //Make it parallel
        averageAge = studentList
                .stream().parallel()   //or .parallelStream()
                .filter(s -> !s.gender)
                .mapToInt(s -> s.age)
                .average();
        System.out.println(averageAge.getAsDouble());


        //Map-reduce
        int totalAges = studentList
                .stream()
                .map(Student::getAge)
                .reduce(0, (a, b) -> a + b);

        System.out.println(totalAges);

        //refer to http://docs.oracle.com/javase/tutorial/collections/streams/reduction.html
        //for more aggregate operation.
    }
}
