package com.uin.day;

import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LeetCode1402 {

  public static void main(String[] args) {
    log.info("最大的like-time系数总和 : {}", maxSatisfaction(new int[]{-1, -8, 0, 5, -9}));
  }

  public static int maxSatisfaction(int[] satisfaction) {
    // 1402. 做菜顺序
    // 做出的每一道菜时间都是 1 单位时间
    // like-time系数 times[i] * satisfaction[i]
    // 返回可以获得的最大的like-time系数总和
    // 你可以按任意顺序安排做菜的顺序，你也可以选择放弃某些菜来获得更大的总和
    Arrays.sort(satisfaction);
    int ans = 0, s = 0;
    for (int i = satisfaction.length - 1; i >= 0; --i) {
      s += satisfaction[i];
      if (s <= 0) {
        break;
      }
      ans += s;
    }
    return ans;
  }
}
