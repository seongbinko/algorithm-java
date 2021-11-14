package com.programmers;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/1844?language=java
 * 방문 처리를 해버리면 다른 루트에서 접근할 때 도착하지를 못한다. bfs일 경우 최단 거리로 갈 수 있기 때문에 방문처리를 false로 바꿀 일이 필요 없다.
 */
public class 게임맵_최단거리 {

    public static void main(String[] args) {
        int[][] maps = {
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 1},
                {0, 0, 0, 0, 1}
        }; // 11
        int[][] maps2 = {
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 0},
                {0, 0, 0, 0, 1}
        }; // -1

        게임맵_최단거리 게임맵최단거리 = new 게임맵_최단거리();
        System.out.println(게임맵최단거리.solve_bfs(maps2));
    }

    int[][] dirs = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
    };

    int m, n;
    boolean[][] visit;

    private int solve_bfs(int[][] maps) {
        // 1. 방향 설정 및 2차원 배열 사이즈
        if (maps == null || maps.length < 1 || maps[0].length < 1) {
            return -1;
        }
        if (maps.length == 1 && maps[0].length == 1) {
            return -1;
        }
        m = maps.length; // maps[m-1][n-1]이 최종 도착해야 할 좌표
        n = maps[0].length;

        visit = new boolean[m][n];

        return bfs(maps, 0 , 0); // 시작점이 정해져 있지 않으니까?
    }

    private int bfs(int[][] maps, int x, int y) {

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y, 1));
        visit[x][y] = true; // 방문 처리

        while (!q.isEmpty()) {
            Node node = q.poll();
            if (node.x == m - 1 && node.y == n - 1) {
                return node.cost;
            }
            for (int[] dir : dirs) {
                int vx = node.x + dir[0]; // vx
                int vy = node.y + dir[1]; // vy

                if (vx >= 0 && vx < m && vy >= 0 && vy < n && maps[vx][vy] == 1 && !visit[vx][vy]) {
                    visit[vx][vy] = true;
                    q.offer(new Node(vx, vy, node.cost + 1));
                }
            }
        }
        return -1;
    }

    private class Node {
        int x;
        int y;
        int cost;

        private Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
}
