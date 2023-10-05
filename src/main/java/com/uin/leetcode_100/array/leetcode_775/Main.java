package main.java.com.uin.leetcode_100.array.leetcode_775;

/**
 * 775. 全局倒置与局部倒置
 * 给你一个长度为 n 的整数数组 nums ，表示由范围 [0, n - 1] 内所有整数组成的一个排列。
 * <p>
 * 全局倒置 的数目等于满足下述条件不同下标对 (i, j) 的数目：
 * <p>
 * 0 <= i < j < n
 * nums[i] > nums[j]
 * 局部倒置 的数目等于满足下述条件的下标 i 的数目：
 * <p>
 * 0 <= i < n - 1
 * nums[i] > nums[i + 1]
 * 当数组 nums 中 全局倒置 的数量等于 局部倒置 的数量时，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,0,2]
 * 输出：true
 * 解释：有 1 个全局倒置，和 1 个局部倒置。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,0]
 * 输出：false
 * 解释：有 2 个全局倒置，和 1 个局部倒置。
 * <p>
 * 提示：
 * <p>
 * n == nums.length
 * 1 <= n <= 5000
 * 0 <= nums[i] < n
 * nums 中的所有整数 互不相同
 * nums 是范围 [0, n - 1] 内所有数字组成的一个排列
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 0, 2};
    }

    public static boolean isIdealPermutation(int[] nums) {
        // 全局倒置
        // 0 <= i < j < n
        // 0 <= i < j < 3
        // nums[i] > nums[j]
        /**
         * 全局倒置
         * 1 > 0
         * 局部倒置
         * 1 > 0
         */
        // 局部倒置
        // 0 <= i < n - 1
        // 0 <= i < 2
        // nums[i] > nums[i + 1]
        for (int i = 0; i < nums.length; i++) {
            if (Math.abs(nums[i] - i) > 1) {
                return false;
            }
        }
        return true;
    }


    public static boolean solution(int[] nums) {
        int n = nums.length, minSuff = nums[n - 1];

        for (int i = n - 3; i >= 0; i--) {
            if (nums[i] > minSuff) {
                return false;
            }
            minSuff = Math.min(minSuff, nums[i + 1]);
        }
        return true;
    }

    /**
     * 前缀的最大值来判断
     *
     * @param nums
     * @return
     */
    public boolean helper(int[] nums) {
        int max = nums[0];
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] < max) {
                return false;
            }
            max = Math.max(max, nums[i-1]);
        }
        return true;
    }
}
