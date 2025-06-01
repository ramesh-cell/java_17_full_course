package com.demo.test;

import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class MapMultiDemo {
    public static void main(String[] args) {
        List<Integer> list = Stream.of(List.of(1, 2), List.of(3, 4))
                .flatMap(Collection::stream)
                .mapMulti((Integer ele, Consumer<Integer> consumer) -> {
                    consumer.accept(ele);
                }).toList();
        System.out.println("list = " + list);

    }
}
