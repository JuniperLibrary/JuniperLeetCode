package main.java.com.uin.leetcode_100.array.leetcode_200;

/**
 * @author wanglufei
 */
public class Main {
    private int m;
    private int n;

    public int numsIslands(char[][] grid) {
        m = grid.length;
        if (m == 0) {
            return 0;
        }
        n = grid[0].length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    private void dfs(char[][] nums, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || nums[i][j] != '1') {
            return;
        }
        nums[i][j]='0';
        dfs(nums, i+1, j);
        dfs(nums, i-1, j);
        dfs(nums, i, j+1);
        dfs(nums, i, j-1);

    }
}
