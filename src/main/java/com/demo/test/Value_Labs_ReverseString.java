package com.demo.test;

public class Value_Labs_ReverseString {

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
