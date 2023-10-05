package main.java.com.uin.litteredbook.a1_too;

/**
 * 面试题 08.11. 硬币
 * 硬币。给定数量不限的硬币，币值为25分、10分、5分和1分，编写代码计算n分有几种表示法。(结果可能会很大，你需要将结果模上1000000007)
 * 输入: n = 5
 * 输出：2
 * 解释: 有两种方式可以凑成总金额:
 * 5=5
 * 5=1+1+1+1+1
 */
public class Main {
    private final int mod = 1000000007;
    private final int[] nums = {1, 5, 10, 25};

    public int waysToChange(int n) {

        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int num : nums) {
            for (int i = num; i <= n; i++) {
                dp[i] = (dp[i] + dp[i - num]) % mod;
            }
        }
        return dp[n];
    }
}
