package com.example;
/*
프로그래머스 level1 가운데 글자 가져오기
https://programmers.co.kr/skill_checks/116764/submissions/5468679?challengeable_type=ChallengeAlgorithm
*/
public class Programmers01 {

    public static void main(String[] args) {

        String s = "108274";
        System.out.println(solution(s));
    }
    public static String solution(String s) {
        String answer;

        int length = s.length();
        if (length % 2 == 0) {
            answer = s.substring(length / 2 - 1, length / 2 + 1);
        } else {
            answer = s.substring(length / 2, length / 2 + 1);
        }
        return answer;
    }
}
