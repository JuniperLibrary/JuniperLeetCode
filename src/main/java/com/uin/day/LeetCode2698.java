package com.uin.day;

import lombok.extern.slf4j.Slf4j;

/**
 * 2698. 求一个整数的惩罚数
 * <p>
 * 给你一个正整数 n  请你返回n的惩罚数
 * <p>
 * 1 <= i <= n
 * <p>
 * i * i 的十进制 的字符串可以分割成若干个 连续字符串  且这些字符串对应的数值之和 等于 i
 * <p>
 * <p>
 * 输入：n = 10
 * <p>
 * 输出：182
 * <p>
 * 解释：总共有 3 个整数 i 满足要求：
 * <p>
 * - 1 ，因为 1 * 1 = 1
 * <p>
 * - 9 ，因为 9 * 9 = 81 ，且 81 可以分割成 8 + 1 。
 * <p>
 * - 10 ，因为 10 * 10 = 100 ，且 100 可以分割成 10 + 0 。
 * <p>
 * 因此，10 的惩罚数为 1 + 81 + 100 = 182
 */
@Slf4j
public class LeetCode2698 {

  public static void main(String[] args) {
    log.info("求一个整数的惩罚数:{}",punishmentNumber(10));
  }

  public static int punishmentNumber(int n) {
    int ans = 0;
    for (int i = 1; i <= n; i++) {
      int x = i * i;
      if (checkSum(x + "", 0, i)) {
        ans += x;
      }
    }
    return ans;
  }

  /**
   * 且这些字符串对应的数值之和 等于 i
   *
   * @param s i * i的结果
   * @param i
   * @param x i
   * @return
   */
  private static boolean checkSum(String s, int i, int x) {
    int m = s.length();
    if (i >= m) {
      return x == 0;
    }
    int y = 0;
    for (int j = i; j < m; j++) {
      y = y * 10 + (s.charAt(j) - '0');
      if (y>x){
        break;
      }
      if (checkSum(s,j+1,x-y)){
        return true;
      }
    }
    return false;
  }
}
