package com.interview_questions;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LRUCacheMap implements a simple LRU cache using LinkedHashMap.
 */
public class LRUCacheMap<K, V> extends LinkedHashMap<K, V> {

    private final int capacity;

    public LRUCacheMap(int capacity) {
        super(capacity, 0.75f, true); // accessOrder = true for LRU
        this.capacity = capacity;
    }

    /**
     * Remove the eldest entry if the size exceeds the capacity.
     */
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;
    }

    public void display() {
        System.out.println("cache = " + this);
    }
}
