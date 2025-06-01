package com.interview_questions;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GlobalLogic_MissingElementsExtractor {
    public static void main(String[] args) {

        List<Integer> fullList = IntStream.rangeClosed(1, 100).boxed().toList();

        // Example: 23 and 57 are removed
        List<Integer> modifiedList = new ArrayList<>(fullList);
        modifiedList.remove(Integer.valueOf(23));
        modifiedList.remove(Integer.valueOf(57));

        List<Integer> missing = new ArrayList<>(fullList);
        missing.removeAll(modifiedList);

        System.out.println("Missing Numbers: " + missing); // [23, 57]

    }




}
