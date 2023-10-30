package com.uin.day;

import lombok.extern.slf4j.Slf4j;

/**
 * 275. H 指数 II
 *
 * @author liu.lin
 */
@Slf4j
public class LeetCode275 {

  /**
   * @param citations 已经按照 升序排列
   * @return 算并返回该研究者的 h 指数
   */
  public static int hIndex(int[] citations) {
    int n = citations.length;
    int l = 0, r = n;
    while (l < r) {
      int mid = (l + r) >>> 1;
      if (citations[mid] >= n - mid) {
        r = mid;
      } else {
        l = mid + 1;
      }
    }
    return n - l;
  }

  public static void main(String[] args) {
    log.info("H指数II:{}", hIndex(new int[]{0, 1, 3, 5, 6}));
  }
}
