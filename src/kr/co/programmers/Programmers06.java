package kr.co.programmers;

import java.util.*;
/*
문제 설명
        array의 각 element 중 divisor로 나누어 떨어지는 값을 오름차순으로 정렬한 배열을 반환하는 함수, solution을 작성해주세요.
        divisor로 나누어 떨어지는 element가 하나도 없다면 배열에 -1을 담아 반환하세요.

제한사항
        arr은 자연수를 담은 배열입니다.
        정수 i, j에 대해 i ≠ j 이면 arr[i] ≠ arr[j] 입니다.
        divisor는 자연수입니다.
        array는 길이 1 이상인 배열입니다.
        arr	            divisor	    return
        [5, 9, 7, 10]	5	        [5, 10]
        [2, 36, 1, 3]	1	[1, 2, 3, 36]
 */
public class Programmers06 {
    public static void main(String[] args) {
        int[] arr = {2, 36, 1, 3};
        int divisor = 1;
        System.out.println(Arrays.toString(solution(arr, divisor)));
    }
    public static int[] solution(int[] arr, int divisor) {
        int[] answer = {};
        int length = arr.length;
        List<Integer> list = new ArrayList();

        for(int i=0; i<arr.length; i++) {
            if(arr[i]%divisor == 0) {
                list.add(arr[i]);
                length ++;
            } else {
                length--;
                if(length == 0) {
                    answer = new int[length+1];
                    answer[0] = -1;
                }
            }
        }
        Collections.sort(list);
        if(length != 0) {
            answer = new int[list.size()];
            for(int i=0; i<answer.length; i++) {
                answer[i] = list.get(i).intValue();
            }
        }

        return answer;
    }
}
