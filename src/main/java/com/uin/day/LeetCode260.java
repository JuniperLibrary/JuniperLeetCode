package com.uin.day;

import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

/**
 * 260 只出现一次的数字 III
 *
 * @author dingchuan
 */
@Slf4j
public class LeetCode260 {

  public static void main(String[] args) {
    int[] nums = {1, 2, 1, 3, 2, 5};
    log.info("只出现一次的数字 III:{}", singleNumber(nums));
    log.info("只出现一次的数字 III:{}", singleNumber2(nums));
  }

  public static int[] singleNumber(int[] nums) {
    Map<Integer, Integer> freq = new HashMap<>();
    for (int num : nums) {
      freq.put(num, freq.getOrDefault(num, 0) + 1);
    }
    int[] ans = new int[2];
    int index = 0;
    for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
      if (entry.getValue() == 1) {
        ans[index++] = entry.getKey();
      }
    }
    return ans;
  }

  public static int[] singleNumber2(int[] nums) {
    int xorsum = 0;
    for (int num : nums) {
      xorsum ^= num;
    }

    int lsb = (xorsum == Integer.MIN_VALUE ? xorsum : xorsum & (-xorsum));
    int[] ans = new int[2];
    for (int num : nums) {
      if ((num & lsb) != 0) {
        ans[0] ^= num;
      } else {
        ans[1] ^= num;
      }
    }
    return ans;
  }
}
