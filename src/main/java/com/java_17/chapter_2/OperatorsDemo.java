package com.java_17.chapter_2;

public class OperatorsDemo {

    public static void unaryOperators() {
        int a = 3;
        System.out.println("++a: " + (++a)); // 4
        System.out.println("a--: " + (a--)); // 4, then a becomes 3
        System.out.println("Final a: " + a); // 3
    }

    public static void complementNegation() {
        boolean asleep = false;
        int x = 5;
        System.out.println("!asleep: " + (!asleep));  // true
        System.out.println("~x: " + (~x));            // -6
    }

    public static void arithmeticOperators() {
        int div = 11 / 3;
        int mod = 11 % 3;
        System.out.println("11 / 3: " + div);   // 3
        System.out.println("11 % 3: " + mod);   // 2
    }

    public static void typePromotionAndCasting() {
        byte b = 5;
        short s = 10;
        int sum = b + s; // implicit promotion to int
        System.out.println("Sum: " + sum);
    }

    public static void compoundAssignment() {
        short x = 3;
        x *= 2.5; // compound assignment does auto cast
        System.out.println("x *= 2.5: " + x);
    }

    public static void logicalVsConditionalOperators() {
        boolean a = true, b = false;
        System.out.println("a & b: " + (a & b));    // false
        System.out.println("a && b: " + (a && b));  // false
        System.out.println("a | b: " + (a | b));    // true
        System.out.println("a || b: " + (a || b));  // true
        System.out.println("a ^ b: " + (a ^ b));    // true
    }

    public static void ternaryOperator() {
        int x = 10, y = 5;
        int max = (x > y) ? x : y;
        System.out.println("Ternary max: " + max); // 10

        int i = 1, j = 1;
        int result = (i < 2) ? i++ : j++;
        System.out.println("After ternary i,j: " + i + "," + j); // 2,1
    }

    public static void precedenceDemo() {
        int result1 = 2 + 3 * 4;       // 14
        int result2 = (2 + 3) * 4;     // 20
        System.out.println("2 + 3 * 4: " + result1);
        System.out.println("(2 + 3) * 4: " + result2);
    }

    public static void main(String[] args) {
        unaryOperators();
        complementNegation();
        arithmeticOperators();
        typePromotionAndCasting();
        compoundAssignment();
        logicalVsConditionalOperators();
        ternaryOperator();
        precedenceDemo();
    }
} 
