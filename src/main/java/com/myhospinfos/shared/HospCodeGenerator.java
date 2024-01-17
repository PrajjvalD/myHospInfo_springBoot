package com.myhospinfos.shared;

import java.util.concurrent.atomic.AtomicLong;

public class HospCodeGenerator {

    private static final String PREFIX = "HOSP-";
    private static final AtomicLong counter = new AtomicLong(1);

    public static String generateHospCode() {
        // You can customize the format of the generated code as needed
        return PREFIX + String.format("%04d", counter.getAndIncrement());
    }

    // If you want to reset the counter (for testing or other purposes)
    public static void resetCounter() {
        counter.set(1);
    }
}
