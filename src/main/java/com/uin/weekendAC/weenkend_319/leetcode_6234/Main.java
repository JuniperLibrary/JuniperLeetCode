package com.uin.weekendAC.weenkend_319.leetcode_6234;

import java.math.BigInteger;

/**
 * 6234. 最小公倍数为 K 的子数组数目
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 nums 的 子数组 中满足 元素最小公倍数为 k 的子数组数目。
 * <p>
 * 子数组 是数组中一个连续非空的元素序列。
 * <p>
 * 数组的最小公倍数 是可被所有数组元素整除的最小正整数。
 * <p>
 * <p>
 * <p>
 * 示例 1 ：
 * <p>
 * 输入：nums = [3,6,2,7,1], k = 6
 * 输出：4
 * 解释：以 6 为最小公倍数的子数组是：
 * - [3,6,2,7,1]
 * - [3,6,2,7,1]
 * - [3,6,2,7,1]
 * - [3,6,2,7,1]
 * 示例 2 ：
 * <p>
 * 输入：nums = [3], k = 2
 * 输出：0
 * 解释：不存在以 2 为最小公倍数的子数组。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 1000
 * 1 <= nums[i], k <= 1000
 */
public class Main {
    public int subarrayLCM(int[] nums, int k) {
        int n = nums.length, count = 0;
        // 怎么找数组中的子数组
        for (int i = 0; i < n; i++) {
            int lcm = 1;
            for (int j = i; j < n; j++) {
                lcm = lcm / gcd(lcm, nums[j] * nums[j]);
                if (lcm == k) {
                    count++;
                }
            }
        }
        return count;
    }

    private int gcd(int lcm, int i) {
        return i == 0 ? lcm : gcd(i, lcm % i);
    }


    public int helper(int[] nums, int k) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            // 初始化为 1，任何数与 1 的 lcm 都是它本身
            BigInteger lcm = BigInteger.ONE;
            for (int j = i; j < nums.length; j++) {
                // lcm(a, b) = a * b / gcd(a, b)
                lcm = lcm.multiply(BigInteger.valueOf(nums[j])).divide(lcm.gcd(BigInteger.valueOf(nums[j])));
                // 担心溢出就用 lcm.doubleValue()
                if (lcm.intValue() == k) res++;
            }
        }
        return res;
    }
}
