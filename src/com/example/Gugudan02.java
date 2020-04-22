package com.example;

import java.util.Scanner;

public class Gugudan02 extends RuntimeException {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("구구단 계산기, 단을 입력하세요");
            int level = sc.nextInt();
            getGugudan(level,1);

            System.out.println("Y/N 선택");
            String text = sc.next();
            if(text.equals("N")) {
                break;
            }
        }

    }
    public static void getGugudan(int level, int depth)  {
        if(level >9) {
            throw new RuntimeException("어유");
        }
        if(depth > 9) {
            return;
        }
        System.out.printf("%d*%d=%d\t", level, depth, level*depth);
        getGugudan(level, depth+1);
    }
}
