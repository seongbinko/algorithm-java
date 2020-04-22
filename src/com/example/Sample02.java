package com.example;

import java.util.*;

public class Sample02 {
    public static void main(String[] args) {

        int level = 10;
        getSolution(level);

        //문자 거꾸로 출력
        Scanner sc = new Scanner(System.in);
        // 공백을 포함시킬려면 nextLine으로 받았어야한다.
        String s = sc.nextLine();
//      String[] arg = s.split("");
        Stack<String> st = new Stack<String>();

        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            st.push(Character.toString(ch));
        }

//        for(String ar: arg) {
//            st.push(ar);
//        }
        while(!st.empty()) {
            System.out.print(st.pop());
        }

        //숫자배열 정렬
        int[] arr = {8,2,4,5,3,9};
        for(int i=0; i<arr.length-1; i++) {
            for(int j=i+1; j<arr.length; j++) {
                if(arr[i] > arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));

        // 369 박수횟수 세기
        int num = 100;
        int count =0;


        for(int i=1; i<=num; i++) {
            if(i%10 == 3 || i%10 == 6 || i%10 == 9) {
                count ++;
            }
        }

        for(int j=1; j<=num; j++) {

            if(j/10 == 3 || j/10==6 || j/10 ==9) {
                count ++;
            }
        }
        System.out.println(count);
    }

    public static void getSolution(int level) {
        if (level < 1) {
            return;
        }
        for(int i=0; i<level; i++) {
            System.out.print("*");
        }
        if(level > 1) {
            System.out.println();
        }
        getSolution(level-1);
    }
}
