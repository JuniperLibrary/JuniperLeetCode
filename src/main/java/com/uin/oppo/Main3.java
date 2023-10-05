package com.uin.oppo;

import java.util.Date;
import java.util.Scanner;

public class Main3 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String inputStr = scanner.nextLine();
    long result = solution(inputStr);
    System.out.println(result);
    System.out.println(new Date());
  }
  public static long solution(String s){
    int n = s.length();
    int[] dp = new int[n];
    long totalWeight = 0;
    int oppoCount = 0;

    for (int i = 0; i < n; i++) {
      if (s.charAt(i) == 'o') {
        oppoCount++;
      } else if (s.charAt(i) == 'p') {
        totalWeight += oppoCount;
      }
    }
    for (int i = 3; i < n; i++) {
      if (s.charAt(i) == 'o' && s.charAt(i - 1) == 'p' && s.charAt(i - 2) == 'p' && s.charAt(i - 3) == 'o') {
        dp[i] = dp[i - 1] + 1;
      }
      totalWeight += dp[i];
    }
    return totalWeight;
  }
}
