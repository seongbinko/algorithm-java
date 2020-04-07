package com.example;

import java.util.Arrays;

public class Programmers02 {

    public static void main(String[] args) {
        String[] strings = {"sun", "bed", "car"};
        int n = 1;

        String[] answer =  solution(strings,n);
        for(String tostr : answer) {
            System.out.println(tostr);
        }
    }

    public static String[] solution(String[] strings, int n) {

        String[] answer;
        answer = new String[strings.length];

        // 조건 1: strings의 배열 각 원소의 n번 인덱스의 글자를 기준으로 정렬
        // 조건 2: n번 인덱스의 글자가 중복일 경우 사전 순으로 정렬해야함

        // n번 인덱스 글자를 strings 배열 각 원소의 맨 앞에 붙이고 정렬 후 맨 앞 글자를 제거

        for (int i = 0; i < strings.length; i++) {
            String addOn = strings[i].substring(n, n + 1);
            strings[i] = addOn + strings[i];
        }

        Arrays.sort(strings);

        for (int i = 0; i < strings.length; i++) {
            answer[i] = strings[i].substring(1);
        }

        return answer;
    }
}
