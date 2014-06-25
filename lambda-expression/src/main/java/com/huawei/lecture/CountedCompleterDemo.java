package com.huawei.lecture;

import java.util.concurrent.CountedCompleter;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

public class CountedCompleterDemo {

    public static void main(String[] args) {
        ForkJoinPool executor = ForkJoinPool.commonPool(); // test new method of ForkJoinPool
        ForkJoinTask<Integer> task = executor.submit(new Fibonacci(6));
        System.out.println("Fibonacci 6: " + task.join());
    }
}

class Fibonacci extends CountedCompleter<Integer> {
    Integer n;

    public Fibonacci(Integer n) {
        this.n = n;
    }

    public void compute() {
        if (n > 1) {
            Fibonacci f1 = new Fibonacci(n - 1);
            f1.fork();
            Fibonacci f2 = new Fibonacci(n - 2);
            f2.compute();
            n = f2.n + f1.join();
        }
        tryComplete();
    }

    public Integer getRawResult() {
        return n;
    }
}
