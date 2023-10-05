package com.uin.day;

/**
 * 167. 两数之和 II - 输入有序数组
 * <p>
 * 给你一个下标从 1 开始的整数数组 numbers ，该数组已按 非递减顺序排列  ，请你从数组中找出满足相加之和等于目标数 target 的两个数。如果设这两个数分别是 numbers[index1] 和
 * numbers[index2] ，则 1 <= index1 < index2 <= numbers.length 。
 * <p>
 * 以长度为 2 的整数数组 [index1, index2] 的形式返回这两个整数的下标 index1 和 index2。
 * <p>
 * 你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。
 * <p>
 * 你所设计的解决方案必须只使用常量级的额外空间。
 * @author dingchuan
 */
public class LeetCode_167 {

  public int[] twoSum(int[] numbers, int target) {
    // [-,2,7,11,15]
    // 1 <= index1 < index2 <= numbers.length
    int i = 0;
    int j = numbers.length - 1;
    while (i < j) {
      int sum = numbers[i] + numbers[j];
      if (sum < target) {
        i++;
      } else if (sum > target) {
        j--;
      } else {
        return new int[]{i, j};
      }
    }
    return new int[]{-1, -1};
  }
}
