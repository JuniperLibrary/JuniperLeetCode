package com.lc150;

public class MaxAdjacentDistance {

  public int maxAdjacentDistance(int[] nums) {
    int maxDiff = 0;
    int n = nums.length;
    for (int i = 0; i < n; i++) {
      int nextIndex = (i + 1) % n;
      System.out.println("nextIndex: " + nextIndex);
      int diff = Math.abs(nums[i] - nums[nextIndex]);
      System.out.println("diff: " + diff);
      maxDiff = Math.max(maxDiff, diff);
    }
    return maxDiff;
  }

  public static void main(String[] args) {
    MaxAdjacentDistance obj = new MaxAdjacentDistance();
    System.out.println(obj.maxAdjacentDistance(new int[]{1, 2, 3}));
  }
}
