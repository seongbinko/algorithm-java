package com.leetcode.string;

import java.math.BigInteger;

// https://leetcode.com/problems/plus-one/submissions/
public class PlusOne_04 {

    public static void main(String[] args) {
//		int[] digits = {9,9,9};
//		int[] digits = {9,8,9};
//		int[] digits = {8,9,9};
//		int[] digits = {0,0,1};
//		int[] digits = {0,0};
//		int[] digits = {9,0,0,9};
		int[] digits = {9,9,9,9,9};
        PlusOne_04 plusOne_04 = new PlusOne_04();

        int[] solve = plusOne_04.solve(digits);
        for(int val : solve) {
            System.out.println("val = " + val);
        }
    }

    public int[] mySolution(int[] digits) {
        // 1. String으로 만들기
        StringBuilder sb = new StringBuilder();
        for(int d : digits) {
            sb.append(d);
        }
        // 2. 수로 바꿔서 + 1하기 // 제약 조건상 long으로 해야함
        BigInteger bigInteger = new BigInteger(sb.toString());
        bigInteger.add(BigInteger.ONE);

        // 3 갯수만큼 배열을 만들기
        String str = String.valueOf(bigInteger);
        int len = str.length();
        int[] answer = new int[len];
        // 4. 값 넣어주기
        for(int i = 0; i < len; i++) {
//            answer[i] = Integer.valueOf(String.valueOf(str.charAt(i)));
            answer[i] = str.charAt(i) - '0';
            System.out.println("answer[i] = " + answer[i]);
        }
        return answer;
    }

    public int[] solve(int[] digits) {
        // 1. 수의 맨 뒷 자리를 체크해서 + 1해준다.
        int n = digits.length;
        // 2. 만약 수가 10이 될 경우 처리
        for(int i = n-1; i >=0; i--) {
            digits[i] ++;

            if(digits[i] < 10) {
                return digits;
            }
            digits[i] = 0;
        }
        int[] res = new int[n + 1];
        res[0] = 1;

        return res;
    }
}
