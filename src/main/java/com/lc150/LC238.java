package com.lc150;

// 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
//
//题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
//
//请 不要使用除法，且在 O(n) 时间复杂度内完成此题。
// 输入: nums = [1,2,3,4]
//输出: [24,12,8,6]
public class LC238 {

  public int[] productExceptSelf(int[] nums) {
    int n = nums.length;
    int[] L = new int[n];
    int[] R = new int[n];

    int[] answer = new int[n];

    L[0] = 1;
    for (int i = 1; i < n; i++) {
      L[i] = nums[i - 1] * L[i - 1];
    }
    R[n - 1] = 1;
    for (int i = n - 2; i >= 0; i--) {
      R[i] = nums[i + 1] * R[i + 1];
    }

    for (int i = 0; i < n; i++) {
      answer[i] = L[i] * R[i];
    }
    return answer;
  }

  public static void main(String[] args) {
    int[] nums = {1, 2, 3, 4};
    LC238 lc238 = new LC238();
    int[] ints = lc238.productExceptSelf(nums);
    for (int anInt : ints) {
      System.out.println(anInt);
    }
  }
}
