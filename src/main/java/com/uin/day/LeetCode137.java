package com.uin.day;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author dingchuan
 */
public class LeetCode137 {

  /**
   * 137. 只出现一次的数字 II
   * <p>
   * 你必须设计并实现线性时间复杂度的算法且使用常数级空间来解决此问题
   */
  public int singleNumber(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }

    for (Entry<Integer, Integer> entry : map.entrySet()) {
      Integer key = entry.getKey();
      Integer value = entry.getValue();
      if (value == 1) {
        return key;
      }
    }
    return 0;
  }
}
