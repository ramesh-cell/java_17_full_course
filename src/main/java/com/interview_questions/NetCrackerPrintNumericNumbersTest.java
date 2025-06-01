package com.interview_questions;

import java.util.Arrays;
import java.util.List;

public class NetCrackerPrintNumericNumbersTest {


    public static void main(String[] args) {

        List<String> list = Arrays.asList("1","2","three","4","5");
        //TODO: PRINT THE NUMERICS(NUMBERS)
        //OUTPUT: 1,2,4,5
        list.stream()
                .filter(num->num.matches("\\d+"))
                .map(Integer::parseInt)
                .forEach(isNumber->{
                    System.out.println("Numeric Numbers =>"+isNumber);
                });

    }
}
