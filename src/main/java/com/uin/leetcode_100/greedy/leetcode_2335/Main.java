package com.uin.leetcode_100.greedy.leetcode_2335;

import java.util.Arrays;

public class Main {

  public int fillCups(int[] amount) {
    // 现有一台饮水机，可以制备冷水、温水和热水。
    // 每秒钟，可以装满 2 杯不同类型的水或者1杯任意类型的水

    // 给你一个下标从0开始、长度为3的整数数组amount。
    // 其中amount[0]、amount[1]和amount[2]分别表示需要装满冷水、温水和热水的杯子数量
    // 返回装满所有杯子所需的最少秒数。
    int ans = 0;
    while (amount[0] + amount[1] + amount[2] > 0) {
      Arrays.sort(amount);
      ++ans;
      amount[2]--;
      amount[1] = Math.max(0, amount[1] - 1);
    }
    return ans;
  }
}
