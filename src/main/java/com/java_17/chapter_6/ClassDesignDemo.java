package com.java_17.chapter_6;// ClassDesignDemo.java

import java.util.*;

class Animal {
    private int age;
    protected String name;

    public Animal(int age) {
        this.age = age;
    }

    public Animal(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void speak() {
        System.out.println("Animal speaking");
    }
}

// Demonstrates inheritance, method overriding, and use of super/this
class Dog extends Animal {
    public Dog() {
        this(5, "Buddy");
    }

    public Dog(int age, String name) {
        super(age, name);
    }

    @Override
    public void speak() {
        System.out.println(getName() + " says: Woof!");
    }
}

// Demonstrates variable hiding
class Reptile {
    protected int speed = 10;
}

class Crocodile extends Reptile {
    protected int speed = 20;

    public void showSpeed() {
        System.out.println("Speed (Crocodile): " + this.speed);      // 20
        System.out.println("Speed (Reptile): " + super.speed);       // 10
    }
}

// Demonstrates initialization order
class Base {
    static {
        System.out.println("Base static");
    }

    {
        System.out.println("Base instance");
    }

    public Base() {
        System.out.println("Base constructor");
    }
}

class Derived extends Base {
    static {
        System.out.println("Derived static");
    }

    {
        System.out.println("Derived instance");
    }

    public Derived() {
        super();
        System.out.println("Derived constructor");
    }
}

// Demonstrates immutability via defensive copy
final class ImmutableAnimal {
    private final List<String> favoriteFoods;

    public ImmutableAnimal(List<String> foods) {
        if (foods == null || foods.isEmpty()) {
            throw new IllegalArgumentException("Empty food list");
        }
        this.favoriteFoods = new ArrayList<>(foods); // defensive copy
    }

    public int getFoodCount() {
        return favoriteFoods.size();
    }

    public String getFood(int index) {
        return favoriteFoods.get(index);
    }
}

public class ClassDesignDemo {
    public static void main(String[] args) {
        System.out.println("=== Inheritance ===");
        Dog d = new Dog();
        d.speak();
        System.out.println(d.getAge());

        System.out.println("\n=== Variable Hiding ===");
        Crocodile c = new Crocodile();
        c.showSpeed();

        System.out.println("\n=== Initialization Order ===");
        Derived derived = new Derived();

        System.out.println("\n=== Immutability ===");
        List<String> foods = new ArrayList<>();
        foods.add("Bamboo");
        ImmutableAnimal panda = new ImmutableAnimal(foods);

        System.out.println("Food: " + panda.getFood(0));
        foods.clear();  // won't affect internal list
        System.out.println("Food after external clear: " + panda.getFood(0)); // still "Bamboo"
    }
}
