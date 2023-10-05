package main.java.com.uin.didi.didi17.a1;


import java.util.Scanner;

/**
 * 滴滴出行2017秋招笔试真题-编程题汇总--连续最大和
 * 一个数组有 N 个元素，求连续子数组的最大和。 例如：[-1,2,1]，和最大的连续子数组为[2,1]，其和为 3
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = in.nextInt();
        }
        System.out.println(helper(nums));
    }

    /**
     * dp压缩空间
     *
     * @param nums
     * @return int
     * @author wanglufei
     * @date 2022/9/4 3:11 PM
     */
    public static int helper(int[] nums) {
        int max = Integer.MIN_VALUE, maxCur = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            maxCur = Math.max(maxCur + nums[i], nums[i]);
            max = Math.max(maxCur, max);
        }
        return max;
    }

    /**
     * dp
     *
     * @param nums
     * @return int
     * @author wanglufei
     * @date 2022/9/4 3:11 PM
     */
    public static int dp(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 0;
        int max = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }
}
