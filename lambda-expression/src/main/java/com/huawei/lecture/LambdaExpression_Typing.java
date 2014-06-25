package com.huawei.lecture;

import java.util.concurrent.Callable;

public class LambdaExpression_Typing {

    void invoke(Runnable runnable) {
        System.out.println("Runnable");
    }


    String invoke(Callable callable) {
        System.out.println("Callable");
        return "OK";
    }

    public static void main(String[] args) {
        LambdaExpression_Typing instance = new LambdaExpression_Typing();
        instance.invoke(() -> "done");

        instance.invoke(() -> {
        });
    }
}