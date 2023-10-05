package main.java.com.uin.day;

/**
 * 1749. 任意子数组和的绝对值的最大值
 * <p>
 * 给你一个整数数组 nums 。一个子数组 [numsl, numsl+1, ..., numsr-1, numsr] 的 和的绝对值 为 abs(numsl + numsl+1 + ... +
 * numsr-1 + numsr) 。
 *
 * @author dingchuan
 */
public class LeetCode1749 {

  /*输入：nums = [1,-3,2,3,-4]
  输出：5
  解释：子数组 [2,3] 和的绝对值最大，为 abs(2+3) = abs(5) = 5 。*/
  public int maxAbsoluteSum(int[] nums) {
    // 子数组 要求连续
    int f =0, g=0;
    int ans =0;
    for (int num : nums) {
      f = Math.max(f,0)+num;
      g = Math.min(g,0)+num;
      ans = Math.max(ans,Math.max(f,Math.abs(g)));
    }
    return ans;
  }
}
