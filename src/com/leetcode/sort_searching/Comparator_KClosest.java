package com.leetcode.sort_searching;

import java.util.PriorityQueue;
import java.util.Queue;

// https://leetcode.com/problems/k-closest-points-to-origin/
public class Comparator_KClosest {
    public static void main(String[] args) {
        Comparator_KClosest kClosest = new Comparator_KClosest();
        int[][] points = { { 1, 3 }, { -2, 2 } };
        int k = 1;
//		int[][] points = {{3,3},{5,-1},{-2,4}};
//		int k =2;

        int[][] result = kClosest.solve_maxHeap(points, k);
        kClosest.print(result);
    }

    /**
     * 시간복잡도 N개의 데이타 배열(point)의 개수 N 우선순위큐 삽입 logN
     */
    public int[][] solve_minHeap(int[][] points, int k) {
        // 1. ds 거리 순 정렬 a - b 는 오름차순
        Queue<int[]> pq = new PriorityQueue<>(
                (a,b) -> (a[0]*a[0] + a[1]*a[1]) - (b[0]*b[0] + b[1]*b[1])
        );
        int[][] res = new int[k][2]; // k행 2열 return 할 자료구조 공간복잡도 K

        // 2. for, while
        for(int[] p : points) { // N
            pq.offer(p); // log N
        }

        int index = 0;
        while(index < k) {
            res[index] = pq.poll();
            index ++;
        }
        return res;
    }
    /**
     * 시간복잡도 N개의 데이타 배열(point)의 개수 N 우선순위큐 삽입 logK
     * 시간 복잡도가 개선됨
     */
    public int[][] solve_maxHeap(int[][] points, int k) {
        Queue<int[]> pq = new PriorityQueue<>(
                (a,b) -> (b[0]*b[0] + b[1]*b[1]) - ((a[0]*a[0] + a[1]*a[1]))
        );
        int[][] res = new int[k][2];

        for(int[] p : points) {
            pq.offer(p);
            if(pq.size() > k) {
                pq.poll(); // 최대 힙이기 때문에 큰 값들은 다 날라간다. k개 만큼만 남음
            }
        }
        int index = 0;
        while(index < k) {
            res[index] = pq.poll();
            index ++;
        }
        return res;
    }


    public void print(int[][] result) {
        int m = result.length;
        int n = result[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(" [" + i + "][" + j + "] " + result[i][j]);
            }
            System.out.println();
        }
    }
}
