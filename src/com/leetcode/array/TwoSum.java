package com.leetcode.array;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {

        TwoSum a = new TwoSum();
        int[] nums = { 2, 8, 11, 14 };
        int target = 16;
//		int[] result = a.solve_for(nums, target);
        int[] result = a.solve2(nums, target);
        for (int i : result) {
            System.out.print(i + " ");
        }

    }

    // [3,3] , target 6, 중복된 수에 대해서 키가 인덱스가 덮어씌워져서 체크를하지 못함.
    // 또한 담는 배열이 오름차순을 보증하지 않음 보장되지 않을 수 있음
    public int[] solve(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i] , i);
        }

        for(Integer key : map.keySet()) {
            int findNum = target - key;

            if(map.containsKey(findNum)) {
                return new int[]{map.get(key) + 1, map.get(findNum) + 1};
            }
        }

        return new int[0];
    }
    // map에는 key: target - val *즉 찾고자하는 수가 들어있다. val: 이수를 만든 index
    public int[] solve2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++) {

            if(map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i};
            }
            map.put(target - nums[i], i);
        }
        return new int[0];
    }
}
