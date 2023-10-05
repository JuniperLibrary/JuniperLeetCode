package com.uin.leetcode_100.Binarysearch.leetcode_1608;

import java.util.Arrays;

/**
 * 1608.特殊数组的特征值
 * 给你一个非负整数数组 nums 。如果存在一个数 x ，使得 nums 中恰好有 x 个元素 大于或者等于 x ，那么就称 nums 是一个 特殊数组 ，而 x 是该数组的 特征值 。
 * 注意： x 不必 是 nums 的中的元素。
 * 如果数组 nums 是一个 特殊数组 ，请返回它的特征值 x 。否则，返回 -1 。可以证明的是，如果 nums 是特殊数组，那么其特征值 x 是 唯一的 。
 * <p>
 * 输入：nums = [3,5]
 * 输出：2
 * 解释：有 2 个元素（3 和 5）大于或等于 2 。
 * 示例 2：
 * <p>
 * 输入：nums = [0,0]
 * 输出：-1
 * 解释：没有满足题目要求的特殊数组，故而也不存在特征值 x 。
 * 如果 x = 0，应该有 0 个元素 >= x，但实际有 2 个。
 * 如果 x = 1，应该有 1 个元素 >= x，但实际有 0 个。
 * 如果 x = 2，应该有 2 个元素 >= x，但实际有 0 个。
 * x 不能取更大的值，因为 nums 中只有两个元素。
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = {3, 5};
        System.out.println(specialArray(nums));
    }

    public static int specialArray(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0, j = n - 1; i < j; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        for (int i = 1; i <= n; i++) {
            if (nums[i - 1] >= i && (i == n || nums[i] < i)) {
                return i;
            }
        }

        return -1;
    }

    /**
     * 暴力
     *
     * @param nums
     * @return int
     * @author wanglufei
     * @date 2022/9/12 11:20 AM
     */
    public int helper(int[] nums) {
        for (int i = 0; i <= nums.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] >= i) {
                    count++;
                }
            }
            if (count == i) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 排序+暴力
     *
     * @param nums
     * @return int
     * @author wanglufei
     * @date 2022/9/12 11:25 AM
     */
    public int helper2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        if (nums[0] >= n) {
            return n;
        }
        for (int i = 1; i < n; i++) {
            if (nums[n - i] >= i && nums[n - 1 - i] < i) {
                return i;
            }
        }
        return -1;
    }
}
