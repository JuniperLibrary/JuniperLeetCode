package com.uin.day;

import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

/**
 * LeetCode 2865 美丽塔 1
 *
 * @author dingchuan
 */
@Slf4j
public class LC2865 {
  public static long maxmumSumOfHeighgts(List<Integer> maxHeights){
    /*
    给你一个长度为n的下标从0开始的整数数组maxHeights.你的任务是在坐标轴上建n座塔。
    第i座塔的下标为i，高度为heights[i].
    如果一下条件满足，我们称之为这些塔是美丽的：
    - 1 <= heights[i] <= maxHeights[i]
    - heights是一个山脉数组
    如果存在下标i满足以下条件，那么我们称之为数组heights是一个山脉数组。
    - 对于所有的 0 <= j <= i,都有heights[j-1] <= heights[j]
    - 对于所有的 i<= k < n-1 .都有heights[k+1] <= heights[k]
    请你返回满足美丽塔要求的方案中，高度和的最大值。

    输入：maxHeights = [5,3,4,1,1]
    输出：13
    解释：和最大的美丽塔方案为 heights = [5,3,3,1,1],这是一个美丽塔方案，因为
    - 1 <= heights[i] <= maxheghts[i]
    - heights是个山脉数组，峰值在 i=0处。13是所有美丽塔方案中的最大高度和
     */
    long ans = 0;
    int n = maxHeights.size();
    for (int i = 0; i < n; ++i) {
      int y = maxHeights.get(i);
      long t = y;
      for (int j = i - 1; j >= 0; --j) {
        y = Math.min(y, maxHeights.get(j));
        t += y;
      }
      y = maxHeights.get(i);
      for (int j = i + 1; j < n; ++j) {
        y = Math.min(y, maxHeights.get(j));
        t += y;
      }
      ans = Math.max(ans, t);
    }
    return ans;
  }

  public static void main(String[] args) {
    List<Integer> integers = new ArrayList<>();
    integers.add(5);
    integers.add(3);
    integers.add(4);
    integers.add(1);
    integers.add(1);
    log.info("res:{}",maxmumSumOfHeighgts(integers));
  }
}
