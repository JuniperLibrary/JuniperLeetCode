package com.uin.dewu;

import java.util.Scanner;

public class Main1 {
  public static int gcd(int a, int b) {
    if (b == 0) {
      return a;
    }
    return gcd(b, a % b);
  }

  public static boolean isPrimRoot(int x, int p) {
    if (gcd(x, p) != 1) {
      return false;
    }

    int phi = p - 1;
    for (int i = 1; i <= phi; i++) {

      if (power(x, i, p) == 1) {
        return i == phi;
      }
    }
    return false;
  }

  public static int power(int x, int y, int p) {
    int result = 1;
    x = x % p;

    while (y > 0) {
      if ((y & 1) == 1) {
        result = (result * x) % p;
      }
      y = y >> 1;
      x = (x * x) % p;
    }
    return result;
  }

  public static int countPrimRoots(int p) {
    int primRootsCount = 0;
    for (int x = 1; x < p; x++) {
      if (isPrimRoot(x, p)) {
        primRootsCount++;
      }
    }
    return primRootsCount;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    for (int i = 0; i < t; i++) {
      int p = sc.nextInt();
      int result = countPrimRoots(p);
      System.out.println(result);
    }
  }
}
