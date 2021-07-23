package com.leetcode.sort_searching;

import java.util.Arrays;

// https://leetcode.com/problems/meeting-rooms/
public class MeetingRoom {
    public static void main(String[] args) {
        MeetingRoom meetingRoom = new MeetingRoom();
        int[][] intervals = { { 0, 30 }, { 5, 10 }, { 16, 20 } };
//		int[][] intervals = { { 7, 10 }, { 2, 4 } };

        System.out.println(meetingRoom.mySolution(intervals));
    }

    /**
     * 시간복잡도 O(NlogN)
     * - 소팅 사용 O(logN), for문 사용 N
     * 공간복잡도
     * - O(1)
     */
    public boolean mySolution(int[][] intervals) {
        //1. start 시간으로 오름 차순 정리
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

//        int beforeEndTime = -1;
//        for(int[] interval : intervals) {
//            if(beforeEndTime > interval[0]) {
//                return false;
//            }
//            beforeEndTime = interval[1];
//        }

        int endTime = intervals[0][1];
        for(int i=1; i<intervals.length; i++) {
            if(intervals[i][0] < endTime) {
                return false;
            }
            endTime = intervals[i][1];
        }

        //2. for while
        return true;
    }
}
