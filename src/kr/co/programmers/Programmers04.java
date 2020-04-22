package kr.co.programmers;

import java.util.Arrays;

/*
* 자연수 n을 뒤집어 각 자리 숫자를 원소로 가지는 배열 형태로 리턴해주세요. 예를들어 n이 12345이면 [5,4,3,2,1]을 리턴합니다.
* */
public class Programmers04 {
    public static void main(String[] args) {
        long n = 1234567891039878554L;
        //solution01(n);
        solution02(n);
    }

    public static void solution01(long n) {
        String str = String.valueOf(n);
        String[] arr = str.split("");

        int[] answer = new int[arr.length];

        int j = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            answer[j] = Integer.parseInt(arr[i]);
            j++;
        }

        for (int i : answer) System.out.println(i);
    }
    public  static  void solution02(long n) {
        String str = Long.toString(n);
        int[] answer = new int[str.length()];

        StringBuilder sb = new StringBuilder(str);
        sb.reverse();

        String[] text = sb.toString().split("");

        for (int i = 0; i < answer.length; i++) {
            answer[i] = Integer.parseInt(text[i]);

        }
        System.out.println(Arrays.toString(answer));
    }
}