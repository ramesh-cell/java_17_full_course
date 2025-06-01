package com.interview_questions;

public class HCL_NthHighestNumber {

    public static void main(String[] args) {

        int[] arr={12,3,34,65,23,8,2};

        int n=1;

        int[] top=new int[n];

        for(int i=0; i<n; i++){
            top[i]=Integer.MIN_VALUE;
        }

        for(int num: arr){
            boolean duplicate = false;

            for(int i=0;i<n;i++){

                if(top[i]==num){
                    duplicate=true;
                    break;
                }
            }
            if(duplicate)
                continue;
            for(int i=0; i<n;i++){
                if(num>top[i]){
                    //shift ele down
                    for(int j=n-1;j>i;j--){
                        top[j]=top[j-1];
                    }
                    top[i]=num;
                    break;
                }
            }

        }
        System.out.println("nthHighestNumber = " + top[n-1]);
    }


    public void m1(String s){
        System.out.println(s);
    }

    public void m1(StringBuffer sb){
        System.out.println(sb);
    }


}
