package com.uin.leetcode_100;

/**
 * 283. 移动零
 * <p>
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 *
 * @author dingchuan
 */
public class LC283 {
  public void moveZeroes(int[] nums) {
    int n = nums.length;
    int left = 0;
    for (int right = 0; right < n; right++) {
      if (nums[right] != 0) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
        left++;
      }
    }
  }

  public static void main(String[] args) {
    int[] nums = {0, 1, 0, 3, 12};
    new LC283().moveZeroes(nums);
  }
}
