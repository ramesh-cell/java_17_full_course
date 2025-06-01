package com.java_17.chapter_7;


/// INTERFACE
interface Walk {
    int MAX_DISTANCE = 100; // implicitly public static final

    void walk(); // implicitly public abstract

    default void rest() {
        System.out.println("Resting...");
    }

    static void help() {
        System.out.println("Static help method");
    }
}

/// ENUM with methods and constructors
enum Direction {
    NORTH("Up"),
    SOUTH("Down");

    private final String desc;

    Direction(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}

/// SEALED CLASS
sealed class Vehicle permits Car, Bike {
}

final class Car extends Vehicle {
}

non-sealed class Bike extends Vehicle {
} // can be extended further

// RECORD
record Animal(String species, int age) {
    public Animal {
        if (age < 0) throw new IllegalArgumentException("Age must be positive");
    }

    public String sound() {
        return species + " makes a sound!";
    }
}

/// NESTED CLASSES
class Zoo {
    class InnerEnclosure {
        void show() {
            System.out.println("Inside Inner Enclosure");
        }
    }

    static class StaticEnclosure {
        static void show() {
            System.out.println("Inside Static Enclosure");
        }
    }

    void localClassDemo() {
        class Keeper {
            void greet() {
                System.out.println("Keeper says hello");
            }
        }
        new Keeper().greet();
    }

    void anonymousClassDemo() {
        Walk walker = new Walk() {
            public void walk() {
                System.out.println("Anonymous walking");
            }
        };
        walker.walk();
    }
}

/// POLYMORPHISM EXAMPLE
class Primate {
    public boolean hasHair() {
        return true;
    }
}

interface HasTail {
    boolean isTailStriped();
}

class Lemur extends Primate implements HasTail {
    public int age = 10;

    @Override
    public boolean isTailStriped() {
        return false;
    }

    public static void polymorphismDemo() {
        Lemur lemur = new Lemur();
        HasTail tail = lemur;
        Primate primate = lemur;

        System.out.println("Lemur age: " + lemur.age);               // ✅
        System.out.println("Tail striped? " + tail.isTailStriped()); // ✅
        System.out.println("Has hair? " + primate.hasHair());        // ✅
        // System.out.println(tail.age);    ❌ Compile error
        // System.out.println(primate.isTailStriped()); ❌ Compile error
    }
}

/// RUNNER
public class BeyondClassesDemo {
    public static void main(String[] args) {
        // Interface
        Walk.help();
        Walk walker = new Walk() {
            public void walk() {
                System.out.println("Walking from interface");
            }
        };
        walker.walk();
        walker.rest();

        // Enum
        Direction d = Direction.NORTH;
        System.out.println(d + " means " + d.getDesc());

        // Sealed class
        Vehicle v1 = new Car();
        Vehicle v2 = new Bike();

        // Record
        Animal panda = new Animal("Panda", 5);
        System.out.println(panda.sound());

        // Nested class
        Zoo zoo = new Zoo();
        Zoo.InnerEnclosure inner = zoo.new InnerEnclosure();
        inner.show();
        Zoo.StaticEnclosure.show();
        zoo.localClassDemo();
        zoo.anonymousClassDemo();

        // Polymorphism
        Lemur.polymorphismDemo();
    }
}
