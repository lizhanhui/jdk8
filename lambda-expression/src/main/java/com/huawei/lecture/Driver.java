package com.huawei.lecture;

interface Human {
    default void travel() {
        System.out.println("Walk");
    }

    void foo();
}

class Man implements Human {
    @Override
    public void foo() {
        System.out.println("bar...");

    }
}

public class Driver implements Human {
    @Override
    public void travel() {
        System.out.println("Driving...");
    }

    @Override
    public void foo() {
        System.out.println("bar...");

    }
}
