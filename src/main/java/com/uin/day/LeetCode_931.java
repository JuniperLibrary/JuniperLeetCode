package com.uin.day;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author dingchuan
 */
public class LeetCode_931 {

  private static Map<Integer, Integer> map = new HashMap<>();

  public static void main(String[] args) {
    System.out.println(minFallingPathSum(new int[][]{{2, 1, 3}, {6, 5, 4}, {7, 8, 9}}));
  }

  public static int minFallingPathSum(int[][] matrix) {
    int ans = Integer.MAX_VALUE;
    for (int i = 0; i < matrix[0].length; i++) {
      ans = Math.min(ans, dfs(matrix, 0, i));
    }
    return ans;
  }

  private static int dfs(int[][] matrix, int i, int j) {
    if (i < 0 || j < 0 || i >= matrix.length || j > matrix[0].length) {
      return 0;
    }
    int key = i * 100 + j;
    if (map.containsKey(key)) {
      return map.get(key);
    }
    int a = j != 0 ? matrix[i][j] + dfs(matrix, i + 1, j - 1) : Integer.MAX_VALUE;
    int b = matrix[i][j] + dfs(matrix, i + 1, j);
    int c = j != matrix[0].length - 1 ? matrix[i][j] + dfs(matrix, i + 1, j + 1) : Integer.MAX_VALUE;
    int ans = Math.min(Math.min(a, b), c);
    map.put(key, ans);
    return ans;
  }

  public static int solution(int[][] matrix) {
    int n = matrix.length;
    int[][] dp = new int[n][n];
    System.arraycopy(matrix[0], 0, dp[0], 0, n);
    for (int i = 1; i < n; i++) {
      for (int j = 0; j < n; j++) {
        int mn = dp[i - 1][j];
        if (j > 0) {
          mn = Math.min(mn, dp[i - 1][j - 1]);
        }
        if (j < n - 1) {
          mn = Math.min(mn, dp[i - 1][j + 1]);
        }
        dp[i][j] = mn + matrix[i][j];
      }
    }
    return Arrays.stream(dp[n - 1]).min().getAsInt();
  }
}
