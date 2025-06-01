package com.java_17.chapter_9;

import java.util.*;
import java.util.function.*;

class Duck implements Comparable<Duck> {
    private String name;

    public Duck(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }

    public int compareTo(Duck d) {
        return this.name.compareTo(d.name); // natural order
    }
}

class Crate<T> {
    private T contents;

    public void pack(T item) {
        contents = item;
    }

    public T unpack() {
        return contents;
    }
}

public class CollectionsAndGenericsDemo {

    public static void main(String[] args) {
        System.out.println(" === Lists and Sets ===");
        List<String> birds = new ArrayList<>();
        birds.add("hawk");
        birds.add("hawk");
        System.out.println("List: " + birds); // [hawk, hawk]

        Set<String> birdSet = new HashSet<>();
        birdSet.add("hawk");
        birdSet.add("hawk");
        System.out.println("Set: " + birdSet); // [hawk]

        System.out.println(" === Maps ===");
        Map<String, Integer> map = new HashMap<>();
        map.put("penguin", 1);
        map.putIfAbsent("penguin", 99); // won't override
        map.merge("penguin", 1, Integer::sum); // = 2
        map.merge("puffin", 1, Integer::sum); // added
        System.out.println("Map: " + map);

        System.out.println(" === Queue/Deque ===");
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(10); // add to front
        stack.push(4);
        System.out.println("Stack peek: " + stack.peek()); // 4
        stack.pop(); // remove front
        System.out.println("Stack after pop: " + stack);

        System.out.println(" === Comparable & Comparator ===");
        List<Duck> ducks = new ArrayList<>();
        ducks.add(new Duck("Quack"));
        ducks.add(new Duck("Puddles"));
        Collections.sort(ducks); // uses Comparable
        System.out.println("Sorted ducks: " + ducks);

        ducks.sort(Comparator.comparing(Duck::toString).reversed());
        System.out.println("Reversed ducks: " + ducks);

        System.out.println(" === Generics: Crate class ");
        Crate<String> crate = new Crate<>();
        crate.pack("Banana");
        System.out.println("Unpacked: " + crate.unpack());

        System.out.println(" === Generics with wildcards ");
        printUpperBounded(List.of("apple", "banana")); // List<? extends Object>
        addLowerBounded(new ArrayList<Object>());       // List<? super String>

        List<? extends Number> list = List.of(1, 2, 3);
        // list.add(4); // ❌ Not allowed

        List<? super Integer> writer = new ArrayList<>();
        writer.add(42); // ✅

       // Invariance of generics
       // Even though Integer is a subtype of Number, List<Integer> is not a subtype of List<Number>.
       // List<Number> numbers = new ArrayList<Integer>(); // ❌ Compile error
        List<? extends Number> nums = new ArrayList<Integer>(); // ✅

        //  2. TreeSet/TreeMap require Comparable or Comparator
      //  If you use TreeSet/TreeMap without natural ordering or a Comparator, and your class doesn't implement Comparable, it will crash at runtime.
        class Cat {

        } // not Comparable

        TreeSet<Cat> cats = new TreeSet<>();
        cats.add(new Cat()); // ❌ ClassCastException at runtime

    }

    // Upper-bounded wildcard: reading
    static void printUpperBounded(List<? extends Object> list) {
        for (Object o : list) System.out.println("Read: " + o);
    }

    // Lower-bounded wildcard: writing
    static void addLowerBounded(List<? super String> list) {
        list.add("sound");
        System.out.println("Written: " + list);
    }
}
