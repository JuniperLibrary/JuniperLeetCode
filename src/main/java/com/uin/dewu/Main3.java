package main.java.com.uin.dewu;

import java.util.Arrays;
import java.util.Scanner;

public class Main3 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] heights = new int[n];

    for (int i = 0; i < n; i++) {
      heights[i] = sc.nextInt();
    }

    int result = findMaxHeightDiff(heights, n);
    System.out.println(result);
  }

  public static int findMaxHeightDiff(int[] heights, int n) {
    Arrays.sort(heights);
    int left = 0;
    int right = heights[n - 1] - heights[0];

    while (left < right) {
      int mid = left + (right - left + 1) / 2;
      if (isValid(heights, n, mid)) {
        left = mid;
      } else {
        right = mid - 1;
      }
    }

    return left;
  }

  public static boolean isValid(int[] heights, int n, int maxDiff) {
    int count = 1; // 计数器
    int start = 0;

    for (int i = 1; i < n; i++) {
      if (heights[i] - heights[start] > maxDiff) {
        start = i;
        count++;
      }
    }

    return count <= 3;
  }
}
