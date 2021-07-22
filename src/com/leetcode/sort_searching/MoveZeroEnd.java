package com.leetcode.sort_searching;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/move-zeroes/submissions/
 * 시간 복잡도 O(N)
 * 공간 복잡도 O(1) 별도로 뭐를 만들지 않음
 */
public class MoveZeroEnd {
    public static void main(String args[]) {

        int[] nums = { 0, 3, 2, 0, 8, 5 };
        int index = 0;

        MoveZeroEnd moveZeroEnd = new MoveZeroEnd();
        moveZeroEnd.mySolution3(nums);
    }

    /**
     * {3,2,8,5,0,0}
     */
    public void mySolution(int[] nums) {
        int zeroCount = 0; // 0의 갯수
        int index = 0; // 값을 넣을 위치

        // 1. 0이 아닌 것을 index를 통해 앞으로 몰아 넣는다.
        for(int i=0; i<nums.length; i++) {
            if(nums[i] == 0) {
                zeroCount ++;
                continue;
            }
            if(nums[i] != 0) {
                nums[index++] = nums[i];
                System.out.println(index); // 0, 1, 2, 3, 4
            }
        }
        // 2. 0의 갯수를 파악해놓고 그만큼 뒤에 0을 넣어준다.
        for(int i=1; i <= zeroCount; i++) {
            nums[nums.length - i] = 0;
        }

        System.out.println(Arrays.toString(nums));
    }

    public void mySolution2(int[] nums) {
        int index = 0;
        for(int num : nums) {
            if(num != 0) {
                nums[index++] = num;
            }
        }
//        for(int i=index; i < nums.length; i++) {
//            nums[i] = 0;
//        }
        while(index < nums.length) {
            nums[index] = 0;
            index = index + 1;
        }
        System.out.println(Arrays.toString(nums));
    }

    /**
     * {0,0,3,2,8,5} 로 넣는 법
     */
    public void mySolution3(int[] nums) {
        int len = nums.length;
        int index = len -1; // 5
        for(int i = len-1; i >= 0; i--) {
            if(nums[i] != 0) {
                nums[index] = nums[i];
                index --;
            }
        }
        while(index >= 0) {
            nums[index] = 0;
            index --;
        }
        System.out.println(Arrays.toString(nums));
    }
}
