package com.java_17.chapter_8;

import java.util.*;
import java.util.function.*;

public class LambdasAndFunctionalInterfacesDemo {

    record Animal(String species, boolean canHop, boolean canSwim) {
    }

    interface CheckTrait {
        boolean test(Animal a);
    }

    static void printAnimals(List<Animal> animals, CheckTrait checker) {
        for (Animal a : animals) {
            if (checker.test(a)) {
                System.out.println(a.species());
            }
        }
    }

    public static void main(String[] args) {
        List<Animal> animals = List.of(
                new Animal("Kangaroo", true, false),
                new Animal("Fish", false, true),
                new Animal("Rabbit", true, false)
        );

        // Traditional anonymous class
        printAnimals(animals, new CheckTrait() {
            public boolean test(Animal a) {
                return a.canHop();
            }
        });

        // Lambda expression
        printAnimals(animals, a -> a.canSwim());

        // Built-in Predicate
        Predicate<Animal> hopper = a -> a.canHop();
        animals.stream().filter(hopper).forEach(a -> System.out.println("Stream: " + a.species()));

        System.out.println(" Method reference: static");
        Consumer<String> con1 = System.out::println;
        con1.accept("Using method reference (static)");

        System.out.println(" Method reference: instance method on object");
        var printer = new LambdasAndFunctionalInterfacesDemo();
        Consumer<String> con2 = printer::instanceMethod;
        con2.accept("Using method reference (instance)");

        System.out.println(" Method reference: instance method on parameter");
        BiPredicate<String, String> equals = String::equals;
        System.out.println(equals.test("lion", "lion"));

        System.out.println(" Constructor reference");
        Supplier<List<String>> listCreator = ArrayList::new;
        System.out.println("New list created: " + listCreator.get());

        System.out.println("Primitive Functional Interface");
        BooleanSupplier randomCheck = () -> Math.random() > 0.5;
        System.out.println("Random result: " + randomCheck.getAsBoolean());

        // Function chaining
        Function<Integer, Integer> f1 = x -> x + 1;
        Function<Integer, Integer> f2 = x -> x * 2;
        Function<Integer, Integer> composed = f2.compose(f1); // f2(f1(x))
        System.out.println("Compose example: " + composed.apply(3)); // (3+1)*2 = 8

        // Lambda variable scope
        String greeting = "Hi";
        Runnable r = () -> System.out.println(greeting); // OK if 'greeting' is effectively final
        r.run();
    }

    void instanceMethod(String msg) {
        System.out.println("From instance: " + msg);
    }
}
