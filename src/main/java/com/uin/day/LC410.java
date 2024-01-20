package com.uin.day;

import lombok.extern.slf4j.Slf4j;

/**
 * @author dingchuan
 */
@Slf4j
public class LC410 {

  public static int splitArray(int[] nums, int k) {
    int max = 0;
    int sum = 0;

    for (int num : nums) {
      max = Math.max(num, max);
      sum += num;
    }

    int left = max;
    int right = sum;
    while (left < right) {
      int mid = left + (right - left) / 2;
      int spilts = spilt(nums, mid);
      if (spilts > k) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    return left;
  }

  private static int spilt(int[] nums, int maxIntervalSum) {
    int spilts = 1;
    int curIntervalSum = 0;
    for (int num : nums) {
      if (curIntervalSum + num > maxIntervalSum) {
        curIntervalSum = 0;
        spilts++;
      }
      curIntervalSum += num;
    }
    return spilts;
  }

  public static void main(String[] args) {
    int[] nums = {7, 2, 5, 10, 8};
    int k = 2;
    log.info("res = {}",splitArray(nums,k));
  }
}
