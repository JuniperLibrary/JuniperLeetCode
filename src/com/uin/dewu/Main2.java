package com.uin.dewu;

import java.util.*;

public class Main2 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] heights = new int[n];

    for (int i = 0; i < n; i++) {
      heights[i] = sc.nextInt();
    }

    Arrays.sort(heights);
    int result = findMinHeightDiff(heights, n);
    System.out.println(result);
  }

  public static int findMinHeightDiff(int[] heights, int n) {
    int left = 0;
    // 上限
    int right = 1_000_000_000;
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (isValid(heights, n, mid)) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    return left;
  }

  public static boolean isValid(int[] heights, int n, int maxDiff) {
    int minHeight = heights[0];
    int maxHeight = heights[0];

    for (int i = 1; i < n; i++) {
      minHeight = Math.min(minHeight + maxDiff, heights[i]);
      maxHeight = Math.max(maxHeight, heights[i]);
      if (minHeight > maxHeight) {
        return false;
      }
    }
    return (maxHeight - minHeight) <= maxDiff;
  }
}
