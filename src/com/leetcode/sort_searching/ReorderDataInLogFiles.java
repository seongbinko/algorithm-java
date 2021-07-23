package com.leetcode.sort_searching;

import java.util.Arrays;

// https://leetcode.com/problems/reorder-data-in-log-files/submissions/
public class ReorderDataInLogFiles {

    public static void main(String[] args) {
        String[] logs = {"dig1 8 1 5 1",
                        "let1 art can",
                        "dig2 3 6",
                        "let2 own kit dig",
                        "let3 art zero"};

        System.out.println(Arrays.toString(reorderLogFiles(logs)));
    }

    /**
     * 시간복잡도 m(logs의 length) * nlogN(정렬)
     */
    public static String[] reorderLogFiles(String[] logs) {

        Arrays.sort(logs, (s1, s2) -> {
            String [] split1 = s1.split(" ", 3);
            String [] split2 = s2.split(" ", 3);

            boolean isDisit1 = Character.isDigit(split1[1].charAt(0));
            boolean isDisit2 = Character.isDigit(split2[1].charAt(0));

            if(!isDisit1 && !isDisit2) {
                // content 비교 대상이 모두 문자인 경우
                int comp = split1[1].compareTo(split2[1]); // 오름차순 마 -1
                // 뒤에 컨텐츠가 모두 같은 경우
                if (comp == 0) {
                    return split1[0].compareTo(split2[0]);
                } else {
                    return comp;
                }
            } else if (isDisit1 && isDisit2) {
                // content 비교 대상이 모두 숫자
                return 0;
            } else if (isDisit1 && !isDisit2) {
                // 3. 첫번째는 숫자, 두번째는 문자.
                return 1;
            } else {
                // 4. 첫번째는 문자, 두번째는 숫자.
                return -1;
            }
        });

        return logs;
    }
}
