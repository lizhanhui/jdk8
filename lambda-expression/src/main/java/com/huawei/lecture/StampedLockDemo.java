package com.huawei.lecture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.locks.StampedLock;

public class StampedLockDemo {

    private void testStampedLock() {
        Point point = new Point();
        for (int i = 0; i < 10; i++) {
            CompletableFuture.runAsync(() -> {
                point.distance();
                point.write(1);
            });
        }
    }

}



class Point {
    private int pixel;
    private final StampedLock sl = new StampedLock();

    void write(int delta) {
        long stamp = sl.writeLock();
        try {
            pixel += delta;
        } finally {
            sl.unlockWrite(stamp);
        }
    }

    int distance() {
        long stamp = sl.tryOptimisticRead();
        int res = 0;
        if (!sl.validate(stamp)) {
            stamp = sl.readLock();
            try {
                res = pixel;
            } finally {
                sl.unlockRead(stamp);
            }
        }
        return res;
    }

    int readPixel() {
        long stamp = sl.readLock();
        try {
            return pixel;
        } finally {
            sl.unlock(stamp);
        }
    }
}
