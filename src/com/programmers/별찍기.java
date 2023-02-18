package com.programmers;

import java.util.Scanner;

public class 별찍기 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 1. n을 입력 받기
        sc.close();

        for (int i = 1; i <= n; i++) { // 2. 1부터 i를 1씩 증가하며 반복하기
            for (int j = 1; j <= i; j++) { // 3.  i의 갯수 만큼
                System.out.print("*"); //         별 출력하기
            }
            if (i != n) { // 5. n이라면 줄바꾸지 않기
                System.out.println(); // 4. 줄바꾸기
            }
        }
    }
}
