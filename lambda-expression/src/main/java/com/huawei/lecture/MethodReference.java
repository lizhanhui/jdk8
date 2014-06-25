package com.huawei.lecture;

interface Calculator {
    double sqrt(double value);
}

public class MethodReference {


    static double cal(double value,  Calculator calculator) {
        return calculator.sqrt(value);
    }


    public static void main(String[] args) {

        //Using lambda expression.
        double result = MethodReference.cal(4.0, v -> Math.sqrt(v));
        System.out.println(result);

        //We can even do it this way
        result = MethodReference.cal(4.0, Math::sqrt);
        System.out.println(result);

    }

}
