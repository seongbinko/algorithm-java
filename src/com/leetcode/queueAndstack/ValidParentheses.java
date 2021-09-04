package com.leetcode.queueAndstack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * https://leetcode.com/problems/valid-parentheses/
 */
public class ValidParentheses {
    public static void main(String[] args) {
        String s = "()";
//        String s = "()[]{}";
//        String s = "(]";
//        String s = "([)]";
//        String s =  "{[]}";
//        String s = "([}}])";

        System.out.println(isValid2(s));
    }

    /**
     * 1. 열린괄호, 닽힌 괄호 개수를 이용
     * 2. () 열린괄호 2개 닫힌괄호 2개
     * 3. [] 열린괄호 1개 닫힌괄호 1개
     * 4. count=0을 이용해서 카운트를 하고 0이 아니면 false
     * 순서고려 중요
     */
    public static boolean isValid(String s) {
        boolean isValid = false;

        Stack<Character> stack = new Stack();

        for(int i = 0; i<s.length(); i++) {
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{')
                stack.push(s.charAt(i));
            else if(s.charAt(i) == ')' && !stack.empty() && stack.peek() == '(')
                stack.pop();
            else if(s.charAt(i) == ']' && !stack.empty() && stack.peek() == '[')
                stack.pop();
            else if(s.charAt(i) == '}' && !stack.empty() && stack.peek() == '{')
                stack.pop();
            else
                return false;
        }
        return stack.empty();
    }
    public static boolean isValid2(String str) {
        Stack<Character> stack = new Stack<>();
        for(char c: str.toCharArray()) {
            System.out.println("c: "+c);
            if(c=='(') {
                stack.push(')');
            }else if(c=='[') {
                stack.push(']');
            }else if(c=='{') {
                stack.push('}');
            }else if(stack.isEmpty()|| stack.pop() != c) {
                return false;
            }

        }
        return stack.isEmpty();
    }
    public static boolean isValid_map(String str) {
        Map<Character, Character> map = new HashMap<>();
        map.put('{', '}');
        map.put('(', ')');
        map.put('[', ']');
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            if(map.containsKey(c)) {
                stack.push(c);
            }else if(map.containsValue(c)) {
                if(!stack.isEmpty() && map.get(stack.peek())==c) {
                    stack.pop();
                }else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
