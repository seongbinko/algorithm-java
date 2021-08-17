package com.leetcode.array;

public class TrappingRainWater {

    /**
     * 빗물 담기
     * 낮은 부분과 높은 부분에서 낮은 부분의 높이가 물이 차는 높이이며 물이 차는 곳이 높이가 있는 경우 그만큼 빼준다.
     */
    public static void main(String[] args) {
        int[] nums = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        System.out.println(trap(nums));
    }

    /**
     * left와 rigth, height를 알면 물이 차는 높이를 구할 수 있다.
     * 시간 복잡도 o(n): height 배열의 크기 n개 for문 실행
     * 공간 복잡도
     */
    public static int trap(int[] height) {
        int result = 0;

        if(height == null || height.length <= 2) {
            return 0;
        }

        int len = height.length; // 12
        int[] left = new int[len];
        int[] right = new int[len];

        int max = height[0];
        left[0] = height[0];

        //1. leftMax[]
        for(int i=1; i<len; i++) {
            if(height[i] > max) {
                max = height[i];
                left[i] = height[i];
            } else {
                left[i] = max;
            }
        }

        //2. rightMax[]
        max = height[len -1];
        right[len-1] = height[len -1];
        for(int i=len-2; i >= 0; i--) {
            if (height[i] > max) {
                max = height[i];
                right[i] = height[i];
            } else {
                right[i] = max;
            }
        }
        //3. Math.min - height
        for(int i=0; i<len; i++) {
            result += Math.min(left[i], right[i]) - height[i];
        }

        return result;
    }

    public static int solve2(int[] height) {
        int result = 0;
        int len = height.length;

        for(int i=1; i<len-1; i++) {
            int maxLeft = 0, maxRight = 0;

            for(int j = i; j >=0; j--) {
                maxLeft = Math.max(maxLeft, height[j]);
            }
            for(int j = i; j < len; j++) {
                maxRight = Math.max(maxRight, height[j]);
            }
            result += Math.min(maxLeft, maxRight) - height[i];
        }

        return result;
    }
}
