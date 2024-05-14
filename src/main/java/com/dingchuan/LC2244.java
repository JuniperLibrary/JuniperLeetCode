package com.dingchuan;

import java.util.HashMap;
import java.util.Map;

/**
 * 2244. 完成任务的最少轮次次数
 */
public class LC2244 {

  public int minimumRounds(int[] tasks) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int task : tasks) {
      map.put(task, map.getOrDefault(task, 0) + 1);
    }
    int res = 0;
    for (int value : map.values()) {
      if (value == 1) {
        return -1;
      }
      if (value % 3 == 0) {
        res += value / 3;
      } else {
        res += 1 + value / 3;
      }
    }
    return res;
  }


  public int minimumRounds1(int[] tasks) {
    Map<Integer, Integer> cnt = new HashMap<>();
    for (int t : tasks) {
      cnt.merge(t, 1, Integer::sum);
    }
    int ans = 0;
    for (int c : cnt.values()) {
      if (c == 1) {
        return -1;
      }
      ans += (c + 2) / 3;
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] tasks = {2, 2, 3, 3, 2, 4, 4, 4, 4, 4};
    System.out.println(new LC2244().minimumRounds(tasks));
    System.out.println(new LC2244().minimumRounds1(tasks));
  }
}
