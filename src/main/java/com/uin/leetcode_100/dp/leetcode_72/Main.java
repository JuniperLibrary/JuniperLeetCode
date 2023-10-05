package com.uin.leetcode_100.dp.leetcode_72;

import java.util.Arrays;

/**
 * 72.编辑距离
 * 给你两个单词word1 和word2， 请返回将word1转换成word2 所使用的最少操作数 。
 * <p>
 * 你可以对一个单词进行如下三种操作：
 * <p>
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * <p>
 * 输入：word1 = "horse", word2 = "ros"
 * 输出：3
 * 解释：
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 */
public class Main {
    public static void main(String[] args) {

    }

    /**
     * 自底向上的动态规划
     *
     * @param word1
     * @param word2
     * @return int
     * @author wanglufei
     * @date 2022/9/15 4:35 PM
     */
    public static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c1 = word1.charAt(i);
                char c2 = word2.charAt(j);

                if (c1 == c2) {
                    dp[i + 1][j + 1] = dp[i][j];
                } else {
                    dp[i + 1][j + 1] = Math.min(dp[i + 1][j], Math.min(dp[i][j + 1], dp[i][j])) + 1;
                }
            }
        }
        return dp[m][n];
    }

    /**
     * dp
     */
    public static int dp(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        // 第一行
        for (int j = 1; j <= n2; j++) {
            dp[0][j] = dp[0][j - 1] + 1;
        }
        // 第一列
        for (int i = 1; i <= n1; i++) {
            dp[i][0] = dp[i - 1][0] + 1;
        }

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
                }
            }
        }
        return dp[n1][n2];
    }


    /**
     * 自底向下的递归
     *
     * @param word1
     * @param word2
     * @return int
     * @author wanglufei
     * @date 2022/9/15 4:36 PM
     */
    public static int recurse(String word1, String word2) {
        return 0;
    }
}
