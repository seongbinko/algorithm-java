package com.leetcode.graph;

// https://leetcode.com/problems/word-search/
// bfs는 and 조건, dfs는 or 조건을 많이 사용함 (조건이 맞지 않으면 던진다)
public class WordSearch {
    public static void main(String[] args) {
        char[][] grid ={
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        String word ="ABCCEED";
        WordSearch a = new WordSearch();
        System.out.println(a.solve(grid, word));
    }
    int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    int m, n ;
    public boolean solve(char[][] grid, String word) {
        if(grid==null || grid.length==0 || grid[0].length==0)
            return false;
        m = grid.length; // 행
        n = grid[0].length; // 열
        boolean[][] visited = new boolean[m][n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(dfs(grid, visited, i, j, 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean dfs(char[][] grid, boolean[][] visited, int x, int y ,int start, String word) {
        //1
// 		print(visited);
        if(start == word.length()) return true;
        if(x<0||x>=m || y<0||y>=n) return false; // x30 m:4
        if(visited[x][y]) return false;
        if(grid[x][y] != word.charAt(start)) return false;
        //2
        visited[x][y] =true;
        for(int[] dir: dirs) {
            int dx = x+dir[0];
            int dy = y+dir[1];
            if(dfs(grid, visited, dx,dy,start+1,word)) {
                return true;
            }
        }
        // dfs를 파고들다가 삑사리가 나면은 지금까지 했던 것들을 모두
        visited[x][y] =false;
        return false;

    }

    private void print(boolean[][] visited) {
        if(visited==null|| visited.length==0)return;

        int m=visited.length,n=visited[0].length;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                System.out.print(visited[i][j]+"\t");
            }
            System.out.println();
        }
    }
}
