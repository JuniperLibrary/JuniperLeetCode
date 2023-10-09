package com.uin.day;

import java.util.Arrays;

/**
 * @author lin.liu
 */
public class LeetCode2578 {

  /**
   * 2578 最小和分割
   *
   * @param num
   * @return
   */
  public static int splitNum(int num) {
    int[] cnt = new int[10];
    int n = 0;
    for (; num > 0; num /= 10) {
      ++cnt[num % 10];
      ++n;
    }
    int[] ans = new int[2];
    for (int i = 0, j = 0; i < n; i++) {
      while (cnt[j] == 0) {
        ++j;
      }
      --cnt[j];
      ans[i & 1] = ans[i & 1] * 10 + j;
    }
    return ans[0] + ans[1];
  }

  public static int splitNumGreedy(int num) {
    char[] s = (num + "").toCharArray();
    Arrays.sort(s);
    int[] ans = new int[2];
    for (int i = 0; i < s.length; i++) {
      ans[i & 1] = ans[i & 1] * 10 + s[i] - '0';
    }
    return ans[0] + ans[1];
  }

  public static void main(String[] args) {
    splitNumGreedy(4325);
  }
}
