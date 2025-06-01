package com.java_17.chapter_1;

class Bird {
    {
        System.out.println("Instance initializer block - Bird created");
    }

    public Bird() {
        System.out.println("Bird constructor");
    }
}