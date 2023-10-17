package com.uin.day;

/**
 * 2562 倍数求和
 *
 * @author lin.liu
 */

public class LeetCode2652 {

  public int sumOfMultiples(int n) {
    int ans = 0;
    for (int i = 1; i <= n; i++) {
      if (i % 3 == 0 || i % 5 == 0 || i % 7 == 0) {
        ans += i;
      }
    }
    return ans;
  }

  public int sumOfMultiples2(int n) {
    return f(n, 3) + f(n, 5) + f(n, 7) - f(n, 3 * 5) - f(n, 3 * 7) - f(n, 5 * 7) + f(n, 3 * 5 * 7);
  }

  public int f(int n, int m) {
    return (m + n / m * m) * (n / m) / 2;
  }

}
