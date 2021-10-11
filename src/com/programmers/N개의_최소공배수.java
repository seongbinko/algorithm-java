package com.programmers;


/*문제 설명
        두 수의 최소공배수(Least Commontem Multiple)란 입력된 두 수의 배수 중 공통이 되는 가장 작은 숫자를 의미합니다. 예를 들어 2와 7의 최소공배수는 14가 됩니다. 정의를 확장해서, n개의 수의 최소공배수는 n 개의 수들의 배수 중 공통이 되는 가장 작은 숫자가 됩니다. n개의 숫자를 담은 배열 arr이 입력되었을 때 이 수들의 최소공배수를 반환하는 함수, solution을 완성해 주세요.

        제한 사항
        arr은 길이 1이상, 15이하인 배열입니다.
        arr의 원소는 100 이하인 자연수입니다.
        입출력 예
        arr	result
        [2,6,8,14]	168
        [1,2,3]	6
        https://programmers.co.kr/learn/courses/30/lessons/12953
*/

public class N개의_최소공배수 {
    public static void main(String[] args) {
        N개의_최소공배수 a = new N개의_최소공배수();

        int[] arr = {2,6,8,14};


        System.out.println(a.solution(arr)); // 168

    }

    public int solution(int[] arr) {
        int length = arr.length;

        int index = 0;
        int answer = 0;
        while(index < length) {
            int a = 0;
            int b = 0;
            if(index == 0) {
                a = arr[index++];
                b = arr[index++];
            } else {
                a = answer;
                b = arr[index++];
            }
            answer = a > b ? a * b / gcd(a, b) : a * b /gcd(b, a);
        }

        return answer;
    }

    public int gcd(int a, int b) {
        if(a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }

}
