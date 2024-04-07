package com.uin.day;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LeetCode765 {

  /**
   * 765 情侣牵手
   * <p>
   * n 对情侣坐在连续排列的 2n 个座位上，想要牵到对方的手。
   * <p>
   * 人和座位由一个整数数组 row 表示，其中 row[i] 是坐在第 i 个座位上的人的 ID。
   * <p>
   * 情侣们按顺序编号，第一对是 (0, 1)，第二对是 (2, 3)，以此类推，最后一对是(2n-2, 2n-1)。
   * <p>
   * 返回 最少交换座位的次数，以便每对情侣可以并肩坐在一起。 每次交换可选择任意两人，让他们站起来交换座位。
   * <p>
   * 输入: row = [0,2,1,3]
   * <p>
   * 输出: 1
   * <p>
   * 解释: 只需要交换row[1]和row[2]的位置即可。
   */

  private static int[] p;

  public static int minSwapsCouples(int[] row) {
    int n = row.length >> 1;
    p = new int[n];
    for (int i = 0; i < n; ++i) {
      p[i] = i;
    }
    for (int i = 0; i < n << 1; i += 2) {
      int a = row[i] >> 1, b = row[i + 1] >> 1;
      p[find(a)] = find(b);
    }
    int ans = n;
    for (int i = 0; i < n; ++i) {
      if (i == find(i)) {
        --ans;
      }
    }
    return ans;
  }

  private static int find(int x) {
    if (p[x] != x) {
      p[x] = find(p[x]);
    }
    return p[x];
  }

  public static void main(String[] args) {
    int[] row = {0, 2, 1, 3};
    log.info("情侣牵手:{}", minSwapsCouples(row));
  }
}
