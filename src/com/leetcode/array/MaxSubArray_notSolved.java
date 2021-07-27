package com.leetcode.array;

//DP를 이용할 수 있음
public class MaxSubArray_notSolved {

	public static void main(String[] args) {
		int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		System.out.println(solve(nums));

	}

	public static int solve_notSolved(int[] nums) {

		int sum = (int) -1e9; // 1

		for(int i=0; i<nums.length; i++) {

			int max = Math.max(sum + nums[i], nums[i]);

			if(max == nums[i]) {
				sum = nums[i];
			} else if (max > sum) {
				sum = max;
			}
		}
		return sum;
	}

	public static int solve(int[] nums) {
		int curMax = nums[0];
		int allMax = nums[0];

		for(int num : nums) {
			curMax = Math.max(num, num + curMax);
			allMax = Math.max(allMax, curMax);
		}

		return allMax;
	}

}
