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
    log.info("执行k次操作后的最大分数:{}", maxKelements2(nums, k));
  }


  public static long maxKelements2(int[] nums, int k) {
    // 自己构建大根堆
    heapify(nums);
    long ans = 0;
    while (k-- > 0) {
      // 堆顶
      ans += nums[0];
      nums[0] = (nums[0] + 2) / 3;
      // 维持大根堆
      sink(nums, 0);
    }
    return ans;
  }

  /**
   * 把 h[i] 不断下沉，直到 i 的左右儿子都 <= h[i]
   */
  private static void sink(int[] h, int i) {
    int n = h.length;
    while (2 * i + 1 < n) {
      // i 的左儿子
      int j = 2 * i + 1;
      // i 的右儿子比 i 的左儿子大
      if (j + 1 < n && h[j + 1] > h[j]) {
        j++;
      }
      // 说明 i 的左右儿子都 <= h[i]，停止下沉
      if (h[j] <= h[i]) {
        break;
      }
      // 下沉
      swap(h, i, j);
      i = j;
    }
  }

  /**
   * 交换 h[i] 和 h[j]
   *
   * @param h
   * @param i
   * @param j
   */
  private static void swap(int[] h, int i, int j) {
    int tmp = h[i];
    h[i] = h[j];
    h[j] = tmp;
  }

  /**
   * 堆化可以保证 h[0] 是堆顶元素，且 h[i] >= max(h[2*i+1], h[2*i+2])
   *
   * @param h
   */
  private static void heapify(int[] h) {
    // 下标 >= h.length / 2 的元素是二叉树的叶子，无需下沉
    // 倒着遍历，从而保证 i 的左右子树一定是堆，那么 sink(h, i) 就可以把左右子树合并成一个堆
    for (int i = h.length / 2 - 1; i >= 0; i--) {
      sink(h, i);
    }
  }
}
