package com.uin.day;

import java.util.PriorityQueue;
import lombok.extern.slf4j.Slf4j;

/**
 * @author dingchuan
 */
@Slf4j
public class LeetCode2558 {

  /**
   * 2558. 从数量最多的堆取走礼物
   * <p>
   * 给你一个整数数组 gifts ，表示各堆礼物的数量。每一秒，你需要执行以下操作：
   * <p>
   * 选择礼物数量最多的那一堆。
   * <p>
   * 如果不止一堆都符合礼物数量最多，从中选择任一堆即可。
   * <p>
   * 选中的那一堆留下平方根数量的礼物（向下取整），取走其他的礼物。
   * <p>
   * 返回在 k 秒后剩下的礼物数量。
   * <p>
   * 输入：gifts = [25,64,9,4,100], k = 4
   * <p>
   * 输出：29
   * <p>
   * 解释：
   * <p>
   * 按下述方式取走礼物： - 在第一秒，选中最后一堆，剩下 10 个礼物。
   * <p>
   * - 接着第二秒选中第二堆礼物，剩下 8 个礼物。
   * <p>
   * - 然后选中第一堆礼物，剩下 5 个礼物。
   * <p>
   * - 最后，再次选中最后一堆礼物，剩下 3 个礼物。
   * <p>
   * 最后剩下的礼物数量分别是 [5,8,9,4,3] ，所以，剩下礼物的总数量是 29
   */
  public static long pickGifts(int[] gifts, int k) {
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> b - a);
    for (int gift : gifts) {
      priorityQueue.offer(gift);
    }

    while (k-- > 0 && !priorityQueue.isEmpty()) {
      priorityQueue.offer((int) Math.sqrt(priorityQueue.poll()));
    }
    long ans = 0;
    for (Integer i : priorityQueue) {
      ans += i;
    }
    return ans;
  }

  public static void main(String[] args) {
    log.info("从数量最多的堆取走礼物:{}", pickGifts(new int[]{25, 64, 9, 4, 100}, 4));
  }
}
