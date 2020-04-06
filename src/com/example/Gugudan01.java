package com.example;

import java.util.Scanner;

public class Gugudan01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("구구단 계산기");
        boolean isContinue = true;
        while (isContinue) {
            System.out.println("단을 입력하세요");
            int dan = sc.nextInt();
            System.out.println(dan+"단을 실행합니다");
            for(int i=1; i<10; i++) {
                System.out.println(dan+"*"+i+"=" + dan*i);
            }
            System.out.println("계속 하시겠습니까? Y/N");
            String text = sc.next();
            if("N".equals(text)) {
                isContinue = false;
            }
        }
    }
}
