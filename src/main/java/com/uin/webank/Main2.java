package main.java.com.uin.webank;

import java.util.Scanner;

public class Main2 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int k = scanner.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scanner.nextInt();
    }

    boolean isPossible = false;
    int u = -1, v = -1;

    for (int i = 0; i <= n - k; i++) {
      int[] subArray = new int[k];
      System.arraycopy(arr, i, subArray, 0, k);
      if (isPermutation(subArray)) {
        isPossible = true;
        u = i + 1;
        v = i + k;
        break;
      }
    }

    if (isPossible) {
      System.out.println("Yes");
      System.out.println(u);
      System.out.println(u + " " + v);
    } else {
      System.out.println("No");
    }
  }

  private static boolean isPermutation(int[] arr) {
    int n = arr.length;
    boolean[] visited = new boolean[n];
    for (int i = 0; i < n; i++) {
      int num = arr[i];
      if (num < 1 || num > n || visited[num - 1]) {
        return false;
      }
      visited[num - 1] = true;
    }
    return true;
  }
}
