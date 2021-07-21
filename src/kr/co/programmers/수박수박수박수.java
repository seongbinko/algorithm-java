package kr.co.programmers;

public class 수박수박수박수 {
    public static void main(String[] args) {
        solution(5);
    }

    public static void solution(int n) {

        String a = "수";
        String b = "박";
        String answer = "";
        for (int i = 0; i < n / 2; i++) {

            answer += a + b;
        }
        if (n % 2 != 0) {
            answer += a;
        }
        System.out.println(answer);

    }
}
