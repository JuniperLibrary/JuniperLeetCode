package com.uin.LeetCode_100.array.LeetCode_64;

//LeetCode 64 最小路径和
public class Main {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        //初始化 row
        for (int j = 1; j < n; j++) {
            grid[0][j] = grid[0][j] + grid[0][j - 1];
        }
        //初始化 col
        for (int i = 1; i < m; i++) {
            grid[i][0] = grid[i][0] + grid[i - 1][0];//子问题
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] = grid[i][j] + Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        return grid[m - 1][n - 1];
    }
}
