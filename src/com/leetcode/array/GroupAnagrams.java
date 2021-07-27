package com.leetcode.array;

import java.util.*;

public class GroupAnagrams {

    public static void main(String[] args) {

        String[] list = { "eat", "tea", "tan", "ate", "nat", "bat" };
        System.out.println("re "+groupAnagrams(list));
//		System.out.println(groupAnagrams_ascii(list));
    }
    //1.
    // 시간 복잡도 nkLogK
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);

//            if (map.containsKey(key)) {
//                map.get(key).add(str);
//                continue;
//            }
//
//            List<String> list = new ArrayList<>();
//            list.add(str);
//            map.put(key, list);

            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }

//        for(String key : map.keySet()) {
//            result.add(map.get(key));
//        }
//        result.addAll(map.values());
//        return new ArrayList<>(map.values());
        for(Map.Entry<String, List<String>> entry : map.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }
    //2.
    public static List<List<String>> groupAnagrams_ascii(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> result = new ArrayList<>();

        for(String str: strs) {
            int[] count = new int[26]; // a - z
            for(int k=0; k<str.length(); k++) {
                count[str.charAt(k) - 'a']++;
            }
            String key = Arrays.toString(count);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
        result.addAll(map.values());
        return result;
    }
}
