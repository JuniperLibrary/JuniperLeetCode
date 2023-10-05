package com.uin.weekendAC.weenkend_323.leetcode_6258;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 6258. 数组中最长的方波
 * 给你一个整数数组 nums 。如果 nums 的子序列满足下述条件，则认为该子序列是一个 方波 ：
 * 子序列的长度至少为 2 ，并且
 * 将子序列从小到大排序 之后 ，除第一个元素外，每个元素都是前一个元素的 平方 。
 * 返回 nums 中 最长方波 的长度，如果不存在 方波 则返回 -1 。
 * 子序列 也是一个数组，可以由另一个数组删除一些或不删除元素且不改变剩余元素的顺序得到。
 * 示例 1 ：
 * <p>
 * 输入：nums = [4,3,6,16,8,2]
 * 输出：3
 * 解释：选出子序列 [4,16,2] 。排序后，得到 [2,4,16] 。
 * - 4 = 2 * 2.
 * - 16 = 4 * 4.
 * 因此，[4,16,2] 是一个方波.
 * 可以证明长度为 4 的子序列都不是方波。
 * 示例 2 ：
 * <p>
 * 输入：nums = [2,3,5,6,7]
 * 输出：-1
 * 解释：nums 不存在方波，所以返回 -1 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 105
 * 2 <= nums[i] <= 105
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = {4, 3, 6, 16, 8, 2};
        System.out.println(longestSquareStreak(nums));
    }

    public static int longestSquareStreak(int[] nums) {
        // 子序列 子序列的长度至少为2
        // 子序列排序后 ，判断是不是方波
        Arrays.sort(nums);
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int max = -1;
        int value = 100000;

        for (int i = 2; i < value; i++) {
            int cur = i;
            int res = 0;
            while (cur < value) {
                if (!set.contains(cur)) {
                    break;
                }
                res++;
                cur *= cur;
            }
            max = Math.max(max, res);
        }
        return max >= 2 ? max : -1;
    }

    public static int helper(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] * nums[i] > nums[n - 1]) {
                break;
            }
            int idx = i, count = 0;
            while (idx >= 0) {
                idx = Arrays.binarySearch(nums, nums[idx] * nums[idx]);
                if (idx >= 0) {
                    ++count;
                }
            }
            ans = Math.max(ans, count + 1);
        }
        return ans > 1 ? ans : -1;
    }
}
