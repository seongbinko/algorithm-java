package com.leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {
    /**
     * 시간 복잡도: O(N) int[] 배열을 반복문을 돌림
     * 공간 복잡도: O(N) N개를 담을 List를 선언
     */
    public static void main(String[] args) {

        int[] nums = {2,3,5,50,75};
        int lower=0, upper=99;
        System.out.println(solve(nums, lower, upper));
//		[0->1, 4, 6->49, 51->74, 76->99]

    }
    public static List<String> solve(int[] nums, int lower, int upper) {
        // 1
        List<String> result = new ArrayList<>();

        for(int i=0; i<nums.length; i++) {
            String s = null;
            // 처음
            if(i == 0) {
                s = makeRange(lower, nums[i] - 1);
            }
            // 끝
            else if(i == nums.length-1) {
                s = makeRange(nums[i] + 1, upper);
            }
            // 그 외
            else {
                s = makeRange(nums[i] + 1, nums[i+1] - 1);
            }

            result.add(s);

        }
        return result;
    }

    public static List<String> solve2(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();

        // 처음
        if(lower < nums[0]) {
            result.add(makeRange(lower, nums[0] -1));
        }
        // 중간
        for(int i= 1; i<nums.length-1; i++) {
            if(nums[i] != nums[i+1] && nums[i] + 1 < nums[i+1])
                result.add(makeRange(nums[i] + 1, nums[i+1] - 1));
        }

        // 끝
        if( nums[nums.length-1] < upper) {
            result.add(makeRange(nums[nums.length-1] + 1, upper));
        }
        return result;
    }


    public static String makeRange(int low, int high) {
        return low == high ? String.valueOf(low) : low + "->" + high;
    }
}
