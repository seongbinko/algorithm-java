package com.programmers;

import java.util.Arrays;
import java.util.Comparator;

public class 문자열_내마음대로_정렬하기 {

    public static void main(String[] args) {
        String[] strings = {"abce", "abcd", "cdx"};
        int n = 2;

        System.out.println(Arrays.toString(solution(strings,n)));
    }

    public static String[] solution(String[] strings, int n) {
        // Comparator compare라는 함수를 오버라이딩 한것
        Arrays.sort(strings, (s1, s2) -> {
            int comp = s1.charAt(n) - s2.charAt(n);

            if(comp == 0) {
                return s1.compareTo(s2);
            }
            return comp;
        });
        return strings;
    }

    public static String[] solution2(String[] strings, int n) {
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                int comp = s1.charAt(n) - s2.charAt(n);

                if(comp == 0) {
                    return s1.compareTo(s2);
                }
                return comp;
            }
        });
        return strings;
    }
}
