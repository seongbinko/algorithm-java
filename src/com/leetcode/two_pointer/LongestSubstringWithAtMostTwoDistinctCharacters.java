package com.leetcode.two_pointer;

import java.util.HashMap;
import java.util.Map;

/**
 * 최대 두개의 고유 문자가 있는 가장 긴 부분 문자열
 * 중복되는 부분에 대한 저장 방식?
 * 접근 방식: map의 size가 3이 되면 기존의 key를 버려준다.
 * 혼자 풀지 못함
 */
public class LongestSubstringWithAtMostTwoDistinctCharacters {
    public static void main(String[] args) {
//        String s = "ccaabbb";
        String s = "eceba";
        System.out.println(solve_map2(s));
    }

    public static int solve_map(String s) {
        int max = 0;

        // 1.ds 공간 복잡도 O(N)
        Map<Character, Integer> map = new HashMap<>();

        int left = 0 , right = 0;


        while(right < s.length()) {
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0)+1);


            right++;

            while (map.size() > 2) {
                char c2 = s.charAt(left);
                left += map.remove(c2); // 문제 e c e b a 일 경우 처음에 e를 직면 했을 때 그 뒤 e까지 다 사라짐
            }

            max = Math.max(max, right - left);
            System.out.println("l: " + left + " r: " + right);
        }

        return max;
    }

    public static int solve_map2(String s) {
        int max = 0;

        // 1.ds 공간 복잡도 O(N)
        Map<Character, Integer> map = new HashMap<>();

        int left = 0 , right = 0, counter = 0;

        // 2. 시간 복잡도 O(2N)
        while(right < s.length()) {
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0)+1);

            if(map.get(c) == 1) { // 새로운 종류 일 때만
                counter ++;
            }
            right++;

            while (counter > 2) {
                char c2 = s.charAt(left);
                map.put(c2, map.get(c2) - 1);
                if(map.get(c2) == 0) {
                    counter --;
                }
                left++;
            }

            max = Math.max(max, right - left);
            System.out.println("l: " + left + " r: " + right);
        }

        return max;
    }
}
