package com.java_17.chapter_1;

class GarbageCollectorDemo {
    static class Bear {
        String name;

        Bear(String name) {
            this.name = name;
        }
    }

    public static void demonstrateGC() {
        Bear b1 = new Bear("B1");
        Bear b2 = new Bear("B2");
        b1 = b2; // Original Bear("B1") is now unreachable
        System.gc();
        System.out.println("GC simulation done");
    }
}