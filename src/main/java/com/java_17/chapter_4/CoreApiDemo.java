package com.java_17.chapter_4;

import java.time.*;
import java.util.Arrays;

public class CoreApiDemo {

    public static void stringOperations() {
        String name = "Nathan";
        System.out.println(name.length());             // 6
        System.out.println(name.charAt(2));            // t
        System.out.println(name.indexOf("a"));        // 1
        System.out.println(name.substring(1, 4));      // ath
        System.out.println(name.toUpperCase());        // NATHAN
        System.out.println(name.replace("a", "*"));  // N*th*n
    }

    public static void stringBuilderOperations() {
        StringBuilder sb = new StringBuilder("Java");
        sb.append(" SE").reverse().insert(0, "17-");
        System.out.println(sb); // 17-ES avaJ
    }

    public static void equalityCheck() {
        String a = "Test";
        String b = new String("Test");
        System.out.println(a == b);        // false
        System.out.println(a.equals(b));   // true
    }

    public static void arrayOperations() {
        int[] nums = {3, 1, 4, 1, 5};
        Arrays.sort(nums);
        System.out.println("Sorted: " + Arrays.toString(nums));
        int idx = Arrays.binarySearch(nums, 4);
        System.out.println("Index of 4: " + idx);
    }

    public static void varargsDemo(String... args) {
        for (String arg : args) {
            System.out.println("Arg: " + arg);
        }
    }

    public static void mathApiDemo() {
        System.out.println(Math.max(3, 7));      // 7
        System.out.println(Math.round(123.5));   // 124
        System.out.println(Math.pow(2, 3));      // 8.0
        System.out.println(Math.random());       // 0.0 - 1.0
    }

    public static void dateTimeApiDemo() {
        LocalDate date = LocalDate.of(2025, Month.JUNE, 1);
        LocalTime time = LocalTime.now();
        LocalDateTime dt = LocalDateTime.of(date, time);
        ZonedDateTime zdt = ZonedDateTime.of(dt, ZoneId.of("US/Eastern"));
        System.out.println("Zoned DateTime: " + zdt);
        System.out.println("Day of week: " + zdt.getDayOfWeek());

        Period p = Period.ofDays(10);
        Duration d = Duration.ofHours(5);
        System.out.println("Period: " + p);
        System.out.println("Duration: " + d);
    }

    public static void main(String[] args) {
        stringOperations();
        stringBuilderOperations();
        equalityCheck();
        arrayOperations();
        varargsDemo("Java", "17", "OCP");
        mathApiDemo();
        dateTimeApiDemo();
    }
} 
