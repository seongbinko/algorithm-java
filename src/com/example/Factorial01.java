package com.example;

public class Factorial01 {
    public static void main(String[] args) {
        int result = getFactorial(5);

        System.out.println(result);
    }
    public static int getFactorial(int n) {
        int result = 1;
        for(int i=n; i>0; i--) {
            result *= i;
        }
        return result;
    }
}
