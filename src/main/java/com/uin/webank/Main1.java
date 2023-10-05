package main.java.com.uin.webank;

import java.util.Scanner;

public class Main1 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int t = scanner.nextInt();

    for (int i = 0; i < t; i++) {
      int n = scanner.nextInt();
      int m = scanner.nextInt();

      if (n == 1 && m == 1) {
        System.out.println("No");
      } else if (n % 2 == 1 || m % 2 == 1) {
        System.out.println("Yes");
      } else {
        System.out.println("No");
      }
    }
  }
}
