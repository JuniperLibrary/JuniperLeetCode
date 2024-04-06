package com.lc150;

/**
 * 169. 多数元素
 * <p>
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 * 输入：nums = [3,2,3]
 * <p>
 * 输出：3
 *
 * @author dingchuan
 */
public class LC169 {

  public static int majorityElement(int[] nums) {
    int count = 0;
    int candidate = 0;
    for (int num : nums) {
      if (count == 0) {
        candidate = num;
      }
      count += (num == candidate) ? 1 : -1;
    }
    return candidate;
  }

  public static void main(String[] args) {
    int[] nums = {6,5,5};
    System.out.println(majorityElement(nums));
  }
}
