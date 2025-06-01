package com.demo.test;

public class Bird {
    {
        System.out.println("Snowy");
    }  // Instance initializer

    public static void main(String[] args) {
        {
            System.out.println("Feathers");
        } // Code block inside method


        /// 🧠 7. Text Blocks (Java 15+)
        String text = """
                "Java Study Guide"
                   by Scott & Jeanne
                """;
/// 🧶 8. var Keyword (Java 10+)
        var name = "Nathan";  // inferred as String

    }
}
