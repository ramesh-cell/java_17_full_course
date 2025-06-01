package com.java_17.chapter_3;

public class DecisionDemo {

    public static void ifElseDemo(int hour) {
        if (hour < 11) {
            System.out.println("Good Morning");
        } else if (hour < 15) {
            System.out.println("Good Afternoon");
        } else {
            System.out.println("Good Evening");
        }
    }

    public static void patternMatchingDemo(Object obj) {
        if (obj instanceof String name) {
            System.out.println("Uppercase: " + name.toUpperCase());
        } else {
            System.out.println("Not a string");
        }
    }

    public static void traditionalSwitch(int day) {
        switch (day) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            default:
                System.out.println("Invalid");
        }
    }

    public static void switchExpression(int day) {
        String result = switch (day) {
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            default -> "Invalid";
        };
        System.out.println("Switch expression result: " + result);
    }

    public static void loopExamples() {
        System.out.println("While loop:");
        int i = 0;
        while (i < 3) {
            System.out.println(i++);
        }

        System.out.println("Do-while loop:");
        int j = 0;
        do {
            System.out.println(j++);
        } while (j < 3);

        System.out.println("For loop:");
        for (int k = 0; k < 3; k++) {
            System.out.println(k);
        }

        System.out.println("For-each loop:");
        int[] nums = {1, 2, 3};
        for (int n : nums) {
            System.out.println(n);
        }
    }

    public static void breakContinueDemo() {
        for (int i = 0; i < 3; i++) {
            if (i == 1) continue;
            if (i == 2) break;
            System.out.println("Loop index: " + i);
        }
    }

    public static void unreachableCodeDemo() {
        while (true) {
            break;
            // System.out.println("Unreachable"); // Uncommenting will cause compile error
        }
    }

    public static void main(String[] args) {
        ifElseDemo(13);
        patternMatchingDemo("Nathan");
        traditionalSwitch(1);
        switchExpression(2);
        loopExamples();
        breakContinueDemo();
        unreachableCodeDemo();
    }
} 