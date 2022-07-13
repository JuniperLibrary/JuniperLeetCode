package com.uin.LeetCode_100.array.LeetCode_560;

/**
 * LeetCode 560 和为k的子数组
 *
 * @author wanglufei
 * @date 2022/7/13 1:21 PM
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        int k = 2;
        System.out.println(subArraySum(nums, k));
        //System.out.println(solution(nums, k));
    }

    //该数组中和为 k 的连续子数组的个数
    //1. {1,1}、{1,1} 2

    // 利用前缀和的思想

    /**
     * @param nums 原始数组
     * @param k    和为k
     * @return int
     * @author wanglufei
     * @date 2022/7/13 1:23 PM
     */
    public static int subArraySum(int[] nums, int k) {
        //前缀和数组
        int[] preSum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            //这里需要注意的时，我们的前缀和是peSum[1]开始填充的
            preSum[i + 1] = nums[i] + preSum[i];
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (preSum[j + 1] - preSum[i] == k) {
                    count++;
                }
            }
        }
        return count;
    }

    //暴力解法
    public static int solution(int[] nums, int k) {
        int length = nums.length;
        int count = 0;
        int sum = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                sum += nums[j];
                if (sum == k)
                    count++;
            }
            sum = 0;
        }
        return count;
    }
}
