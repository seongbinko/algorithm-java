package com.leetcode.dp;

/**
 * 가장긴 서브시퀀스 증가
 * https://leetcode.com/problems/longest-increasing-subsequence/
 * binary search or dp로 가능한데 여기선 dp로 푼다.
 * dp는 항상 재사용성을 생각해야 한다.
 *
 *1. dp 테이블 생성, 2. 맞는 조건을 찾아내는 부분, 3. 점화식 생성
 *  시간복잡도 O(N2), int[numbs]
 *  공간복잡도 O(n) int[] dp = new int[n]
 */
public class Lis {

    public static void main(String[] args) {
//		int[] nums = { 1, 2, 3, 2, 5, 2, 6, 10, 4, 12};
        int[] nums = { 1, 2, 1, 4, 3, 5 };
        Lis a = new Lis();
        //System.out.println(a.solve(nums));
        System.out.println(a.bottomUp(nums));
    }

    public int solve(int[] nums) {
        if (nums == null | nums.length == 0)
            return 0;
        int n = nums.length, len = 0;
        int[] seq = new int[n];
        seq[len++] = nums[0];

        for (int i = 1; i < n; i++) {
            if (seq[len - 1] < nums[i])
                seq[len++] = nums[i];
            else {
                int posi = findPosi(seq, 0, len - 1, nums[i]);
                System.out.println("posi " + posi);
                seq[posi] = nums[i];
            }
        }
        return len;
    }

    public int findPosi(int[] a, int low, int high, int x) {
        int mid;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (a[mid] == x)
                return mid;
            else if (a[mid] > x)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return low;
    }

    public int bottomUp(int[] nums) {

        if (nums.length == 0)
            return 0;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            if (dp[i] > max)
                max = dp[i];
        }
        return max;
    }
}
