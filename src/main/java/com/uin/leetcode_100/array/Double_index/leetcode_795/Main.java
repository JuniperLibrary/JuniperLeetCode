package com.uin.leetcode_100.array.Double_index.leetcode_795;

/**
 * 795. 区间子数组个数
 * 给你一个整数数组 nums 和两个整数：left 及 right 。找出 nums 中连续、非空且其中最大元素在范围 [left, right] 内的子数组，并返回满足条件的子数组的个数。
 * 生成的测试用例保证结果符合 32-bit 整数范围。
 * 示例 1：
 * <p>
 * 输入：nums = [2,1,4,3], left = 2, right = 3
 * 输出：3
 * 解释：满足条件的三个子数组：[2], [2, 1], [3]
 * 示例 2：
 * <p>
 * 输入：nums = [2,9,2,5,6], left = 2, right = 8
 * 输出：7
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 0 <= nums[i] <= 109
 * 0 <= left <= right <= 109
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = {2, 1, 4, 3};
        int left = 2, right = 3;
        System.out.println(numSubarrayBoundedMax(nums,left,right));
    }

    public static int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int n = nums.length, ans = 0, i0 = -1, i1 = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] > right) {
                i0 = i;
            }
            if (nums[i] >= left) {
                i1 = i;
            }
            ans += i1 - i0;
        }
        return ans;
    }
}
