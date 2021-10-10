package com.leetcode.backtracking;

import java.util.*;

/**
 * https://leetcode.com/problems/generate-parentheses/
 *
 * 1. dfs문제, 깊게 파고들어가면서 모든 경우의 수를 다 찾아야 한다.
 * 3,3 0,0될때까지 각각을 다파고들어서 확인한다.
 */
public class GenerateParentheses {

    public static void main(String[] args) {
        GenerateParentheses a = new GenerateParentheses();
//		System.out.println(a.generateParenthesis_backTrac(3));
        System.out.println(a.generateParenthesis_dfs(3));
    }

    int count =0;
    public List<String> generateParenthesis_dfs(int n) {
        List<String> res = new ArrayList<>();
        dfs(res, "", n, n,"");
        return res;
    }

    private void dfs(List<String> list, String str, int left, int right, String str1) { // str1은 테스트용 참조값
        count++;
        System.out.println("str\t"+str+"\t left: "+left+" right: "+right+" count: "+count+" str1: "+str1);

        if (left < 0 || left > right) {
            return;
        }
//	        System.out.println("str: "+str);
        System.out.println("=str\t"+str+"\t left: "+left+" right: "+right+" count: "+count);
        if (left == 0 && right == 0) {
            list.add(str);
            return;
        }
        dfs(list, str + '(', left - 1, right, str1+"+");
        dfs(list, str + ')', left, right - 1, str1+"-");
    }
}
