package com.T;

import java.util.*;

public class Main3 {

  static final int MOD = 1000000007;

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = scanner.nextInt();
    }
    int result = countWays(n, a);
    System.out.println(result);
  }

  public static int countWays(int n, int[] a) {
    int totalSum = 0;
    for (int num : a) {
      totalSum += num;
    }

    int[][] dp = new int[n + 1][totalSum + 1];
    dp[0][0] = 1;

    for (int i = 1; i <= n; i++) {
      for (int j = 0; j <= totalSum; j++) {
        for (int k = 1; k <= 9; k++) {
          if (k != 6 && j >= k) {
            dp[i][j] = (dp[i][j] + dp[i - 1][j - k]) % MOD;
          }
          if (k == 6 && j >= k) {
            dp[i][j] = (dp[i][j] + dp[i - 1][j - k]) % MOD;
          }
        }
      }
    }

    return dp[n][totalSum];
  }
}
