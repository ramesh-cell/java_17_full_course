package com.java_17.chapter_10;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class StreamsDemo {

    public static void main(String[] args) {
        List<String> animals = List.of("lion", "tiger", "bear", "leopard");

        // Filter and map example
        animals.stream()
                .filter(s -> s.length() > 4)
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);

        // Reduction with Stream
        Stream<Integer> stream = Stream.of(1, 2, 3);
        System.out.println("Reduced sum: " + stream.reduce(0, Integer::sum));

        // Optional from terminal operation
        Optional<String> first = animals.stream().findFirst();
        first.ifPresent(System.out::println);

        // Primitive Stream
        IntStream intStream = IntStream.rangeClosed(1, 5);
        System.out.println("Average: " + intStream.average().orElse(0));

        // Collectors
        List<String> upper = animals.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("Collected: " + upper);

        // Grouping
        Map<Integer, List<String>> grouped = animals.stream()
                .collect(Collectors.groupingBy(String::length));
        System.out.println("Grouped: " + grouped);

        // Partitioning
        Map<Boolean, List<String>> partitioned = animals.stream()
                .collect(Collectors.partitioningBy(s -> s.length() > 4));
        System.out.println("Partitioned: " + partitioned);

        // Infinite Stream (limit to prevent hang)
        Stream.generate(() -> "hi")
                .limit(3)
                .forEach(System.out::println);

        // Parallel Stream
        List.of("a", "b", "c").parallelStream().forEach(System.out::println);

        ///🔸 1. Lazy Evaluation
        /// Streams don’t do anything until terminal operations are called.
        Stream<String> s = Stream.of("a", "b");
        s.filter(x -> true); // ❌ Nothing happens

        /// 🔸 2. Stream Reuse
        /// Streams are single-use.
        Stream<String> reused = Stream.of("a");
        reused.forEach(System.out::println);
        // reused.forEach(System.out::println); // ❌ IllegalStateException


        /// 🔸 4. Stateful Lambdas in Parallel Streams
        List<Integer> unsafe = new ArrayList<>();
        IntStream.range(1, 5).parallel().forEach(unsafe::add); // ❌ unpredictable
        /// Always avoid modifying shared state inside a lambda. Use collect() safely instead.

        Stream.iterate(1, n -> n + 1).limit(5).mapToInt(x -> x).sum();
        /// O/P:15

        /// 🔸 3. Infinite Streams + Terminal Operation Order
        ///Q2: What happens?
        // Stream.generate(() -> "Elsa").sorted().limit(2).forEach(System.out::println); // ❌ hangs
        /// A: ❌ Hangs – sorted waits for all input from infinite stream
        Stream.generate(() -> "x").limit(2).sorted().forEach(System.out::println); // ✅ OK
/// Explanation: sorted() is a stateful intermediate op that requires knowing all elements.
///Use limit() first to avoid hanging.


///        Q3: What's wrong here?
        Stream<Integer> stream1 = Stream.of(1, 2, 3);
        stream1.map(x -> x * 2);
        System.out.println(stream1.count());
        ///     A: ❌ Nothing happens from map, count() processes original stream


    }
}
