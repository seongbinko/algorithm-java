package com.example;
/*
문제설명
    임의의 길이의 양의 정수를 입력받는다.
    입력받은 숫자를 한글 숫자 단위로 변경해서 출력한다.
    예) 1234 -> 천이백삼십사
    * 숫자가  0이거나 1인 경우 한글이름을 생략할 수 있다.
*/
import java.util.Scanner;
public class Exam04 {
    public static void main(String[] args) {
        String[] positions = {"", "십", "백", "천"};
        String[] units = {"", "만", "억", "조", "경", "해", "자", "양", "구", "간", "정", "재", "극"};
        String[] names = {"", "일", "이", "삼", "사", "오", "육", "칠", "팔", "구"};

        Scanner sc = new Scanner(System.in);
        System.out.println("임의의 숫자를 입력하세요");
        String text = sc.next();
        int len = text.length();

        StringBuilder builder = new StringBuilder();
        boolean isNotZero = false;
        for(int index=0; index<len; index++) {
            int number = Integer.parseInt(text.substring(index,index+1));
            int positionIndex = (len - index -1) %4;
            int unitIndex = (len - index - 1)/4;
            if (number != 0) {
                if (number == 1) {
                    if (positionIndex == 0) {
                        builder.append(names[number]);
                    }
                } else {
                    builder.append(names[number]);
                }
                builder.append(positions[positionIndex]);
                isNotZero = true;
            }
            if ((len - index - 1)%4 == 0) {
                if (isNotZero) {
                    builder.append(units[unitIndex]);
                }
                isNotZero = false;
            }
        }
        System.out.println("["+text+"] ----> " +builder.toString());
        sc.close();
    }
}
