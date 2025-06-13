package com.lc150;

import java.util.*;

public class MinimizeMax {

  public int minimizeMax(int[] nums, int p) {
    Arrays.sort(nums);
    int left = 0;
    // 最大值 减去 最小值 是 最大差值
    int right = nums[nums.length - 1] - nums[0];
    while (left < right) {
      int mid = (left + right) / 2;
      if (canPick(nums, p, mid)) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    return left;
  }

  private boolean canPick(int[] nums, int p, int mid) {
    int count = 0;
    int i = 1;
    while (i < nums.length) {
      if (nums[i] - nums[i - 1] <= mid) {
        count++;
        // 跳过当前这两个元素（不能重叠）
        i += 2;
      } else {
        // 不满足则只跳一个
        i++;
      }
    }
    return count >= p;
  }


  public static void main(String[] args) {
    MinimizeMax mm = new MinimizeMax();
    System.out.println(mm.minimizeMax(new int[]{10, 1, 2, 7, 1, 3}, 2));
  }
}
