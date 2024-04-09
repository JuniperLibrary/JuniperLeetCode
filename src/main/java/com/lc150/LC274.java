package com.lc150;

import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LC274 {
  public int hIndex(int[] citations) {
    Arrays.sort(citations);
    int n = citations.length;
    for (int i = 0; i < n; i++) {
      // 如果citations[i] >= n - i，说明至少存在n - i篇论文，每篇被引用次数不少于n - i次
      if (citations[i] >= n - i) {
        return n - i;
      }
    }
    return 0;
  }
  public static void main(String[] args) {
    LC274 lc274 = new LC274();
    int[] citations = {3, 0, 6, 1, 5};
    int hIndex = lc274.hIndex(citations);
    log.info("H-index:{}",hIndex);
  }
}
