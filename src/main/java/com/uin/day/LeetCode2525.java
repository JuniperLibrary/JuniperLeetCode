package com.uin.day;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LeetCode2525 {

  /**
   * 2525 根据规则将箱子分类
   * <p>
   * 给你四个整数 length ，width ，height 和 mass ，分别表示一个箱子的三个维度和质量，请你返回一个表示箱子 类别 的字符串。
   * <p>
   * 如果满足以下条件，那么箱子是 "Bulky" 的：
   * <p>
   * 箱子 至少有一个 维度大于等于 104 。
   * <p>
   * 或者箱子的 体积 大于等于 109 。
   * <p>
   * 如果箱子的质量大于等于 100 ，那么箱子是 "Heavy" 的。
   * <p>
   * 如果箱子同时是 "Bulky" 和 "Heavy" ，那么返回类别为 "Both" 。
   * <p>
   * 如果箱子既不是 "Bulky" ，也不是 "Heavy" ，那么返回类别为 "Neither" 。
   * <p>
   * 如果箱子是 "Bulky" 但不是 "Heavy" ，那么返回类别为 "Bulky" 。
   * <p>
   * 如果箱子是 "Heavy" 但不是 "Bulky" ，那么返回类别为 "Heavy" 。
   * <p>
   * 注意，箱子的体积等于箱子的长度、宽度和高度的乘积。
   */
  public static String categorizeBox(int length, int width, int height, int mass) {
    long v = (long) length * width * height;
    int bulky = length >= 10000 || width >= 10000 || height >= 10000 || v >= 1000000000 ? 1 : 0;
    int heavy = mass >= 100 ? 1 : 0;
    String[] d = {"Neither", "Bulky", "Heavy", "Both"};
    int i = heavy << 1 | bulky;
    return d[i];
  }

  public static void main(String[] args) {
    log.info("根据规则将箱子分类：{}", categorizeBox(1000, 35, 700, 300));
  }
}
