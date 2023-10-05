package com.uin.leetcode_100.dp.leetcode_509;

/**
 * 509. 斐波那契数
 * 斐波那契数（通常用F(n) 表示）形成的序列称为 斐波那契数列 。该数列由0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 * <p>
 * F(0) = 0，F(1)= 1
 * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 * 给定n ，请计算 F(n) 。
 */
public class Main {
    /**
     * 递归
     *
     * @param n
     * @return int
     * @author wanglufei
     * @date 2022/8/21 8:21 AM
     */
    public int fib(int n) {
        if (n <= 1) return n;
        return fib(n - 1) + fib(n - 2);
    }

    /**
     * dp
     *
     * @param n
     * @return int
     * @author wanglufei
     * @date 2022/8/21 8:22 AM
     */
    public int dpSolve(int n) {
        if (n <= 1) return n;

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
