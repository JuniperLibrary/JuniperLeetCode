package com.day;

import java.util.Arrays;

/**
 * LCP 33 蓄水
 * @author dingchuan
 */
public class LeetCodeLCP33 {

  public int storeWater(int[] bucket, int[] vat) {
    // bucket 水桶
    // vat 水缸
    // 每个水缸对应最低蓄水量记做 vat[i],返回至少需要多少次操作可以完成所有水缸蓄水要求

    // 第i个水缸配备的水桶容量记做bucket[i]
    // 升级水桶：选择任意一个水桶，使其容量增加为bucket[i]+1
    // 蓄水；将全部水桶接满水，到入各自对应的水缸

    // 实际蓄水量达到或超过最低蓄水量，即完成蓄水要求
    // bucket=[1,3]
    // vat=[6,8]

    int n = bucket.length;
    int maxk = Arrays.stream(vat).max().getAsInt();
    if (maxk == 0) {
      return 0;
    }
    int res = Integer.MAX_VALUE;
    for (int i = 1; i <= maxk && i < res; i++) {
      int t = 0;
      for (int j = 0; j < n; j++) {
        t += Math.max(0, (vat[j] + i - 1) / i - bucket[j]);
      }
      res = Math.min(res, t + i);
    }
    return res;
  }
}
