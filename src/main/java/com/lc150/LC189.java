package com.lc150;

/**
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * <p>
 * 输出: [5,6,7,1,2,3,4]
 * <p>
 * 解释:
 * <p>
 * 向右轮转 1 步: [7,1,2,3,4,5,6]
 * <p>
 * 向右轮转 2 步: [6,7,1,2,3,4,5]
 * <p>
 * 向右轮转 3 步: [5,6,7,1,2,3,4]
 */
public class LC189 {

  public void rotate(int[] nums, int k) {
    int n = nums.length;
    int[] newArr = new int[n];
    for (int i = 0; i < n; i++) {
      newArr[(i + k) % n] = nums[i];
    }
    System.arraycopy(newArr, 0, nums, 0, n);
  }
}
