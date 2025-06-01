package com.java_17.chapter_5;

import static java.lang.Math.*;

public class MethodsDemo {

    // 1. Access Modifiers and Optional Specifiers
    public static void greetPublic() {
        System.out.println("Hello from a public static method");
    }

    private final void greetPrivate() {
        System.out.println("Hello from a private final instance method");
    }

    // 2. Method Overloading
    public void doWork(String s) {
        System.out.println("String version");
    }

    public void doWork(Object o) {
        System.out.println("Object version");
    }

    public void doWork(String... s) {
        System.out.println("Varargs version");
    }

    // 3. Static Method Example
    public static void staticOnly() {
        System.out.println("Static-only method");
    }

    public void instanceMethodCallingStatic() {
        staticOnly(); // allowed
    }

    public static void staticMethodCallingInstance() {
        // new MethodsDemo().greetPrivate(); // OK via object reference
    }

    // 4. Varargs Demo
    public void printAll(String... names) {
        for (String name : names) {
            System.out.println("Name: " + name);
        }
    }

    // 5. Pass-by-Value Demo
    public void modify(StringBuilder sb) {
        sb.append("-modified");
    }

    public void reset(StringBuilder sb) {
        sb = new StringBuilder("reset");
    }

    // 6. Autoboxing/Unboxing
    public void boxingUnboxingDemo() {
        Integer a = 5;        // autoboxing
        int b = a;            // unboxing
        System.out.println("Autoboxed Integer: " + a);
        System.out.println("Unboxed int: " + b);
    }

    public void nullUnboxingDemo() {
        Integer i = null;
        try {
            int x = i; // NullPointerException
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException during unboxing");
        }
    }

    // 7. Static Import Usage
    public void staticImportDemo() {
        System.out.println("Max: " + max(10, 20));
        System.out.println("PI: " + PI);
    }

    public static void main(String[] args) {
        MethodsDemo demo = new MethodsDemo();

        greetPublic();
        demo.greetPrivate();

        demo.doWork("Nathan");            // String version
        demo.doWork((Object) "Nathan");   // Object version
        demo.doWork();                    // Varargs version

        staticOnly();
        demo.printAll("A", "B", "C");

        StringBuilder sb = new StringBuilder("Original");
        demo.modify(sb);
        System.out.println("After modify: " + sb);
        demo.reset(sb);
        System.out.println("After reset: " + sb);

        demo.boxingUnboxingDemo();
        demo.nullUnboxingDemo();
        demo.staticImportDemo();
    }
} 