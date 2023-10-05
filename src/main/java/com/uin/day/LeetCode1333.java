package com.uin.day;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode1333 {

  public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice,
      int maxDistance) {
    // 按照 rating 和 id 排序
    Arrays.sort(restaurants, (a, b) -> a[1] == b[1] ? b[0] - a[0] : b[1] - a[1]);

    List<Integer> ans = new ArrayList<>();

    for (int[] restaurant : restaurants) {
      if (restaurant[2] >= veganFriendly && restaurant[3] <= maxPrice
          && restaurant[4] <= maxDistance) {
        ans.add(restaurant[0]);
      }
    }
    return ans;
  }
}
