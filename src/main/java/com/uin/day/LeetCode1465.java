package com.uin.day;

import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;

/**
 * @author dingchuan
 */
@Slf4j
public class LeetCode1465 {

  /**
   * 1465 切割后面积最大的蛋糕
   * <p>
   * 矩形蛋糕的高度为 h 且宽度为 w，给你两个整数数组 horizontalCuts 和 verticalCuts，其中： horizontalCuts[i] 是从矩形蛋糕顶部到第  i
   * 个水平切口的距离 verticalCuts[j] 是从矩形蛋糕的左侧到第 j 个竖直切口的距离 请你按数组 horizontalCuts 和 verticalCuts
   * 中提供的水平和竖直位置切割后， 请你找出 面积最大 的那份蛋糕，并返回其 面积 。 由于答案可能是一个很大的数字，因此需要将结果 对 109 + 7 取余 后返回。
   */
  public static int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
    final int mod = (int) (1e9 + 7);
    Arrays.sort(horizontalCuts);
    Arrays.sort(verticalCuts);
    int m = horizontalCuts.length;
    int n = verticalCuts.length;

    long x = Math.max(horizontalCuts[0], h - horizontalCuts[m - 1]);
    long y = Math.max(verticalCuts[0], w - verticalCuts[n - 1]);

    for (int i = 1; i < m; ++i) {
      x = Math.max(x, horizontalCuts[i] - horizontalCuts[i - 1]);
    }
    for (int i = 1; i < n; i++) {
      y = Math.max(y, verticalCuts[i] - verticalCuts[i - 1]);
    }
    return (int) ((x * y) % mod);
  }

  public static void main(String[] args) {
    // h = 5, w = 4, horizontalCuts = [1,2,4], verticalCuts = [1,3]
    log.info("切割后最大的面积：{}", maxArea(5, 4, new int[]{1, 2, 4}, new int[]{1, 3}));
  }
}
