package com.uin.leetcode_100.array.leetcode_915;

/**
 * LeetCode 915.分割数组
 * 给定一个数组nums，将其划分为两个连续子数组left和right，使得：
 * - left中的每个元素都小于或等于right中的每个元素
 * - left 和 right都是非空的
 * - left的长度要尽肯能的小
 * 在完成这样分组后返回left的长度。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [5,0,3,8,6]
 * 输出：3
 * 解释：left = [5,0,3]，right = [8,6]
 * 示例 2：
 * <p>
 * 输入：nums = [1,1,1,0,6,12]
 * 输出：4
 * 解释：left = [1,1,1,0]，right = [6,12]
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = {5, 0, 3, 8, 6};
        System.out.println(partitionDisjoint(nums));
    }

    public static int partitionDisjoint(int[] nums) {
        // 5 0 3 8 6
        // 3
        int n = nums.length;
        int leftMax = nums[0], leftPos = 0, curMax = nums[0];
        for (int i = 1; i < n - 1; i++) {
            curMax = Math.max(curMax, nums[i]);
            if (nums[i] < leftMax) {
                leftMax = curMax;
                leftPos = i;
            }
        }
        return leftPos + 1;
    }
}
