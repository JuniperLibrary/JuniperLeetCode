package com.uin.leetcode_100;

import java.util.HashSet;
import java.util.Set;

/**
 * 128. 最长连续序列
 * <p>
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * <p>
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * <p>
 * 输入：nums = [100,4,200,1,3,2]
 * <p>
 * 输出：4
 * <p>
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 */
public class LC128 {

  public int longestConsecutive(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    Set<Integer> set = new HashSet<>();
    for (int num : nums) {
      set.add(num);
    }

    int longestStreak = 0;
    for (Integer integer : set) {
      if (!set.contains(integer - 1)) {
        int currentNum = integer;
        int currentStreak = 1;

        while (set.contains(currentNum + 1)) {
          currentNum++;
          currentStreak++;
        }
        longestStreak = Math.max(longestStreak, currentStreak);
      }
    }
    return longestStreak;
  }

  public static void main(String[] args) {
    int[] nums = {100, 4, 200, 1, 3, 2};
    System.out.println(new LC128().longestConsecutive(nums));
  }

}
