package com.leetcode.two_pointer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 단어 중복없는 가장 긴 문자열
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
//        String s = "abcabcd"; // abcd 4

//        String s = "pwwkea"; // wkea 4
//        String s = "aaaaa"; // a 1
        String s = "pwwkew"; // 0

        System.out.println(solve_map(s));
    }
    // 해결하지 못함// 순서유지를 못함
    public static int solve(String s) {
        Map<Character, Integer> map = new HashMap<>();

        int max = 0, begin = 0, end = 0;

        char[] chars = s.toCharArray();
        for(int i = 0; i < chars.length; i++) {
            if(map.containsKey(chars[i])) {

                end = i - 1;
                max = Math.max(max, end - begin + 1);

                begin = begin + 1;
                continue;
                //map.clear();
            }
//            if(map.isEmpty()) {
//                begin = i;
//            }
            map.put(chars[i], 1);
        }
        max = Math.max(max, map.size());

        return max;
    }
    public static int solve_map(String s) {
        //1. ds
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0, counter = 0, max = 0;

        //2
        while (right < s.length()) {
            char c = s.charAt(right);// p
            map.put(c, map.getOrDefault(c, 0) + 1);
            if(map.get(c) > 1) {
                counter++;
            }
            right++;

            while (counter > 0) { // 중복이 발생한 경우
                char c2 = s.charAt(left);// p
                if(map.get(c2) > 1) {
                    counter--;
                }
                map.put(c2, map.get(c2) - 1);
                left++;
            }
            max = Math.max(max, right - left);
        }
        return max;
    }

}
