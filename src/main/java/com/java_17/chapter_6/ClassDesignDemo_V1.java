package com.java_17.chapter_6;

abstract class AnimalV1 {
    protected String name = "Unnamed";

    static {
        System.out.println("Animal static initializer");
    }

    {
        System.out.println("Animal instance initializer");
    }

    public AnimalV1() {
        System.out.println("Animal constructor");
    }

    public abstract void makeSound();

    public String getName() {
        return name;
    }
}

class DogV1 extends AnimalV1 {
    static {
        System.out.println("Dog static initializer");
    }

    {
        System.out.println("Dog instance initializer");
    }

    public DogV1() {
        super();
        this.name = "Dog";
        System.out.println("Dog constructor");
    }

    @Override
    public void makeSound() {
        System.out.println("Bark!");
    }

    public void showSuper() {
        System.out.println("Superclass name: " + super.getName());
    }
}

class Parent {
    static void greet() {
        System.out.println("Parent greet()");
    }
}

class Child extends Parent {
    static void greet() {
        System.out.println("Child greet()");
    }
}

final class ImmutableCrane {
    private final int eggs;
    private final String name;

    public ImmutableCrane(int eggs, String name) {
        this.eggs = eggs;
        this.name = name;
    }

    public int getEggs() {
        return eggs;
    }

    public String getName() {
        return name;
    }
}

public class ClassDesignDemo_V1 {
    public static void main(String[] args) {
        System.out.println("--- Creating Dog ---");
        DogV1 dog = new DogV1();
        dog.makeSound();
        dog.showSuper();

        System.out.println("--- Static Method Hiding ---");
        Parent p = new Child();
        p.greet();  // Parent's greet() because method is hidden, not overridden

        System.out.println("--- Immutable Object ---");
        ImmutableCrane crane = new ImmutableCrane(2, "Grey Crowned");
        System.out.println("Crane name: " + crane.getName());
        System.out.println("Egg count: " + crane.getEggs());
    }
}
