package com.leetcode.array;

import java.util.Stack;

public class DailyTemperature_stack {
    public static void main(String[] args) {
        int[] nums = { 73, 74, 75, 71, 69, 72, 76, 73 };
//		int[] res = solve_0(nums);
        int[] res = solve_stack(nums);

        System.out.println("====result===");
        for (int i : res) {
            System.out.print(i + " ");
        }
    }

    //1. for 2
    // 시간복잡 O(N) -> O(N2) 최선과 최악

    public static int[] solve_1(int[] tem) {
        // 1.ds
        int len = tem.length;
        int[] res = new int[len];

        //2. for
        for(int i=0; i < len; i++) {
            for(int j=i+1; j < len; j++) {
                if (tem[i] < tem[j]) {
                    res[i] = j - i;
                    break;
                }
                // 어짜피 0으로 초기화 했기 때문에 추가 할 필요가 없음 (1.48ms -> 1.12ms)
            }
        }
        return res;
    }
    public static int[] solve_2(int[] tem) {
        int len = tem.length;
        int[] result = new int[len];
        int max = 0;

        for (int i = 0; i < len; i++) {
            max = i;
            System.out.println("max " + max);
            while (max <= len - 1 && tem[i] >= tem[max]) {
                max++;
            }
            if (max <= len - 1)
                result[i] = max - i;
            else
                result[i] = 0;
        }
        return result;
    }
//    계산기 문제나 뒤에것과 조작이 필요할 때 stack을 많이 사용한다.
//    for문 실행 0 -> len 까지, while문에서는 스택에 있는값과 바로 찾을수도 있
//    습니다.최악의 경우는 인덱스 끝까지 가는 경우도 발생하지만 이경우는 O(n+n)의 값
//    그래서 결론은 O(n)입니다
    public static int[] solve_stack(int[] temper) {
        // 1. ds
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[temper.length];

        // 2. for, while algo
        for (int i = 0; i < temper.length; i++) {
            System.out.println("temper " + temper[i]);
            while (!stack.isEmpty() && temper[stack.peek()] < temper[i]) {
                // 73<74
                int index = stack.pop(); // peek()+remove()
                System.out.println("i " + i + " index " + index);
                result[index] = i - index;
            }
            stack.push(i);// 0
        }
        return result;

    }
}
