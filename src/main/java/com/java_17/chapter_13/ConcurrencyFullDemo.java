package com.java_17.chapter_13;

import java.util.concurrent.*;
import java.util.concurrent.locks.*;
import java.util.concurrent.atomic.*;
import java.util.stream.IntStream;

public class ConcurrencyFullDemo {

    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // Basic Runnable
        Runnable task1 = () -> System.out.println("Task1 executed by: " + Thread.currentThread().getName());
        executor.execute(task1);

        // Callable + Future
        Callable<String> task2 = () -> {
            TimeUnit.MILLISECONDS.sleep(500);
            return "Callable result";
        };

        Future<String> future = executor.submit(task2);
        System.out.println("Callable result: " + future.get());

        // Synchronized Counter
        SynchronizedCounter syncCounter = new SynchronizedCounter();
        IntStream.range(0, 1000).parallel().forEach(i -> syncCounter.increment());
        System.out.println("SynchronizedCounter: " + syncCounter.get());

        // ReentrantLock Counter
        LockCounter lockCounter = new LockCounter();
        IntStream.range(0, 1000).parallel().forEach(i -> lockCounter.increment());
        System.out.println("LockCounter: " + lockCounter.get());

        // Atomic Counter
        AtomicInteger atomicCounter = new AtomicInteger(0);
        IntStream.range(0, 1000).parallel().forEach(i -> atomicCounter.incrementAndGet());
        System.out.println("AtomicInteger: " + atomicCounter.get());

        // Parallel stream example (avoid shared state here)
        System.out.println("Parallel Stream:");
        IntStream.range(1, 5).parallel().forEach(i -> System.out.print(i + " "));
        System.out.println();

        // Shut down executor
        executor.shutdown();
    }

    static class SynchronizedCounter {
        private int count = 0;

        public synchronized void increment() {
            count++;
        }

        public synchronized int get() {
            return count;
        }
    }

    static class LockCounter {
        private int count = 0;
        private final Lock lock = new ReentrantLock();

        public void increment() {
            lock.lock();
            try {
                count++;
            } finally {
                lock.unlock();
            }
        }

        public int get() {
            lock.lock();
            try {
                return count;
            } finally {
                lock.unlock();
            }
        }
    }
}
