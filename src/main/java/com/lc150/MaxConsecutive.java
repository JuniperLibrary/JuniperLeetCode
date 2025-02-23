package com.lc150;

import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MaxConsecutive {

  public int maxConsecutive(int bottom, int top, int[] special) {
    Arrays.sort(special);

    int ans = 0;

    ans = Math.max(ans, special[0] - bottom);
    for (int i = 1; i < special.length; i++) {
      ans = Math.max(ans, special[i] - special[i - 1] - 1);
    }
    ans = Math.max(ans, top - special[special.length - 1]);
    return ans;
  }

  public static void main(String[] args) {
    int i = new MaxConsecutive().maxConsecutive(2, 9, new int[]{4, 6});
    log.info("不含特殊楼层的最大连续楼层数:{}", i);
  }
}
