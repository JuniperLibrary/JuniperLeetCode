package com.uin.day;

import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;

/**
 * @author dingchuan
 */
@Slf4j
public class LeetCode274 {

  /**
   * 274. H 指数
   * <p>
   * 给你一个整数数组 citations ，其中 citations[i] 表示研究者的第 i 篇论文被引用的次数。
   * <p>
   * 计算并返回该研究者的 h 指数。
   * <p>
   * 根据维基百科上 h 指数的定义：h 代表“高引用次数” ，一名科研人员的 h 指数 是指他（她）至少发表了 h 篇论文，
   * <p>
   * 并且每篇论文 至少 被引用 h 次。如果 h 有多种可能的值，h 指数 是其中最大的那个。
   * <p>
   * 输入：citations = [3,0,6,1,5]
   * <p>
   * 输出：3
   * <p>
   * 解释：给定数组表示研究者总共有 5 篇论文，每篇论文相应的被引用了 3, 0, 6, 1, 5 次。
   * <p>
   * 由于研究者有 3 篇论文每篇 至少 被引用了 3 次，其余两篇论文每篇被引用 不多于 3 次，所以她的 h 指数是 3。
   */
  public static int hIndex(int[] citations) {
    // 0 1 3 5 6
    Arrays.sort(citations);
    int n = citations.length;
    for (int h = n; h > 0; h--) {
      if (citations[n - h] >= h) {
        return h;
      }
    }
    return 0;
  }

  public static int hIndex2(int[] citations) {
    int n = citations.length;
    // cnt[i] 表示引用次数为 i 的论文篇数
    int[] cnt = new int[n + 1];

    for (int citation : citations) {
      ++cnt[Math.min(citation, n)];
    }
    for (int h = n, s = 0; ; --h) {
      s = s + cnt[h];

      if (s >= h) {
        return h;
      }
    }
  }

  public static int hIndex3(int[] citations) {
    int l = 0, r = citations.length;
    while (l < r) {
      int mid = (l + r + 1) >> 1;
      int s = 0;
      for (int citation : citations) {
        if (citation >= mid) {
          ++s;
        }
      }
      if (s >= mid) {
        l = mid;
      } else {
        r = mid - 1;
      }
    }
    return l;
  }

  public static void main(String[] args) {
    log.info("H 指数:{}", hIndex(new int[]{3, 0, 6, 1, 5}));
    log.info("H 指数:{}", hIndex2(new int[]{3, 0, 6, 1, 5}));
    log.info("H 指数:{}", hIndex3(new int[]{3, 0, 6, 1, 5}));
  }
}
