package com.uin.day;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import lombok.extern.slf4j.Slf4j;

/**
 * @author dingchuan
 */
@Slf4j
public class LeetCode136 {

  public static void main(String[] args) {
    log.info("2 ^ 1:{}", 2 ^ 1);
    log.info("1 ^ 2:{}", 1 ^ 2);
    log.info("2 ^ 3:{}", 2 ^ 3);
    log.info("1 ^ 1:{}", 1 ^ 1);
    log.info("0 ^ 0:{}", 0 ^ 0);
    log.info("只出现一次的数字:{}", singleNumber(new int[]{2, 2, 1}));
  }

  public static int singleNumber(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }
    for (Entry<Integer, Integer> entry : map.entrySet()) {
      if (entry.getValue() == 1) {
        return entry.getKey();
      }
    }
    return 0;
  }

  public static int singleNumber2(int[] nums) {
    return Arrays.stream(nums).reduce((a, b) -> a ^ b).getAsInt();
  }
}
