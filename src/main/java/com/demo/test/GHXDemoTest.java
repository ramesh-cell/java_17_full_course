//package com.demo.test;
//
//
//
//public class GHXDemoTest {
//
//    private static final Pattern ROMAN_PATTERN = Pattern.compile("^M{0,3}(CM|CD|D?C{0,3})"+"(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$");
//
//    public static void main(String[] args) {
//        /*
//        * I = 1
//          V = 5
//          X = 10
//          L = 50
//          C = 100
//          D = 500
//          M = 1,000
//       * */
//        /*Standard Rule Overview
//        Numerals are generally written from large numeral character value to small in an additive fashion
//                (i.e.  ‘MDL’ would be 1,550, but ‘LDM’ is an invalid roman numeral) except when the subtractive
//                feature is in use (see next rule)
//        There is a subtractive feature to decrement a value from a larger value to simplify numerals
//        (i.e.  ‘IV’ is 4 because 1 is subtracted from 5.  ‘CD’ would be 400).
//        This only happens in pairs where the first numeral is the subtractor from the second numeral.
//        You could have combinations of subtractors in a roman numeral like ‘CDIV’ which would be 404
//        You cannot have the same numeral repeated if it adds up to the next higher numeral
//        (i.e. ‘VV’ is invalid because ‘X’ is the representation for 10).
//        This is true for any combinations of roman numerals like ‘IIIII’, ‘XXXXX’, etc.*/
//
//        String roman = "XXXXX";//404
//
//       if(isvalidRoman(roman)) {
//           int value = romanToInt(roman);
//           System.out.println("Valid Roman Numeral Value = " + value);
//       }else {
//           System.out.println("Invalid ROman Numeral = " + roman);
//       }
//       }
//
//    }
//
//    public static boolean isvalidRoman(String roman){
//        return ROMAN_PATTERN.matcher(roman).matches();
//    }
//
//    private static int romanToInt(String s) {
//        Map<Character, Integer> romanMap = new HashMap<>();
//        romanMap.put('I', 1);
//        romanMap.put('V', 5);
//        romanMap.put('X', 10);
//        romanMap.put('L', 50);
//        romanMap.put('C', 100);
//        romanMap.put('D', 500);
//        romanMap.put('M', 1000);
//
//
//
//
//        if(!isvalidRoman(s)){
//            throw new IllegalArgumentException("Invalid Roman numral :"+s);
//        }
//        int total = 0;
//        int prev = 0;
//
//        for (int i = s.length() - 1; i >= 0; i--) {
//            int current = romanMap.get(s.charAt(i));
//            total+=(current<prev)?-current:current;
//            prev = current;
//
//        }
//        return total;
//    }
//
