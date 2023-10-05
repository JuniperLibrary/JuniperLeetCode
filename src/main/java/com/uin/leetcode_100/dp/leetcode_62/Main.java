package main.java.com.uin.leetcode_100.dp.leetcode_62;

/**
 * 62. 不同路径
 * 一个机器人位于一个 m x n网格的左上角 （起始点在下图中标记为 “Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * <p>
 * 问总共有多少条不同的路径？
 */
public class Main {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[m];
        //初始化第一列为1
        for (int i = 0; i < m; i++) {
            dp[i] = 1;
        }

        for (int j = 1; j < n; j++) {
            for (int i = 1; i < m; i++) {
                dp[i] = dp[i] + dp[i - 1];
            }
        }
        return dp[m - 1];
    }
}
