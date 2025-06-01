package com.java_17.chepter_11;

import java.io.*;
import java.text.*;
import java.time.*;
import java.time.format.*;
import java.util.*;

class CustomCheckedException extends Exception {
    public CustomCheckedException(String msg) {
        super(msg);
    }
}

public class ExceptionsAndLocalizationDemo {

    public static void main(String[] args) {
        // === TRY-CATCH-FINALLY ===
        try {
            throwException(false);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught IllegalArgumentException");
        } finally {
            System.out.println("Finally block always runs");
        }

        // === TRY-WITH-RESOURCES ===
        try (MyResource res = new MyResource()) {
            res.doWork();
        } catch (Exception e) {
            System.out.println("AutoCloseable handled: " + e.getMessage());
        }

        // === CUSTOM CHECKED EXCEPTION ===
        try {
            validateInput(-1);
        } catch (CustomCheckedException e) {
            System.out.println("Custom exception: " + e.getMessage());
        }

        // === LOCALIZATION: FORMATTING ===
        var localeFR = Locale.FRANCE;
        NumberFormat currency = NumberFormat.getCurrencyInstance(localeFR);
        System.out.println("Formatted (FR): " + currency.format(1234.56));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, dd MMM yyyy", Locale.UK);
        System.out.println("UK Date: " + LocalDate.now().format(formatter));

        // === RESOURCE BUNDLE ===
        Locale.setDefault(Locale.US);
        ResourceBundle bundle = ResourceBundle.getBundle("Zoo");
        System.out.println("Greeting: " + bundle.getString("hello"));
    }

    static void throwException(boolean checked) {
        if (checked) {
            throw new RuntimeException("Runtime problem");
        } else {
            throw new IllegalArgumentException("Bad argument");
        }
    }

    static void validateInput(int value) throws CustomCheckedException {
        if (value < 0) throw new CustomCheckedException("Negative not allowed");
    }
}

class MyResource implements AutoCloseable {
    public void doWork() throws IOException {
        throw new IOException("Work failed");
    }

    public void close() throws Exception {
        System.out.println("Closing resource...");
        throw new Exception("Error during close");
    }
}
