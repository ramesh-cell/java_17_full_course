package com.java_17.chapter_1;

class Chick {
    private String name = "Fluffy";

    {
        System.out.println("Instance initializer: setting field");
    }

    public Chick() {
        name = "Tiny";
        System.out.println("Constructor: setting constructor");
    }

    public String getName() {
        return name;
    }
}