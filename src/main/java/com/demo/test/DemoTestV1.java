package com.demo.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DemoTestV1 {

    public static void main(String[] args) {
      /* // Reverse the String with keeping the spaces intact:
        //In/Put: My name is ABC
            //Out/Put: CB Asie ma nyM
        String input ="My name is ABC";

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
        System.out.println("new String(result) = " + new String(result));*/
        /*Input :
        --------
                2,-1,0,4,0,1,-5
        Output
                -------
                {2,-1,4,1,-5,0,0}*/
        List<Integer> numbers = Arrays.asList(2,-1,0,4,0,1,-5);
        List<Integer> customSorted =
                numbers
                        .stream()
                        .sorted((a,b)-> {
                            if(a==0 && b!=0) {
                                return 1;
                            }
                            if(b==0 && a!=0) {
                                return -1;
                            }
                            if((a>0 && b>0) || (a<0 && b<0)) {
                                return a - b;
                            }
                            return 0;
                        })
                        .collect(Collectors.toList());
        System.out.println("customSorted = " + customSorted);
    }
}
