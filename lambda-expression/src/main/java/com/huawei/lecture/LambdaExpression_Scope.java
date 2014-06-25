package com.huawei.lecture;

import java.util.function.Consumer;

public class LambdaExpression_Scope {
    private int x = 1;


    class Inner {
        private int x = 2;

        public void method(int x) {

            //cause error "local variables referenced from a lambda expression must be final or effectively final"
            //x = 3;

            Consumer<Integer> consumer = (y) -> {
                System.out.println("x = " + x);
                System.out.println("y = " + y);
                System.out.println("this.x = " + this.x);
                System.out.println("LambdaExpression_Scope.this.x = " +
                        LambdaExpression_Scope.this.x);
            };

            consumer.accept(x);
        }
    }


    public static void main(String[] args) {
        LambdaExpression_Scope instance = new LambdaExpression_Scope();
        Inner test = instance.new Inner();
        test.method(3);
    }
}
