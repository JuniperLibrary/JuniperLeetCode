package com.dingchuan;

/**
 * 100325. 找出 K 秒后拿着球的孩子
 * <p>
 * 给你两个 正整数 n 和 k。有 n 个编号从 0 到 n - 1 的孩子按顺序从左到右站成一队。
 * <p>
 * 最初，编号为 0 的孩子拿着一个球，并且向右传球。每过一秒，拿着球的孩子就会将球传给他旁边的孩子。一旦球到达队列的 任一端 ，即编号为 0 的孩子或编号为 n - 1 的孩子处，传球方向就会
 * 反转 。
 * <p>
 * 返回 k 秒后接到球的孩子的编号。
 * <p>
 * 输入：n = 3, k = 5
 * <p>
 * 输出：1
 * <p>
 * 解释：
 * <p>
 * 经过的时间	孩子队列
 * <p>
 * 0	[0, 1, 2]
 * <p>
 * 1	[0, 1, 2]
 * <p>
 * 2	[0, 1, 2]
 * <p>
 * 3	[0, 1, 2]
 * <p>
 * 4	[0, 1, 2]
 * <p>
 * 5	[0, 1, 2]
 */
public class LC100325 {

  public int numberOfChild(int n, int k) {
    int current = 0;
    int direction = 1;

    for (int i = 0; i < k; i++) {
      current += direction;

      if (current == 0 || current == n - 1) {
        direction = -direction;
      }
    }

    return current;
  }

  public static void main(String[] args) {
    System.out.println(new LC100325().numberOfChild(3, 5));
  }
}
