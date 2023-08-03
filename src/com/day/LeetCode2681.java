package com.day;

import java.util.Arrays;

/**
 * @author dingchuan
 */
public class LeetCode2681 {

  public int sumOfPower(int[] nums) {
    // nums[i] 代表英雄的能力值
    // 英雄的能力为=max(nums[i0],nums[i1],...,nums[ik])的平方 * min(nums[i0],nums[i1],...,nums[ik])
    // 请你返回所有可能的 非空 的英雄组的力量之和。

    /**
     * 输入：nums = [2,1,4]
     * 输出：141
     * 解释：
     * 第 1 组：[2] 的力量为 2*2 * 2 = 8 。
     * 第 2 组：[1] 的力量为 1*1 * 1 = 1 。
     * 第 3 组：[4] 的力量为 4*4 * 4 = 64 。
     * 第 4 组：[2,1] 的力量为 2*2 * 1 = 4 。
     * 第 5 组：[2,4] 的力量为 4*4 * 2 = 32 。
     * 第 6 组：[1,4] 的力量为 4*4 * 1 = 16 。
     * 第7 组：[2,1,4] 的力量为 4*4 * 1 = 16 。
     * 所有英雄组的力量之和为 8 + 1 + 64 + 4 + 32 + 16 + 16 = 141 。
     */

    final int mod = ((int) (1e9 + 7));
    Arrays.sort(nums);
    long ans = 0, p = 0;
    for (int i = nums.length - 1; i >= 0; --i) {
      long x = nums[i];
      ans = (ans + (x * x % mod) * x) % mod;
      ans = (ans + x * p % mod) % mod;
      p = (p * 2 + x * x % mod) % mod;
    }
    return (int) ans;
  }
}
