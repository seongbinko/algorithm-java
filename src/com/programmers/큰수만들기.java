package com.programmers;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 문제 설명
 * 어떤 숫자에서 k개의 수를 제거했을 때 얻을 수 있는 가장 큰 숫자를 구하려 합니다.
 *
 * 예를 들어, 숫자 1924에서 수 두 개를 제거하면 [19, 12, 14, 92, 94, 24] 를 만들 수 있습니다. 이 중 가장 큰 숫자는 94 입니다.
 *
 * 문자열 형식으로 숫자 number와 제거할 수의 개수 k가 solution 함수의 매개변수로 주어집니다. number에서 k 개의 수를 제거했을 때 만들 수 있는 수 중 가장 큰 숫자를 문자열 형태로 return 하도록 solution 함수를 완성하세요.
 *
 * 제한 조건
 * number는 1자리 이상, 1,000,000자리 이하인 숫자입니다.
 * k는 1 이상 number의 자릿수 미만인 자연수입니다.
 * 입출력 예
 * number	k	return
 * "1924"	2	"94"
 * "1231234"	3	"3234"
 * "4177252841"	4	"775841"
 *
 * https://bcp0109.tistory.com/15 조합
 * https://programmers.co.kr/learn/courses/30/lessons/42883
 */
public class 큰수만들기 {
    public static void main(String[] args) {
        큰수만들기 solution = new 큰수만들기();
        System.out.println(solution.solution_greedy_correct("4177252841", 4));
    }

    public String solution_greedy_correct(String number, int k) {
        // 문제 분석
        // 어떤 숫자에서 k개를 제거 했을 때 얻을 수 있는 가장 큰 수
        // 문제 풀이
        // 자료구조 StringBuilder
        // 지정된 범위를 설정해서 그 수 중에 가장 큰 수를 append 한다.

        StringBuilder sb = new StringBuilder();

        int n = number.length() - k; // 구해야 할 숫자 자리수 length = 10 , k = 4
        int idx = 0;
        for (int i = 0; i < n; i++) {
            int max = 0; // max 초기화
            for (int j = idx; j <= i + k; j++) {
                if(max < number.charAt(j) - '0') {
                    max = number.charAt(j) - '0';
                    idx = j + 1;
                }
            }
            sb.append(max);
        }
        return sb.toString();
    }


    /**
     * 완전탐색은 타임아웃이 된다.
     */
    int max = -1;
    public String solution_combination_timeout(String number, int k) {
        int n = number.length();
        int r = n - k;
        boolean[] visited = new boolean[n];
        char[] chars = number.toCharArray();

        func_comb(chars, visited, 0, n, r);

        return String.valueOf(max);
    }

    /**
     * 자리수를 바꾸면 안되는데 자리수까지 변경해서 문제가 되었다.
     */
    public String solution_wrong_heapsort(String number, int k) {
        // 힙소트에 최대힙 기준으로 넣고, 뽑을 때 매개변수 k를 기준만큼 덜 뽑는다.

        StringBuilder sb = new StringBuilder();

        Queue<Integer> heapq = new PriorityQueue<>();
        char[] chars = number.toCharArray();
        for(char ch : chars) {
            heapq.offer(-(ch - '0'));
        }

        int length = chars.length;
        while(length > k) {
            sb.append(-heapq.poll());
            length--;
        }

        return sb.toString();
    }

    void func_comb(char[] arr, boolean[] visited, int start, int n, int r) {
        if (r == 0) {
            max = Math.max(max, Integer.valueOf(combineNumber(arr, visited, n)));
            return;
        }

        for(int i = start; i < n; i++) {
            visited[i] = true;
            func_comb(arr, visited, i+1, n, r-1);
            visited[i] = false;
        }
    }
    // 배열 출력
    private String combineNumber(char[] arr, boolean[] visited, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                sb.append(arr[i]);
            }
        }
        return sb.toString();

    }

}
