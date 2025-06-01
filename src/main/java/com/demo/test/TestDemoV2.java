package com.demo.test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TestDemoV2 {
    public static void main(String[] args) {

        List<Integer> names = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            names.add(i);
        }
        names.remove(9);
        List<Integer> collect = IntStream.range(0, 10).boxed().collect(Collectors.toList());
        collect.removeAll(names);

        System.out.println("collect = " + collect);
       // List<Integer> sequenceNumbers = List.of(1,100);
        //removeList : 23
        //list of 100 numbers
        //list.removeAll(removeList)
        //find out two numbers missing




    }




}
