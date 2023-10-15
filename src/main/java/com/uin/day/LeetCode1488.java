package com.uin.day;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author dingchuan
 */
public class LeetCode1488 {

  /**
   * LeetCode 1488 避免洪水泛滥
   * <p>
   * 你的国家有无数个湖泊，所有湖泊一开始都是空的。当第 n 个湖泊下雨前是空的，那么它就会装满水。
   * <p>
   * 如果第n个湖泊下雨前是满的
   */
  public int[] avoidFlood(int[] rains) {
    int n = rains.length;
    int[] ans = new int[n];
    Arrays.fill(ans, -1);
    TreeSet<Integer> sunny = new TreeSet<>();
    Map<Integer, Integer> rainy = new HashMap<>();
    for (int i = 0; i < n; i++) {
      int v = rains[i];
      if (v > 0) {
        if (rainy.containsKey(v)) {
          Integer t = sunny.higher(rainy.get(v));
          if (t == null) {
            return new int[0];
          }
          ans[t] = v;
          sunny.remove(t);
        }
        rainy.put(v, i);
      } else {
        sunny.add(i);
        ans[i] = 1;
      }
    }
    return ans;
  }
}
