package com.dingchuan;

/**
 * 3038. 相同分数的最大操作数目 I
 *
 * @author dingchuan
 */
public class LC3038 {

  public int maxOperations(int[] nums) {
    int n = nums.length;
    int ans = 0;
    for (int i = 1; i < n; i += 2) {
      if (nums[i] + nums[i - 1] != nums[1] + nums[0]) {
        break;
      }
      ans++;
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    System.out.println(new LC3038().maxOperations(nums));
  }
}
