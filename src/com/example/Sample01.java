package com.example;

import java.util.*;

public class Sample01 {
    static int a;


    public static void main(String[] args) {
        Sample01.a = 3;
        getNumber(Sample01.a);

        //문자열 거꾸로 나열하기 Collections.reverseOrder();
        String x = "bacd";
        StringBuilder str = new StringBuilder();
        str.append(x);

        System.out.println(str.reverse());

        Stack<String> stack = new Stack<>();
        for(int i=0; i<x.length(); i++) {
            char ch =x.charAt(i);
            stack.push(String.valueOf(ch));
        }
        while(!stack.isEmpty()) {
            System.out.print(stack.pop());

        }

        String[] strings = new String[x.length()];
        for(int i=0; i<x.length(); i++) {
            char ch =x.charAt(i);
            strings[i] = String.valueOf(ch);
        }
        Arrays.sort(strings,Collections.reverseOrder());
        System.out.println("내림차순 정렬 " + Arrays.toString(strings));

        Queue<String> q = new LinkedList<>();
        for(int i=0; i< x.length(); i++) {
            String temp = String.valueOf(x.charAt(i));
            q.offer(temp);
        }
        for(String temp: q) {
            System.out.print(temp);
        }
        System.out.println(q.poll());



        //수열 1씩 증가하는 합 구현
        int x1 = 10;
        int sum2 = 0;

        for(int i=1; i<= x1; i++) {
            sum2 += i;
        }
        System.out.println(sum2);
        System.out.println((x1)*(x1+1)/2);


        // 정수 입력받고 오름차순 정리
        int[] arr = {10,20,8,3,2};
        ArrayList<Integer> arr2 = new ArrayList<>();
        for(int ar : arr) {
            arr2.add(ar);
        }

        Collections.sort(arr2,Collections.reverseOrder());
        System.out.println(Arrays.toString(arr2.toArray()));

        for(int i=0; i<arr.length -1; i++) {
            for(int j=i+1; j<arr.length; j++) {
                if(arr[i] < arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));



        //n 까지의 소수의 합 구하기 1,2,3,5,7,11 13 15 (1 3 5 15)
        int n = 7;
        int sum = 0;
        for(int i=2; i<=n; i++) {

            int count =0;
            for(int j=1; j<=i; j++) {
                if (i % j == 0) {
                    count++;
                }
            }
            if(count == 2) {
                sum += i;
            }
        }
        System.out.println(sum);

        final int MAX_VALUE;
        MAX_VALUE =3;

        getNumber(MAX_VALUE);

        getNumber(5);


    }
    public static final void getNumber(int a) {
        System.out.println(a);
    }
}
