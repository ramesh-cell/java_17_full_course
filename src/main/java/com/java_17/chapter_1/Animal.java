package com.java_17.chapter_1;

// Demonstrates basic class structure
public class Animal {
    private String name;

    public Animal() {
        System.out.println("Animal constructor called");
    }

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}