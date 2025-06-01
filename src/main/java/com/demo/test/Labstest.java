package com.demo.test;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Labstest {

    public static void main(String[] args) {
       // input : value labs org

       // output : grosb aleu lav

        String input="value labs org";

        char[] result= new char[input.length()];

        char[] letters = input.replaceAll(" ", "").toCharArray();
        int index = letters.length - 1;

        for (int i = 0; i <input.length(); i++) {
            if(input.charAt(i) == ' ' ){
                result[i]= ' ';
            }else{
                result[i]=letters[index--];
            }
        }
        System.out.println("new String(result) = " + new String(result));

    }
}
