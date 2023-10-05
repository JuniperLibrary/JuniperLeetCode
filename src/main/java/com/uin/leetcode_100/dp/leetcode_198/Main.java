package main.java.com.uin.leetcode_100.dp.leetcode_198;

/**
 * 198. 打家劫舍
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
 * 影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 */
public class Main {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        if (nums.length == 1) {
            return dp[0];
        }

        dp[1] = Math.max(nums[0], nums[1]);
        if (nums.length == 2) {
            return dp[1];
        }
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }

    public int helper(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;

        //状态容器
        int[] R = new int[n];
        int[] NR = new int[n];

        //初始化
        R[0] = nums[0];
        NR[0] = 0;

        //状态转移方程
        for (int i = 1; i < n; i++) {
            R[i] = nums[i] + NR[i - 1];
            NR[i] = Math.max(NR[i - 1], R[i - 1]);
        }
        return Math.max(NR[n - 1], R[n - 1]);
    }
}
