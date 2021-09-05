package com.leetcode.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 *  https://leetcode.com/problems/number-of-islands/
 *  Constraints:
 *  m == grid.length
 *  n == grid[i].length
 *  1 <= m, n <= 300
 *  grid[i][j] is '0' or '1'.
 *
 *  시간복잡도: O(M*N) 행렬이 개수가 다르기 때문
 *  공간복잡도: Space Complexity : O(min(m, n))
 *  대상 : Queue<int[]> q = new LinkedList<>();
 *  이유 : 큐에 좌표값 저장 계산 O(max(m, n)) O(min(m, n)) 중에 하나다
 */
public class NumberOfIsland_bfs {

    public static void main(String[] args) {

        char[][] grid = {{ '1', '1', '0', '0', '0' },
                { '1', '1', '0', '0', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '0', '1', '1' } };

//		char[][] grid = {
//				{ '1', '0' },
//				{ '1', '1'}};
        NumberOfIsland_bfs a = new NumberOfIsland_bfs();
        System.out.println(a.solve(grid));
    }

    int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
    int m, n;

    public int solve(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        m = grid.length;
        n = grid[0].length;
        // 1번 끝

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    bfs(grid, i, j);
                }
            }
        }
        return count;
    }

    public void bfs(char[][] grid, int x, int y) {
        grid[x][y] = 'X'; // visted 대용 1과 0만 있는 Binary기 때문에 가능 아닐땐 true false
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { x, y }); // 0,0

        while (!queue.isEmpty()) {
//			int size = queue.size(); // 사이즈로 돌리는거 불필요함, 밑에 poll()에서 빼서 쓰면됨
            int[] cur = queue.poll();
            // for( int i=0; i<size; i++) {//사이즈로 돌리는거 불필요
            for (int[] dir : dirs) {
                int x1 = cur[0] + dir[0];
                int y1 = cur[1] + dir[1];
                System.out.println("x1 " + x1 + " y1 " + y1);

                // bfs는 and 조건으로 파고드는 것이 낫고 dfs는 아니면 던지는 개념으로 or 조건으로 하는 것 선호
                if (x1 >= 0 && x1 < m && y1 >= 0 && y1 < n && grid[x1][y1] == '1') {
                    grid[x1][y1] = 'X';
                    queue.offer(new int[] { x1, y1 });
                }
//						if(x1<0|| x1>=m || y1<0 || y1>=n || grid[x1][y1]!='1')
//							continue;
//						grid[x1][y1]='X';
//						queue.offer(new int[] {x1, y1});
            }
            // }
        }

    }
}
