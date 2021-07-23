package com.leetcode.sort_searching;

import java.util.*;

// int[][] test = new int[0][]; 빈 배열
public class MergeInterval {
    public static void main(String[] args) {
        MergeInterval a = new MergeInterval();
        int[][] intervals = {
                { 1, 3 },
                { 8, 10 },
                { 2, 6 },
                { 15, 18 }
        };
//        int[][] intervals = {
//                {2,3},{2,2}, {3,3},{1,3},{5,7},{2,2},{4,6}
//        };
        int[][] res = a.solve(intervals);
        for (int[] arr : res) {
            System.out.println("result");
            System.out.println(arr[0] + ":" + arr[1]);
        }
    }

    /**
     * 시간복잡도 N(loop) logN(sort)
     */
    public int[][] mySolution(int[][] intervals) {
        // 1.오름차순 정렬
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

        Queue<int[]> q = new PriorityQueue<>( (a,b) -> b[1] - a[1]);
//        가독성 좋게 바꿈
//        for(int[] interval : intervals) {
//            if(q.isEmpty()) {
//                q.offer(interval);
//            } else {
//                if (q.peek()[1] >= interval[0]) { // 겹치는 경우
//                    int[] p = q.poll();
//                    q.offer(new int[]{p[0], p[1] >= interval[1] ? p[1] : interval[1]});
//                } else {
//                    q.offer(interval);
//                }
//            }
//        }
        for(int[] interval : intervals) {
            if (!q.isEmpty() && q.peek()[1] >= interval[0]) { // 겹치는 경우
                int[] p = q.poll();
                q.offer(new int[]{p[0], p[1] >= interval[1] ? p[1] : interval[1]}); // [1,4] [2,3] 의 경우 [1,4]가 되야함 Math.max(,) 이용가능
                continue;
            }
            q.offer(interval);
        }

        int[][] res = new int[q.size()][2];
        int index = q.size()-1;
        while(!q.isEmpty()) {
            res[index--] = q.poll(); // 순서 맞추기 위함
        }

        return res;
    }

    public int[][] solve(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        if(intervals.length == 0 || intervals == null)
            return res.toArray(new int[0][]);

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int start = intervals[0][0];
        int end = intervals[0][1];

        for(int[] i : intervals) {
            if(end >= i[0]  ) {
                end = Math.max(end, i[1]); // 겹치면 1-6으로 start, end 를 만든다
            }
            else {
                res.add(new int[]{start, end}); // 안겹치면 지난 값을 array에 넣고 현재값을 셋팅해준다.
                start = i[0];
                end = i[1];
            }
        }
        res.add(new int[]{start, end});
        return res.toArray(new int[0][]); // 값이 있으면 값이 날라가고 없으면 빈배열이 날라간다.

    }
}
