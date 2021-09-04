package com.leetcode.queueAndstack;

import java.util.Stack;

/**
 * https://leetcode.com/problems/baseball-game/
 */
public class BaseballGame {
    public static void main(String[] args) {
        String[] input = {"5", "-2", "4", "C", "D", "9", "+", "+"};

        System.out.println(mySolve2(input));
    }

    /**
     * 1. 수면 Stack에 쌓고 sum을 증감한다.
     * 2. C면 peek remove , sum 증감
     * 3. D면 peek * 2 쌓고, sum 증감
     * 4. + 면 꼭대기 2개 더하기 st 쌓고 sum 증감
     *
     *
     * 제약 조건을 확인 못하였기 때문에 isEmpty를 남발 calPoints 확인
     */
    public static int mySolve(String[] arr) {
        int sum = 0;

        // 1. ds
        Stack<String> st = new Stack<>();

        // 2.
        for (String s : arr) {

            System.out.println("sum: " + sum);

            switch (s) {
                case "C":
                    if(!st.isEmpty()) {
                        sum -= Integer.valueOf(st.pop());
                    }
                    break;
                case "D":
                    if(!st.isEmpty()) {
                        int temp = Integer.valueOf(st.peek()) * 2;
                        st.push(String.valueOf(temp));
                        sum += temp;
                    }
                    break;
                case "+":
                    int count = 2;
                    String first = null;
                    String second;
                    int tempSum = 0;
                    while(!st.isEmpty() && count > 0) {
                        if(count == 2) {
                            first = st.pop(); // 9
                            tempSum += Integer.valueOf(first);
                        }
                        if(count == 1){
                            second = st.peek();
                            tempSum += Integer.valueOf(second);

                            st.push(first);
                        }
                        count--;
                    }
                    st.push(String.valueOf(tempSum));
                    sum += tempSum;

                    break;
                default:
                    st.push(s);
                    sum += Integer.valueOf(s);
            }
        }
        return sum;
    }
    public static int mySolve2(String[] arr) {
        int sum = 0;

        // 1. ds
        Stack<Integer> st = new Stack<>();

        // 2.
        for (String s : arr) {

            switch (s) {
                case "C":
                    if(!st.isEmpty()) {
                        st.pop();
                    }
                    break;
                case "D":
                    if(!st.isEmpty()) {
                        st.push(st.peek() * 2);
                    }
                    break;
                case "+":
                    int first = 0;
                    int tempSum = 0;

                    int count = 2;
                    while(!st.isEmpty() && count > 0) {
                        if(count == 2) {
                            first = st.pop(); // 9
                            tempSum += first;
                        }
                        if(count == 1){
                            tempSum += st.peek();
                        }
                        count--;
                    }
                    st.push(first);
                    st.push(tempSum);
                    break;
                default:
                    st.push(Integer.valueOf(s));
            }
        }
        while(!st.isEmpty()) {
            sum += st.pop();
        }
        return sum;
    }
    public static int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        for (String op : ops) {
            switch (op) {
                case "+":
                    int x = stack.pop();
                    int y = stack.pop();
                    stack.push(y);
                    stack.push(x);
                    stack.push(x + y);
                    break;
                case "D":
                    stack.push(stack.peek() * 2);
                    break;
                case "C":
                    stack.pop();
                    break;
                default:
                    stack.push(Integer.valueOf(op));
            }
        }

        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }
}
