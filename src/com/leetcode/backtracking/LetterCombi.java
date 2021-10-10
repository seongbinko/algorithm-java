package com.leetcode.backtracking;

import java.util.*;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 * 이중 포문이 빠르다
 */
public class LetterCombi {
    public static void main(String[] args) {
        LetterCombi a = new LetterCombi();
        a.solve("23");
    }

    public List<String> solve(String digits) {
        String digitletter[] = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        List<String> result = new ArrayList<String>();

        if (digits.length() == 0)
            return result;

        result.add("");
        for (int i = 0; i < digits.length(); i++)
            result = combine(digitletter[digits.charAt(i) - '0'], result);

        return result;
    }

    public List<String> combine(String digit, List<String> firstList) {
        List<String> result = new ArrayList<String>();

        for (int i = 0; i < digit.length(); i++)
            for (String firstStr : firstList)
                result.add(firstStr + digit.charAt(i));

        return result;
    }
}
