package com.leetcode.graph;

/**
 * https://leetcode.com/problems/number-of-islands/
 * Constraints:
 *  m == grid.length
 *  n == grid[i].length
 *  1 <= m, n <= 300
 * grid[i][j] is '0' or '1'.
 *
 * 시간복잡도 O(M*N)
 * 공간복잡도 O(M*N) in worst case
 * 내부 스택 생성 ? 1인 경우에 dfs함수를 계속 호출하면서 담기기 때문에 스택은 만들지 않음
 * 재귀함수가 곧 스택
 */
public class NumberOfIsland_dfs {

    public static void main(String[] args) {
        char[][] grid = {
                { '1', '1', '0', '0', '0' },
                { '1', '1', '0', '0', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '0', '1', '1' } };

//		char[][] grid = {
//				{ '1', '0' },
//				{ '1', '1'}};

        NumberOfIsland_dfs a = new NumberOfIsland_dfs();
        System.out.println(a.solve(grid));
    }


    /**
     * 1. 방향설정 & 이차원배열 사이즈
     */
    int[][] dirs = {
            { 0, 1 },
            { 0, -1 },
            { 1, 0 },
            { -1, 0 }
    };
    int m, n; //문제 제약 조건 확인
    int dfsCount = 0;

    /**
     * 섬의 수를 구하라
     */
    public int solve(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        m = grid.length; // 행
        n = grid[0].length; // 열
        int count = 0;

        /**
         * 2. 맞는 조건을 찾는 부분
         */
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    System.out.println("======================i " + i + " j " + j);
                    count++; //섬의수를 증가
                    dfs(grid, i, j);
                }
            }
        }
        print(grid);
        return count;
    }

    /**
     * 3. 재귀를 이용한다.(Stack 개념)
     */
    public void dfs(char[][] grid, int i, int j) {
        dfsCount++;
        System.out.println("===i " + i + " j " + j + " dfsCount " + dfsCount);
        print(grid);
        /** 4. 조건체크해서 큐에 넣는 부분
         * 4-1. 마이너스 좌표체크
         * 4-2. m*n 범위 체크
         * 4-3. grid[x][y] 값체크 (문제제시값)
         * 4-4. 위 조건 만족시 queue에 넣고 다시 한칸씩 이동
         */

        // 1.error
//		if(i<0 || j<0 || i >= m || j >= n || grid[i][j]!='1')
//			return;
        if (i >= 0 && j >= 0 && i < m && j < n && grid[i][j] == '1') {

            grid[i][j] = 'X'; //visited

            System.out.println("grid[" + i + "][" + j + "] " + grid[i][j]);
            for (int[] dir : dirs) { // 동서남북 돌린다.
                dfs(grid, i + dir[0], j + dir[1]);
            }
            System.out.println("====end====" + " dfsCount " + dfsCount);
        }

//		dfs(grid, i-1,j);
//		dfs(grid, i+1,j);
//		dfs(grid, i,j-1);
//		dfs(grid, i,j+1);
    }

    public void print(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
//			System.out.print("i "+i);
            for (int j = 0; j < grid[i].length; j++) {
//				System.out.println(grid[i]);
                System.out.print("[" + i + "][" + j + "]" + grid[i][j]);
//				System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }

}
