package com.uin.day;

import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LeetCode2300 {

  /**
   * 2300. 咒语和药水的成功对数
   * <p>
   * 给你两个正整数数组 spells 和 potions ，长度分别为 n 和 m ，其中 spells[i] 表示第 i 个咒语的能量强度，potions[j] 表示第 j
   * 瓶药水的能量强度。
   * <p>
   * 同时给你一个整数 success 。一个咒语和药水的能量强度 相乘 如果 大于等于 success ，那么它们视为一对 成功 的组合。
   * <p>
   * 请你返回一个长度为 n 的整数数组 pairs，其中 pairs[i] 是能跟第 i 个咒语成功组合的 药水 数目。
   * <p>
   * 输入：spells = [5,1,3], potions = [1,2,3,4,5], success = 7
   * <p>
   * 输出：[4,0,3]
   * <p>
   * 解释：
   * <p>
   * - 第 0 个咒语：5 * [1,2,3,4,5] = [5,10,15,20,25] 。总共 4 个成功组合。
   * <p>
   * - 第 1 个咒语：1 * [1,2,3,4,5] = [1,2,3,4,5] 。总共 0 个成功组合。
   * <p>
   * - 第 2 个咒语：3 * [1,2,3,4,5] = [3,6,9,12,15] 。总共 3 个成功组合。
   * <p>
   * 所以返回 [4,0,3] 。
   *
   * @return
   */
  public static int[] successfulPairs(int[] spells, int[] potions, long success) {
    Arrays.sort(potions);
    int n = spells.length;
    int m = potions.length;
    int[] ans = new int[n];
    for (int i = 0; i < n; i++) {
      int left = 0, right = m;
      while (left < right) {
        int mid = (left + right) >> 1;
        if ((long) spells[i] * potions[mid] >= success) {
          right = mid;
        } else {
          left = mid + 1;
        }
      }
      ans[i] = m - left;
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] spells = {5, 1, 3};
    int[] potions = {1, 2, 3, 4, 5};
    long success = 7;
    log.info("咒语和药水的成功对数:{}", successfulPairs(spells, potions, success));
  }
}
