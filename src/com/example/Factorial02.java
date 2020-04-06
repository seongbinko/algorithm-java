package com.example;

public class Factorial02 {
    public static void main(String[] args) {

        int result = getFactorial(5);
        System.out.println(result);
    }
    public static int getFactorial(int n) {
        if(n == 1) {
            return 1;
        }
        return n*getFactorial(n-1);
    }
}
