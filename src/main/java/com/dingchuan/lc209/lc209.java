package com.dingchuan.lc209;

public class lc209 {

  public int minSubArrayLen(int target, int[] nums) {
    int n = nums.length;  // 获取数组的长度
    if (n == 0) {  // 如果数组为空，直接返回 0
      return 0;
    }
    int ans = Integer.MAX_VALUE;  // 初始化结果为一个极大值，用于存储最短子数组的长度
    int start = 0, end = 0;  // start 和 end 是滑动窗口的两个指针，初始位置都为 0
    int sum = 0;  // sum 变量用于记录当前滑动窗口中所有元素的和

    // 开始遍历数组
    while (end < n) {
      sum += nums[end];  // 将 end 指向的元素加入到当前窗口的和中
      // 当窗口中的和大于等于 target 时，尝试缩小窗口
      while (sum >= target) {
        // 更新最短子数组的长度为当前子数组的长度
        ans = Math.min(ans, end - start + 1);
        // 缩小窗口，将 start 指向的元素从 sum 中移除
        sum -= nums[start];
        start++;  // 将 start 右移，缩小窗口
      }
      end++;  // 扩大窗口，将 end 右移
    }

    // 如果 ans 没有被更新，说明没有找到符合条件的子数组，返回 0
    return ans == Integer.MAX_VALUE ? 0 : ans;
  }

  public static void main(String[] args) {
    int[] nums = {2, 3, 1, 2, 4, 3};
    int target = 7;
    System.out.println(new lc209().minSubArrayLen(target, nums));
  }
}
