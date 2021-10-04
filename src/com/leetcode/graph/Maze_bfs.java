package com.leetcode.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 공은 한 번 진행한 방향에서 멈출 수가 없다. 벽에 부딛칠 때만 가능하다.
 * pdf 문제 풀이 잘 확인
 *
 * 문제 분석
 * 1. Queue에서 poll
 * 2. 4방향으로 체크 시작
 * 3. 공식 조건체크 부분 수행
 * 4. (3,4)까지 도착한 후 에러체크 한다. While문에서 올린 좌표를 -로 원상복귀
 *     visited[x][y] == true인지 체크 후  방문한적이 없으면 true 입력
 * 5. queue.offer(2,4)
 *
 * 시간 복잡도 O(M*N)
 * 대상: int[][] grid
 * 이유: m은 rows, n은 cloumns
 *
 * 공간복잡도
 * O(M*N)
 * 대상 new boolean[m][n]
 */
public class Maze_bfs {
    public static void main(String[] args) {
        int[][] maze= {
                {0,0,1,0,0},
                {0,0,0,0,0},
                {0,0,0,1,0},
                {1,1,0,1,1},
                {0,0,0,0,0}
        };
        int[] start= {0,4};
        int[] dest = {4,4};
//		int[] dest = {3,2};
        Maze_bfs a= new Maze_bfs();
        System.out.println(a.hasPath(maze, start,dest ));
    }

    int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    int m ,n;

    public boolean hasPath(int[][] maze, int[] start, int[] dest) {

        m = maze.length;//5
        n = maze[0].length;//5

        if(start[0]==dest[0] && start[1]==dest[1]) return true;

        boolean[][] visited = new boolean[m][n];
        visited[start[0]][start[1]]= true; // start point

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {start[0], start[1]});

        while(!queue.isEmpty()) {
            int[] p = queue.poll(); // 0, 4
            for(int[] dir : dirs) {
                int x = p[0];
                int y = p[1];
                while(x>=0 && x<m && y>=0 && y<n && maze[x][y]==0) {
                    x+=dir[0];
                    y+=dir[1];
                    System.out.println("x: "+x+" y: "+y);
                }
                //벽 부딛히고 바로 전지점 3,4 => 2,4
                x-=dir[0];
                y-=dir[1];
                if(visited[x][y]) continue;
                visited[x][y] =true;
                System.out.println("=====");
                print(visited);
                if(x==dest[0] && y==dest[1]) return true;

                queue.offer(new int[] {x, y});
            }
        }
        return false;
    }


    private void print(boolean[][] visited) {
        if(visited==null|| visited.length==0)return;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                System.out.print(visited[i][j]+"\t");
            }
            System.out.println();
        }
    }
}
