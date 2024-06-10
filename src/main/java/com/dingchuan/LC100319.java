package com.dingchuan;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 100319. 执行操作可获得的最大总奖励 I
 * <p>
 * 给你一个整数数组 rewardValues，长度为 n，代表奖励的值。
 * <p>
 * 最初，你的总奖励 x 为 0，所有下标都是 未标记 的。你可以执行以下操作 任意次 ：
 * <p>
 * 从区间 [0, n - 1] 中选择一个 未标记 的下标 i。
 * <p>
 * 如果 rewardValues[i] 大于 你当前的总奖励 x，则将 rewardValues[i] 加到 x 上（即 x = x + rewardValues[i]），并 标记 下标 i。
 * <p>
 * 以整数形式返回执行最优操作能够获得的 最大 总奖励。
 * <p>
 * 输入：rewardValues = [1,1,3,3]
 * <p>
 * 输出：4
 * <p>
 * 解释：
 * <p>
 * 依次标记下标 0 和 2，总奖励为 4，这是可获得的最大值。
 */
public class LC100319 {

  public int maxTotalReward(int[] rewardValues) {
    int n = rewardValues.length;
    Arrays.sort(rewardValues); // 将奖励值从小到大排序
    boolean[] marked = new boolean[n];
    int totalReward = 0;

    for (int reward : rewardValues) {
      boolean found = false;
      for (int i = 0; i < n; i++) {
        if (!marked[i] && reward > totalReward) {
          totalReward += reward;
          marked[i] = true;
          found = true;
          break;
        }
      }
      if (!found && reward > totalReward) {
        totalReward += reward;
      }
    }

    return totalReward;
  }

  public static void main(String[] args) {
    int[] rewardValues1 = {1, 1, 3, 3};
    int[] rewardValues2 = {1, 6, 4, 3, 2};

    System.out.println(new LC100319().maxTotalReward(rewardValues1));
    System.out.println(new LC100319().maxTotalReward(rewardValues2));
  }
}
