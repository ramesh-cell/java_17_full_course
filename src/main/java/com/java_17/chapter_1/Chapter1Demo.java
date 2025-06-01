package com.java_17.chapter_1;

public class Chapter1Demo {
    public static void main(String[] args) {
        Animal animal = new Animal("Leo");
        System.out.println("Animal name: " + animal.getName());

        new Bird();
        Chick chick = new Chick();
        System.out.println("Chick name: " + chick.getName());

        TextBlockExample.printTextBlock();
        VarKeywordDemo.demonstrateVar();
        GarbageCollectorDemo.demonstrateGC();
    }
}