package com.leetcode.graph;

/**
 * 가장 큰 섬의 크기를 구하기
 * 1. Number of island(섬의 개수를 구한다.)
 * 2. Count 변수를 두고 4,2,4,8
 * max = Math.max(max,area);
 */
public class MaxOfIsland {
    public static void main(String[] args) {

        int[][] grid = {
            {1,1,0,1,1},
            {0,1,1,0,0},
            {0,0,0,0,0},
            {1,1,0,1,1},
            {1,0,1,1,1},
            {1,0,1,1,1}
        };
        MaxOfIsland a = new MaxOfIsland();
        System.out.println(a.maxAreaOfIsland(grid));
    }
    int[][] dirs = {
            {-1,0}, // 북
            {1,0}, // 남
            {0,-1}, // 서
            {0,1} // 동
    };
    int m, n;

    public int maxAreaOfIsland(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        m = grid.length; // 행 6
        n = grid[0].length; // 열 5

        int max = 0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 1) {
                    int value = dfs(grid, i, j, 0); // 탐색하는 주변이 0일 때 탈출 // 4, 2, 4, 8 이 나올것임
                    max = Math.max(max, value);
                }
            }
        }
        return max;
    }

    int dfs(int[][] grid, int x, int y, int area) {
        //1 탈출
        if(x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == 0) {
            return area;
        }
        //2 1인 육지가 들어오는 경우
        grid[x][y] = 0;
        area++;
        for(int[] dir: dirs) {
            area = dfs(grid, x + dir[0], y + dir[1], area);
        }
        return area;
    }
}
