package com.java_17.chapter_5;

import static java.lang.Math.*; // Static import example

public class Chapter5MethodsDemo {

    // 1. Method Overloading
    public void fly(int i) {
        System.out.println("fly(int)");
    }

    public void fly(long l) {
        System.out.println("fly(long)");
    }

    public void fly(Integer i) {
        System.out.println("fly(Integer)");
    }

    public void fly(int... nums) {
        System.out.println("fly(varargs)");
    }

    // 2. Varargs usage
    public void log(String label, int... values) {
        System.out.print(label + ": ");
        for (int v : values) {
            System.out.print(v + " ");
        }
        System.out.println();
    }

    // 3. Static Method
    public static void staticLog(String message) {
        System.out.println("[STATIC] " + message);
    }

    // 4. Static Initializer
    static {
        System.out.println("Static block executed");
    }

    // 5. Passing Objects
    public void modifyObject(StringBuilder sb) {
        sb.append(" + modified");
        sb = new StringBuilder("new object"); // local only
    }

    // 6. Returning Objects
    public StringBuilder createSB() {
        return new StringBuilder("Returned StringBuilder");
    }

    // 7. Autoboxing
    public void autoBoxDemo() {
        Integer i = 10;
        int j = i; // unboxing
        System.out.println("Autoboxed value: " + j);
    }

    // 8. Effectively Final Variable in Lambda
    public void lambdaScopeDemo() {
        int limit = 100;
        Runnable r = () -> System.out.println("Limit: " + limit);
        r.run();
    }

    // 9. Using static import
    public void staticImportDemo() {
        double radians = toRadians(90); // from Math
        System.out.println("sin(90°) = " + sin(radians));
    }

    // MAIN method to run all demos
    public static void main(String[] args) {
        Chapter5MethodsDemo demo = new Chapter5MethodsDemo();

        // Method overloading
        demo.fly(10);         // int
        demo.fly(10L);        // long
        demo.fly(Integer.valueOf(10)); // Integer
        demo.fly();           // varargs

        // Varargs
        demo.log("Numbers", 1, 2, 3, 4);

        // Static method access via instance
        demo.staticLog("Called via instance (not recommended)");

        // Passing object
        StringBuilder sb = new StringBuilder("original");
        demo.modifyObject(sb);
        System.out.println("After modifyObject: " + sb);

        // Returning object
        StringBuilder returned = demo.createSB();
        System.out.println("Returned: " + returned);

        // Autoboxing
        demo.autoBoxDemo();

        // Effectively final demo
        demo.lambdaScopeDemo();

        // Static import
        demo.staticImportDemo();
    }
}
