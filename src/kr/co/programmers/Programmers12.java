package kr.co.programmers;

import java.util.Arrays;
import java.util.Collections;

/*
    문자열 내림차순으로 배치하기
    문자열 s에 나타나는 문자를 큰것부터 작은 순으로 정렬해 새로운 문자열을 리턴하는 함수, solution을 완성해주세요.
    s는 영문 대소문자로만 구성되어 있으며, 대문자는 소문자보다 작은 것으로 간주합니다.
    Zbcdefg	 --> gfedcbZ
 */
public class Programmers12 {
    public static void main(String[] args) {
        String s = "Zbcdefg";

        Programmers12 programmers12 = new Programmers12();

        String answer1 = programmers12.useArrayMethod(s);
        String answer2 = programmers12.bubbleSort(s);

        System.out.println("방법1: " + answer1);
        System.out.println("방법2: " + answer2);
    }

    // 숫자 48 ~ 57
    //알파벳크기 대문자 65 ~ 90
    //         소문자 97 ~ 122
    public String useArrayMethod(String s) {

        // 1
        String[] strs = s.split("");
        Arrays.sort(strs, Collections.reverseOrder());
        StringBuilder strb1 = new StringBuilder();
        for (String str : strs) strb1.append(str);
//        return strb1.toString();

        //2
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new StringBuilder(new String(chars)).reverse().toString();


    }

    public String bubbleSort(String s) {
        char[] chars = s.toCharArray();

        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = s.length() - 1; j > i; j--) {
                if (chars[j - 1] < chars[j]) {
                    char temp = chars[j - 1];
                    chars[j - 1] = chars[j];
                    chars[j] = temp;
                }
            }
        }
        return String.valueOf(chars);

    }
}
