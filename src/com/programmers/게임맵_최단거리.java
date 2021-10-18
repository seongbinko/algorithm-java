package com.programmers;

import java.util.LinkedList;
import java.util.Queue;

public class 게임맵_최단거리 {

    public static void main(String[] args) {
        int[][] maps = {
                {1,0,1,1,1},
                {1,0,1,0,1},
                {1,0,1,1,1},
                {1,1,1,0,1},
                {0,0,0,0,1}
        };
        // 11
        int[][] maps2 = {
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1,0,1,1,1},
                {1,1,1,0,0},
                {0,0,0,0,1}
        }; // -1



        게임맵_최단거리 게임맵최단거리 = new 게임맵_최단거리();
        System.out.println(게임맵최단거리.solve_bfs(maps2));
    }


    private int solve_bfs(int[][] maps) {
        int min = Integer.MAX_VALUE;

        int n = maps.length;
        int m = maps[0].length;

        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};

        int[] start = {0,0};
        int[] dest = {n - 1, m - 1};

        if (start[0] == dest[0] && start[1] == dest[1]) {
            return -1;
        }

        boolean[][] visited = new boolean[n][m];
        visited[start[0]][start[1]] = true; // start point

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{start[0], start[1]});

        int count = 1;
        while (!q.isEmpty()) {
            int[] p = q.poll();// 0, 0
            for (int[] dir : dirs) {
                int x = p[0];
                int y = p[1];

                while (x >= 0 && x < n && y >= 0 && y < m && maps[x][y] == 1) {
                    visited[x][y] = true;
                    count ++;
                    x += dir[0];
                    y += dir[1];
                    System.out.println("x = " + x +", y = " + y);
                }
                x -= dir[0];
                y -= dir[1];

//                if (visited[x][y]) {
//                    continue;
//                }
//                visited[x][y] = true;
//                count++;
                System.out.println("=================");

                if(x == dest[0] && y == dest[1]) {
                    min = Math.min(min, count);
                    count = 1;
                }

                q.offer(new int[]{x, y});
            }
        }
        if(visited[dest[0]][dest[1]]) {
            return min;
        }
        return -1;
    }

}
