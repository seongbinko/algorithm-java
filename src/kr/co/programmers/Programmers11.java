package kr.co.programmers;

public class Programmers11 {
    public static void main(String[] args) {
        int a=1111123;
        int b=12243234;
        solution(a,b);
    }
    public static void solution(int a, int b) {

        long answer;

        if(a == b) {
            answer = a;
        }
        if(a-b >0) {
            answer = a*(a+1)/2 - (b-1)*(b)/2;
        } else {
            answer = b*(b+1)/2 - (a-1)*(a)/2;
        }

        System.out.println(answer);
    }
}
