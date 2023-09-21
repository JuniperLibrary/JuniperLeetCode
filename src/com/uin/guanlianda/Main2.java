package com.uin.guanlianda;

import java.util.Scanner;

public class Main2 {

  /*
  4
    1 2 3 4
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int[] soldiers = new int[n];

    for (int i = 0; i < n; i++) {
      soldiers[i] = scanner.nextInt();
    }

    int result = minCopyOperations(soldiers);
    System.out.println(result);
  }

  public static int minCopyOperations(int[] soldiers) {
    int n = soldiers.length;
    int minOperations = n;
    int num = 1;

    // 从后往前遍历士兵
    for (int i = n - 1; i >= 0; i--) {
      if (soldiers[i] != soldiers[n - 1]) {
        minOperations = Math.min(minOperations, num);
      }
      num *= 2;
    }

    return minOperations;
  }
}

