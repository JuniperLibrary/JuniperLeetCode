package com.dingchuan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LC2009 {

  public int minOperations(int[] nums) {
    int n = nums.length;
    Set<Integer> set = new HashSet<>();
    for (int num : nums) {
      set.add(num);
    }
    List<Integer> sortUnique = new ArrayList<>(set);
    Collections.sort(sortUnique);

    int res = n;
    int j = 0;

    for (int i = 0; i < sortUnique.size(); i++) {
      int left = sortUnique.get(i);
      int right = left + n - 1;

      while (j < sortUnique.size() && sortUnique.get(j) <= right) {
        res = Math.min(res, n - (j - i + 1));
        j++;
      }
    }
    return res;
  }

  public static void main(String[] args) {
    int[] nums = {1, 2, 4, 8};
    LC2009 lc2009 = new LC2009();
    log.info("res = {}", lc2009.minOperations(nums));
  }

}
