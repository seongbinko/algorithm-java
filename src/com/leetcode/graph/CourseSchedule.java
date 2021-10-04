package com.leetcode.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/course-schedule/
 * 위상 정렬 (Topological Sort) (NO CYCLE 0 <-> 1  X)
 *
 * [[1,0], [0,1]] -> cycle outPut false
 * [[1,0], [2,1], [3,2]] -> True
 *
 * 1. 문제를이해 -> 담을 그릇 정하기, 알고리즘 정하기
 */
public class CourseSchedule {

    public static void main(String[] args) {
        int course = 4;
        int[][] nums = {
                {1, 0},
                {2, 1},
                {3, 2}
        };

        int[][] nums2 = {
                {1, 0},
                {0, 1}
        };

//		int[][] nums2 = {
//				 { 1, 2 },
//		         { 3, 1 },
//		         { 2, 3 } };


        CourseSchedule a = new CourseSchedule();
        System.out.println(a.solve(course, nums));
    }

    public boolean solve(int courseNumber, int[][] nums) {
        if (courseNumber <= 0)
            return false;

        Queue<Integer> queue = new LinkedList<>();
        int[] inDegree = new int[courseNumber];

        // 1. inDegree : [1, 1, 1, 0] 끝을 제외하고는 모두 진입차수가 1이어야 한다.
        int numsLength = nums.length;
        for (int i = 0; i < numsLength; i++) {
            inDegree[nums[i][1]] = inDegree[nums[i][1]] + 1; // [1, 1, 1, 0]
        }

        // 2.queue에 0인 값 찾아서 넣기
        int completeLength = inDegree.length;
        for (int i = 0; i < completeLength; i++) {
            if (inDegree[i] == 0)
                queue.offer(i);
        }

        // 3.
        while (!queue.isEmpty()) {
            int zeroVal = queue.poll(); // indegree 배열을 0이 되도록 만들어야 한다.
            for (int i = 0; i < numsLength; i++) {
                System.out.println("=============");
                if (zeroVal == nums[i][0]) {
                    System.out.println("zeroVal " + zeroVal + " i " + i);
                    inDegree[nums[i][1]]--;
                    if (inDegree[nums[i][1]] == 0)
                        queue.offer(nums[i][1]);
                }
            }
        }

        /*
         *  4. 3번에서 completed에 값을 0으로 다 만들어야
         *  완성completed[nums[i][1]]--
         */

        for (int i = 0; i < completeLength; i++) {
            if (inDegree[i] != 0)
                return false;
        }
        return true;
    }
}
