package com.leetcode.sort_searching;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

// https://leetcode.com/problems/meeting-rooms-ii/
// 미팅이 가능한지가 아니라 몇개의 미팅룸이 필요한지 RETURN
// add 와 offer의 시간복잡도는 같고, return 값 유무의 차이
public class MeetingRoom2 {

    public static void main(String[] args) {
        MeetingRoom2 meetingRoom2 = new MeetingRoom2();
        int[][] intervals = { { 5, 10 }, { 16, 20 }, { 0, 30 }};
//		int[][] intervals = { { 7, 10 }, { 2, 4 } };
        System.out.println(meetingRoom2. solve(intervals));
    }

    public int mySolution(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

        Queue<Integer> pq = new PriorityQueue<>(); //

        for(int[] arr : intervals) {
            if(pq.isEmpty()) {
                pq.offer(arr[1]);
            } else {
                if(pq.peek() <= arr[0]) { // 30 > 5
                    pq.poll();
                }
                pq.offer(arr[1]);
            }
        }

        return pq.size();
    }
    public int solve(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        Queue<int[]> pq=new PriorityQueue<>((a,b)->a[1]-b[1]);

        for(int[] arr:intervals){
            if (!pq.isEmpty()) {
                if (pq.peek()[1] <= arr[0]) {
                    pq.poll();
                }
            }
            pq.offer(arr);
        }
        return pq.size();
    }
}
