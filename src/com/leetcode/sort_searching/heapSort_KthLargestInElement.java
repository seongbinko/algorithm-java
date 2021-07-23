package com.leetcode.sort_searching;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 유선순위 큐 heapSort사용
 * https://leetcode.com/submissions/detail/526507425/
 */
public class heapSort_KthLargestInElement {

    public static void main(String[] args) {
//		int[] nums = { 2, 3, 1, 5, 6, 4 };  // 1,2,3,4,5,6
//		int k = 2;

        int[] nums = { 3,2,3,1,2,4,5,5,6 };
        int k = 4;
        System.out.println(mySolution3(nums, k));
    }

    /**
     * 시간복잡도 O(NlogN)
     * 공간복잡도 1
     */
    public static int mySolution(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public static int mySolution2(int[] nums, int k) {
        Queue<Integer> heapq = new PriorityQueue<>();
        for(int num : nums) {
            heapq.offer(-num);
        }
        while(k > 0) {
            if(k == 1) {
                return -heapq.poll();
            }
            heapq.poll();
            k --;
        }
        return 0;
    }

    public static int mySolution3(int[] nums, int k) {
        Queue<Integer> heapq = new PriorityQueue<>(
                (a,b) -> b - a
        );
        int answer = 0;
        for(int num : nums) {
            heapq.offer(num);
        }
        while (k > 0) {
            answer = heapq.poll();
            k --;
        }
        return answer;
    }
    /**
     * 시간복잡도 O(Nlogk)
     * 대상: int[] numbs, int k
     * 이유: 배열의 개수만큼 N개 * 우선순위큐 사용 logk
     * 공간복잡도: O(k)
     */
    public static int findKthLargest(int[] nums, int k) {
        Queue<Integer> pq = new PriorityQueue<>();

        // { 2, 3, 1, 5, 6, 4 } size = 6, k = 2 return 5
        // 사이즈를 2개만 유지한다.

        for(int i : nums) {
            pq.offer(i);
            if(pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }


    public static void solutionWhenCollection(Integer[] nums, int k) {
//        Collection, reference 타입일 때만 가능
//        Arrays.sort(nums, Collections.reverseOrder());// 내림차순 정렬
//        Collections.sort(nums, Collections.reverseOrder()); // 내림차순 정렬
//        Collections.reverse(numbs); // 뒤집기
//        System.out.println(nums[k-1]);
    }
}
