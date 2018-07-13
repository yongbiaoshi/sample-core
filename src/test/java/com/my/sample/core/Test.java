package com.my.sample.core;

import java.time.LocalDate;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Test {

    public static void main(String[] args) {
        AtomicInteger ai = new AtomicInteger(0);
        int day = LocalDate.now().getDayOfYear();

        ExecutorService servcie = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10; i++) {
            final int j = i;
            servcie.execute(() -> {
                try {
                    Thread.sleep(100);
                    System.out.println("执行操作" + j);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        servcie.shutdown();
        try {
            servcie.awaitTermination(30, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("结束");
    }
}
