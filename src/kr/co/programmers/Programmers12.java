package kr.co.programmers;

import java.util.Arrays;

/*
    문자열 내림차순으로 배치하기
    문자열 s에 나타나는 문자를 큰것부터 작은 순으로 정렬해 새로운 문자열을 리턴하는 함수, solution을 완성해주세요.
    s는 영문 대소문자로만 구성되어 있으며, 대문자는 소문자보다 작은 것으로 간주합니다.
    Zbcdefg	 --> gfedcbZ
 */
public class Programmers12 {
    public static void main(String[] args) {
        String s = "AaZz";
        solution(s);
    }
    //알파벳크기 대문자 65 ~ 90
    //         소문자 97 ~ 122
    static void solution (String s) {

        char[] chars = s.toCharArray();
        char temp;

        for(int i=0; i<s.length(); i++) {
            for(int j=0; j<s.length()-1; j++) {
                if(chars[j] < chars[j+1]) {
                    temp = chars[j];
                    chars[j] = chars[j+1];
                    chars[j+1] = temp;
                }
            }
        }
        String answer = new String(chars,0,s.length());


        System.out.println(answer);
    }
}
