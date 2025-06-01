package com.interview_questions;

import java.util.Map;
import java.util.WeakHashMap;

public class LRUWeakHashTest {

    public static void main(String[] args) throws InterruptedException {
        testWeakHashMap();
        testLRUCache();
    }

    private static void testWeakHashMap() throws InterruptedException {
        Map<String, Integer> weakMap = new WeakHashMap<>();

        String x1 = new String("X1");
        String x2 = new String("X2");

        weakMap.put(x1, 1);
        weakMap.put(x2, 2);

        System.out.println("Before GC: " + weakMap);

        // Remove strong references
        x1 = null;
        x2 = null;

        System.gc();
        Thread.sleep(5000); // Wait for GC to collect

        System.out.println("After GC: " + weakMap);
    }

    private static void testLRUCache() {
        LRUCacheMap<String, Integer> lruCache = new LRUCacheMap<>(3);

        lruCache.put("foo1", 1);
        lruCache.put("foo2", 2);
        lruCache.put("foo3", 3);

        // Access foo1 to make it recently used
        lruCache.get("foo1");

        System.out.print("Cache before eviction: ");
        lruCache.display();

        // This will evict foo2 (the least recently used)
        lruCache.put("foo4", 4);

        System.out.print("Cache after eviction: ");
        lruCache.display();
    }
}
