package com.java_17.chapter_14;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

public class IOFullDemo {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Path filePath = Paths.get("example.txt");
        Files.writeString(filePath, "First line\nSecond line");

        System.out.println("=== Files.readAllLines() ===");
        List<String> lines = Files.readAllLines(filePath);
        lines.forEach(System.out::println);

        System.out.println("\n=== Files.lines() (lazy) ===");
        Files.lines(filePath).filter(s -> s.contains("First")).forEach(System.out::println);

        System.out.println("\n=== newBufferedReader() & newBufferedWriter() ===");
        Path output = Paths.get("copy.txt");
        try (var reader = Files.newBufferedReader(filePath);
             var writer = Files.newBufferedWriter(output)) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
        }

        System.out.println("\n=== Serialization ===");
        Giraffe g = new Giraffe("George", 12);
        try (var oos = new ObjectOutputStream(new FileOutputStream("giraffe.dat"));
             var ois = new ObjectInputStream(new FileInputStream("giraffe.dat"))) {
            oos.writeObject(g);
            Giraffe g2 = (Giraffe) ois.readObject();
            System.out.println("Deserialized: " + g2);
        }
    }

    static class Giraffe implements Serializable {
        private String name;
        private transient int age; // won't be saved
        Giraffe(String name, int age) {
            this.name = name;
            this.age = age;
        }
        public String toString() { return name + " (age: " + age + ")"; }
    }
}
