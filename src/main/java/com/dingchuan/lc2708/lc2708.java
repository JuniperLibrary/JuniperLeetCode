package com.dingchuan.lc2708;

/**
 * 2708. 一个小组的最大实力值
 */
public class lc2708 {

  /**
   * 计算给定整数数组中元素的乘积，优化乘积的最大负值影响
   *
   * @param nums 整数数组，可能包含负数、零和正数
   * @return 计算出的乘积，优化了最大负值的影响
   */
  public long maxStrength(int[] nums) {
    // 初始化计数变量，用于统计负数、零和正数的数量
    int negativeCount = 0, zeroCount = 0, positiveCount = 0;
    // 初始化乘积为1，用于累乘数组中的元素
    long prod = 1;
    // 初始化最大负数值为-9，用于后续寻找最大的负数
    int maxNegative = -9;

    // 遍历数组，根据元素值的正负和是否为零进行分类处理
    for (int num : nums) {
      if (num < 0) {
        negativeCount++;
        prod *= num;
        maxNegative = Math.max(maxNegative, num);
      } else if (num == 0) {
        zeroCount++;
      } else {
        prod *= num;
        positiveCount++;
      }
    }

    // 如果数组中只有一个负数且没有零和正数，则直接返回该负数
    if (negativeCount == 1 && zeroCount == 0 && positiveCount == 0) {
      return nums[0];
    }

    // 如果负数个数小于等于1且没有正数，则返回0，因为零的数量会影响乘积
    if (negativeCount <= 1 && positiveCount == 0) {
      return 0;
    }

    // 如果乘积为负，则除以最大的负数以优化乘积值
    if (prod < 0) {
      return prod / maxNegative;
    } else {
      // 如果乘积为非负，则直接返回乘积
      return prod;
    }
  }

  public static void main(String[] args) {
    lc2708 lc2708 = new lc2708();
    System.out.println(lc2708.maxStrength(new int[]{-1, -2, -3, -4, -5}));
  }
}
