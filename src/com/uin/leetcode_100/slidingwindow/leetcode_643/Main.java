package com.uin.leetcode_100.slidingwindow.leetcode_643;

/**
 * 643. 子数组最大平均数 I
 * 给你一个由 n 个元素组成的整数数组 nums 和一个整数 k 。
 * 请你找出平均数最大且 长度为 k 的连续子数组，并输出该最大平均数。
 * 任何误差小于 10-5 的答案都将被视为正确答案。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,12,-5,-6,50,3], k = 4
 * 输出：12.75
 * 解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
 * 示例 2：
 * <p>
 * 输入：nums = [5], k = 1
 * 输出：5.00000
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == nums.length
 * 1 <= k <= n <= 105
 * -104 <= nums[i] <= 104
 */
public class Main {
    public static void main(String[] args) {
        //int[] nums = {1, 12, -5, -6, 50, 3};

        int[] nums = {5};
        int k = 1;
        System.out.println(findMaxAverage(nums, k));
    }

    // 平均数最大 且长度为k的数组
    public static double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        if (n == 1) {
            return nums[0] * 1.0;
        }
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int maxSum = sum;
        for (int i = k; i < n; i++) {
            sum = sum - nums[i - k] + nums[i];
            maxSum = Math.max(sum, maxSum);
        }
        return 1.0 * maxSum / k;
    }
}
