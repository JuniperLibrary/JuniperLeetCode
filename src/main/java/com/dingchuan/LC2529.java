package com.dingchuan;

public class LC2529 {

  public int maximumCount(int[] nums) {
    int pos = 0;
    int neg = 0;
    for (int num : nums) {
      if (num > 0) {
        pos++;
      } else if (num < 0) {
        neg++;
      }
    }
    return Math.max(pos, neg);
  }


  public int maximumCount2(int[] nums) {
    int pos1 = lowerBound(nums,0);
    int pos2 = lowerBound(nums,1);
    return Math.max(pos1, nums.length-pos2);
  }

  public int lowerBound(int[] nums ,int val){
    int left =0;
    int right = nums.length;
    while (left < right){
      int m = (left+right)/2;
      if (nums[m] < val){
        left = m+1;
      }else {
        right = m;
      }
    }
    return left;
  }
}
