package kr.co.programmers;
/*
*   문제 설명
        정수 num이 짝수일 경우 Even을 반환하고 홀수인 경우 Odd를 반환하는 함수, solution을 완성해주세요.
    제한 조건
        num은 int 범위의 정수입니다.
0은 짝수입니다.
* */
public class Programmers05 {

    public static void main(String[] args) {
        int n = 3;
        solution(n);
    }

    public static void solution(int num) {
        String answer = "";

        if(num %2 == 0) {
            answer ="Even";
        } else {
            answer = "Odd";
        }

        System.out.println(answer);
    }
}
