package com.weekendAC.weenkend_332.leetcode_6355;

import java.util.Arrays;

public class Main {

  public static void main(String[] args) {
    System.out.println(countFairPairs(new int[]{0, 1, 7, 4, 4, 5}, 3, 6));
  }

  public static long countFairPairs(int[] nums, int lower, int upper) {
    int n = nums.length;
    /**
     * 0 <= i < j < n，且
     * lower <= nums[i] + nums[j] <= upper
     */
    int i = 0, j = 1, ans = 0;
    while (i < j && i < n && j < n) {
      if (lower <= nums[i] + nums[j] && nums[i] + nums[j] <= upper) {
        ++ans;
      }
      j++;
      if (j >= n) {
        i++;
        j = i + 1;
      }
      if (i == j || i > j || i > n || j > n) {
        break;
      }
    }
    return ans;
  }

  public long solution(int[] nums, int lower, int upper) {
    Arrays.sort(nums);
    long count = 0;
    for (int i = 0, j = nums.length - 1, k = nums.length - 1; i < nums.length; i++) {
      for (; j >= 0 && nums[i] + nums[j] >= lower; j--) {
      }
      for (; k >= 0 && nums[i] + nums[k] > upper; k--) {
      }
      count += k - j - (i > j  && i <= k ? 1 : 0);
    }
    return count / 2;
  }
}
