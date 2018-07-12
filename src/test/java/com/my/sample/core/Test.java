package com.my.sample.core;

import java.time.Instant;
import java.time.LocalDate;
import java.time.temporal.TemporalField;
import java.util.concurrent.atomic.AtomicInteger;

public class Test {

    public static void main(String[] args) {
        AtomicInteger ai = new AtomicInteger(0);
        int day = LocalDate.now().getDayOfYear();
    }
}
