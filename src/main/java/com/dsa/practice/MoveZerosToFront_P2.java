package com.dsa.practice;

import java.util.Arrays;

public class MoveZerosToFront_P2 { 
    public static String moveZerosToFront(String str) {
        char[] res = new char[str.length()];
        
        int count = res.length - 1; 
        for (int i = str.length() - 1; i >= 0; i--) {
            char ch = str.charAt(i);
            if (ch != '0') {
                res[count] = ch;
                count--;
            }
        }
        
        // fill remaining with '0'
        while (count >= 0) {
            res[count] = '0';
            count--;
        }
        return new String(res);
    }

    public static void main(String[] args) {
        String input = "32400121200";
        String result = moveZerosToFront(input);
        System.out.println(result);  
    }
}