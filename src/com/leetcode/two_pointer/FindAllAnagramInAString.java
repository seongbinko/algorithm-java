package com.leetcode.two_pointer;

import java.util.*;

/**
 * 문자열에서 모든 아나그램 찾기
 * 문제설명: 두 개의 문자열이 주어진다. String s, p
 * p의 문자열이 s의 문자열에 특정 인덱스에서부터 모든 아나그램을 찾아서 인덱스를 리턴
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/submissions/
 */
public class FindAllAnagramInAString {

    public static void main(String[] args) {
        String s = "bacdgabcda"; // 0 - 9 length = 10
        String p = "abcd"; // 0 - 3 length = 4

//        String s = "cbaebabacd";
//        String p = "abc";
        System.out.println(solve_map(s,p));
    }

    /** 시간 초과로 실패
     * 1. 주어진 p를 오름차순 정렬한다.
     * 2. p의 길이를 범위로 지정하여 s를 순환하며 아나그램인지 아닌지 판단한다.
     * 3. 판단해야할 s는 우선순위큐에 넣어서 힙정렬이 되게 한다.
     * 4. begin 값이 s의 총길이에서 p의 길이를 뺀 시작점에 다다를 때 까지만 while문을 진행한다.
     */
    public static List<Integer> my_solve(String s, String p) {
        List<Integer> list = new ArrayList<>();

        // p정렬 공간복잡도 O(N)
        char[] chars = p.toCharArray();
        Arrays.sort(chars);
//        String key = String.valueOf(chars);

        int begin = 0;
        int end = p.length(); // 4

        // 공간복잡도 O(s/p)
        Queue<Character> h = new PriorityQueue<>();

        // 시간 복잡도 O(N2)? ...
        while (begin <= s.length() - p.length()) {
            for (int i = begin; i < end; i++) {
                h.offer(s.charAt(i));
            }
            boolean isAnagram = true;
            int j = 0;
            while (!h.isEmpty()) {
                if (h.poll() != chars[j]) {
                    isAnagram = false;
                    break;
                }
                j++;
            }
            if (isAnagram) {
                list.add(begin);
            }
            begin++;
            end++;
            h.clear();
        }
//        while (begin <= s.length() - p.length()) {
//
//            for (int i = begin; i < end; i++) {
//                h.offer(s.charAt(i));
//            }
//
//            StringBuilder sb = new StringBuilder();
//
//            while (!h.isEmpty()) {
//                sb.append(h.poll());
//            }
//            if (key.equals(sb.toString())) {
//                list.add(begin);
//            }
//            begin++;
//            end++;
//        }
        return list;
    }

    /** Map
     * 시간 초과로 실패 map 이용 했지만...
     */
    public static List<Integer> my_solve_map(String s, String p) {
        List<Integer> result = new ArrayList<>();

        for(int i=0; i <= s.length() - p.length(); i++) {

            Map<Character, Integer> map = new HashMap<>();
            for(Character c : p.toCharArray()) {
                map.put(c, map.getOrDefault(c,0) + 1);
            }
            boolean isAnagram = true;
            for(int j = i; j < i + p.length(); j++ ) {
                char key = s.charAt(j);
                if(!map.containsKey(key)) {
                    isAnagram = false;
                    break;
                }
                if(map.get(key) <= 0) {
                    isAnagram = false;
                    break;
                }
                map.put(key, map.get(key)-1);
            }
            if(isAnagram) {
                result.add(i);
            }
        }
        return result;
    }

    /** Map (모르겠음)
     * 해설 (투포인터 전략 사용, map과 while문 이용)
     * 1. abcd가 소스문자열에서 나오는 부분을 검색한다.
     * 2. 나오는 시점부터 모든문자가 있는지 체크한다.
     */
    public static List<Integer> solve_map(String s, String p) {
        List<Integer> result = new LinkedList<>();
        if (p.length() > s.length())
            return result;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int counter = map.size();
        int left = 0, right = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
//			System.out.println("c: " + c);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0)
                    counter--;
            }
            right++;

            while (counter == 0) {
                char c2 = s.charAt(left);
                if (map.containsKey(c2)) {
                    map.put(c2, map.get(c2) + 1);
                    if (map.get(c2) > 0) {
                        counter++;
                        System.out.println("cou " + counter);
                    }
                }
                if (right - left == p.length()) {
                    result.add(left);
                }

                left++;

            }

        }
        return result;
    }


    /** 시간복잡도 O(S*P), 공간복잡도 O(1) 26한정
     * 배열을 이용한 키값 {1,1,1,1,0,0,0,0,0,0,.....} a,b,c,d  a = 97 (아스키 코드 이용)
     * 알파벳 26개 자리표시로 비교...
     * for문을 두번 사용해서 check란 함수로 같은 아나그램인지 아닌지 비교
     */
    public static List<Integer> solve_array(String s, String p) {

        // 1
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) {
            return result;
        }

        int[] pArray = new int[26]; // expect [1,1,1,1,0,0,....]
        for(int i = 0; i < p.length(); i++) {
            pArray[p.charAt(i) - 'a'] += 1; // patternArray ++
        }

        for(int i=0; i < s.length()-p.length()+1; i++) { //0123, 1234, 2345, .... 6789가 되야함
            int[] sArray = new int[26];
            for(int j=0; j < p.length(); j++) {
                sArray[s.charAt(i+j) - 'a'] ++;
            }
            if(check(pArray, sArray)) {
                result.add(i);
            }
        }
        return result;
    }

    private static boolean check(int[] pArr, int[] sArr) {

        for(int i=0; i<pArr.length; i++) {
            if(pArr[i] != sArr[i]) {
                return false;
            }
        }
        return true;
    }

}
