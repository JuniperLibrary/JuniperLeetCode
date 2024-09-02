package com.dingchuan.lc3153;

/**
 * 3153. 所有数对中数位差之和
 */
public class lc3153 {

  public static long sumDigitDifferences(int[] nums) {
    long sum = 0;
    int n = nums.length;

    String[] numStrs = new String[n];
    for (int i = 0; i < n; i++) {
      numStrs[i] = String.valueOf(nums[i]);
    }

    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        sum += digitDifference(numStrs[i], numStrs[j]);
      }
    }

    return sum;
  }

  private static int digitDifference(String num1, String num2) {
    int diff = 0;
    for (int i = 0; i < num1.length(); i++) {
      if (num1.charAt(i) != num2.charAt(i)) {
        diff++;
      }
    }
    return diff;
  }

  public static void main(String[] args) {
    int[] nums = {13, 23, 12}; // 示例输入
    System.out.println(sumDigitDifferences(nums));
  }
}
