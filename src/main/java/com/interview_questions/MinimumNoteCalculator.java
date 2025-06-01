package com.interview_questions;

import java.util.Arrays;

public class MinimumNoteCalculator {


    public static void main(String[] args) {

       // Suppose we have currency notes array,
       // int[] aa={5,10,20,50,100,500,1000};
       // Amount =1535;
        //Print Minimum no. Of notes required.
        /*Integer[] notes={5,10,20,50,100,500,1000};
        int amount=1635;

        Arrays.sort(notes, Collections.reverseOrder());

        for (int note :notes){
            if(amount>=note){
                int count =amount/note;
                amount=amount%note;
                System.out.println(note +" X "+count);
            }
        }*/



        //If we have
       // int[] aa={3,6,8,0,2,7,0,1}

        //Output should be aa={3,6,8,2,7,1,0,0}
        int[] aa={3,6,8,0,2,7,0,1};
        int index=0;
        for (int i = 0; i < aa.length; i++) {
            if(aa[i]!=0){
                aa[index++]=aa[i];
            }
        }
        while (index<aa.length){
            aa[index++]=0;
        }
        System.out.println(Arrays.toString(aa));

  /*select * from employees
   where
                salary =(
                        select distinct salary
                        from employees
                        order by salary desc
                        limit 1 offset 1
                )*/
    }
}
