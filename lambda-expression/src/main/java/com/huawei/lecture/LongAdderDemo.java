package com.huawei.lecture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.atomic.LongAdder;

public class LongAdderDemo {
    public static void main(String[] args) {
        ForkJoinPool executor = ForkJoinPool.commonPool(); // test new method of ForkJoinPool

        LongAdder longAdder = new LongAdder();
        CountDownLatch latch = new CountDownLatch(100);
        for (int i = 0; i < 100; i++) {
            CompletableFuture.runAsync(longAdder::increment, executor).thenRun(latch::countDown);
        }

        try {
            latch.await();
            System.out.println("LongAdder value " + longAdder);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
