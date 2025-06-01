package com.demo.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class LeaderElementFinder {

    public static void main(String[] args) {

        List<Integer> list = List.of(0, 11, 3, 9, 0, 3, 6, 2); // Expected: [11, 9, 2]
        List<Integer> result = new ArrayList<>();
        int[] maxFromRight = {Integer.MIN_VALUE};

        IntStream.range(0, list.size())
                .map(i -> list.size() - 1 - i)
                .forEach(i -> {
                    if (list.get(i) > maxFromRight[0]) {
                        result.add(list.get(i));
                        maxFromRight[0] = list.get(i);
                    }
                });

        Collections.reverse(result);
        System.out.println("Leaders: " + result);
    }
}
