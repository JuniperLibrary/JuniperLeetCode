package main.java.com.uin.T;

import java.util.Scanner;

public class Main2 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    for (int i = 0; i < t; i++) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      int[] arr = new int[n];
      for (int j = 0; j < n; j++) {
        arr[j] = sc.nextInt();
      }
      for (int j = 0; j < k; j++) {
        int u = sc.nextInt();
        int v = sc.nextInt();
        arr[u - 1] += 1;
        arr[v - 1] -= 1;
      }
      for (int j = 0; j < n; j++) {
        if (arr[j] < 0) {
          arr[j] = 0;
        }
      }
      if (checkNonDecreasing(arr)) {
        System.out.println("Yes");
      } else {
        System.out.println("No");
      }
    }
  }

  public static boolean checkNonDecreasing(int[] arr) {
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] < arr[i - 1]) {
        return false;
      }
    }
    return true;
  }
}
