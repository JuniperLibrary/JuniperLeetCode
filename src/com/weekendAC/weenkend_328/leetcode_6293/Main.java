package com.weekendAC.weenkend_328.leetcode_6293;

import java.util.HashMap;
import java.util.Map;

/**
 * 6293. 统计好子数组的数目
 * 给你一个整数数组 nums 和一个整数 k ，请你返回 nums 中 好 子数组的数目。
 * <p>
 * 一个子数组 arr 如果有 至少 k 对下标 (i, j) 满足 i < j 且 arr[i] == arr[j] ，那么称它是一个 好 子数组。
 * <p>
 * 子数组 是原数组中一段连续 非空 的元素序列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,1,1,1], k = 10
 * // (5*4)/2*1 =10
 * 输出：1
 * 解释：唯一的好子数组是这个数组本身。
 * 示例 2：
 * <p>
 * 输入：nums = [3,1,4,3,2,2,4], k = 2
 * 输出：4
 * 解释：总共有 4 个不同的好子数组：
 * - [3,1,4,3,2,2] 有 2 对。
 * - [3,1,4,3,2,2,4] 有 3 对。
 * - [1,4,3,2,2,4] 有 2 对。
 * - [4,3,2,2,4] 有 2 对。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= nums[i], k <= 109
 */
public class Main {
    public long countGood(int[] nums, int k) {
        long ans = 0;
        int n = nums.length;
        int lo = 0, hi = 0, pairs = 0;
        Map<Integer, Integer> map = new HashMap<>();

        while (hi < n) {
            pairs += map.getOrDefault(nums[hi], 0);
            map.merge(nums[hi++], 1, Integer::sum);
            while (lo < n && pairs - map.get(nums[lo]) + 1 >= k) {
                pairs -= map.get(nums[lo]) - 1;
                map.merge(nums[lo++], -1, Integer::sum);
            }
            if (pairs >= k) ans += lo + 1;
        }
        // 子数组
        // i< j && nums[i]==nums[j] && k 是好的子数组
        return ans;
    }
}
