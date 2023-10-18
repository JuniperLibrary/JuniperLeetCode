package com.uin.day;

import java.util.PriorityQueue;
import lombok.extern.slf4j.Slf4j;

/**
 * @author lin.liu
 */
@Slf4j
public class LeetCode2530 {

  /**
   * 2530 执行k次操作后的最大分数
   * <p>
   * 给你一个下标从0开始的整数数组nums和一个整数k。你的起始分数为0
   * <p>
   * 1、 选出一个满足 0 <= i <= nums.length 2、 将你的分数增加 nums[i] 3、 将nums[i]替换为 celi(nums[i] / 3)
   * <p>
   * <p>
   * 示例 1：
   * <p>
   * 输入：nums = [10,10,10,10,10], k = 5 输出：50 解释：对数组中每个元素执行一次操作。最后分数是 10 + 10 + 10 + 10 + 10 = 50 。
   * 示例 2：
   * <p>
   * 输入：nums = [1,10,3,3,3], k = 3 输出：17
   * <p>
   * 解释：可以执行下述操作： 第 1 步操作：选中 i = 1 ，nums 变为 [1,4,3,3,3] 。分数增加 10 。 第 2 步操作：选中 i = 1 ，nums 变为
   * [1,2,3,3,3] 。分数增加 4 。 第 3 步操作：选中 i = 2 ，nums 变为 [1,1,1,3,3] 。分数增加 3 。 最后分数是 10 + 4 + 3 = 17 。
   */

  public static long maxKelements(int[] nums, int k) {
    // 堆排序 大根堆
    PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
    for (int num : nums) {
      queue.offer(num);
    }
    long ans = 0;
    for (int i = 0; i < k; i++) {
      int x = queue.poll();
      ans += x;
      queue.offer((x + 2) / 3);
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] nums = {1, 10, 3, 3, 3};
    int k = 3;
    log.info("执行k次操作后的最大分数:{}", maxKelements(nums, k));
  }
}
