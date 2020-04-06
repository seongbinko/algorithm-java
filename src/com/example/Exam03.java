package com.example;

import java.util.Scanner;

/*
문제 설명
    야구게임 만들기
    1~9 까지의 수 중에서 임의의 숫자 3개를 가진 배열이 있다.(중복은 허용하지 않는다.)
    사용자로부터 숫자 3개를 입력받아서 배열에 저장한다.
    사용자가 입력한 숫자와 임의의 숫자를 비교해서
    동일한 위치에 동일한 숫자가 있는 경우 Strike
    동일한 위치는 아니지만 동일한 숫자가 존재하는 경우 Ball로 판정한다.
    예)
        임의의 숫자 [3, 7, 4] 사용자가 입력한 숫자 [1, 2, 3]  출력값은 "0S1B"이다.
        임의의 숫자 [3, 7, 4] 사용자가 입력한 숫자 [3, 4, 5]  출력값은 "1S1B"이다.
    최대 10회까지만 입력할 수 있다.
    출력값이 "3S0B" 인 경우 사용자가 숫자를 모두 맞힌 것이다.
*/
public class Exam03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] inputNumber = new int[3];
        int[] secret = new int[3];
        for(int i=0; i<secret.length; i++) {
           secret[i] = (int)(Math.random()*9 +1);

           for(int j=0; j<i; j++) {
               if(secret[i] == secret[j]) {
                   i--;
                   break;
               }
           }
        }
        int count = 1;
        while(true) {
            if(count >10) {
                System.out.println("10회를 모두 사용하였습니다");
                break;
            }
            int strike = 0;
            int ball = 0;

            System.out.println("첫 번째 숫자를 입력하세요");
            inputNumber[0] = sc.nextInt();
            System.out.println("두 번째 숫자를 입력하세요");
            inputNumber[1] = sc.nextInt();
            System.out.println("세 번째 숫자를 입력하세요");
            inputNumber[2] = sc.nextInt();

            for(int i=0; i<inputNumber.length; i++) {
                for(int j=0; j<secret.length; j++) {
                    if(inputNumber[i] == secret[j]) {
                        if(i==j) {
                            strike ++;
                        } else {
                            ball++;
                        }
                    }
                }
            }
            System.out.printf("%dS%dB\n",strike,ball);
            if(strike == 3) {
                System.out.println("정답 입니다");
                break;
            } else {
                count++;
            }
        }
        sc.close();
    }
}
