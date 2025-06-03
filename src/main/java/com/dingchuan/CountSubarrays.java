package com.dingchuan;

public class CountSubarrays {

  public long countSubarrays(int[] nums, long k) {
    // 数组之和 * 长度
    int n = nums.length;
    long res = 0, total = 0;
    for (int i = 0, j = 0; j < n; j++) {
      total += nums[j];
      while (i <= j && total * (j - i + 1) >= k) {
        total -= nums[i];
        i++;
      }
      res += j - i + 1;
    }
    return res;
  }

  public static void main(String[] args) {
    CountSubarrays c = new CountSubarrays();
    System.out.println(c.countSubarrays(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 3));
  }
}
