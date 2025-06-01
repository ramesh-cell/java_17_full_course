package com.java_17.chapter_1;

class TextBlockExample {
    public static void printTextBlock() {
        String html = """
            <html>
                <body>
                    <h1>Hello, Java 17!</h1>
                </body>
            </html>
            """;
        System.out.println(html);
    }
}