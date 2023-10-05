package com.uin.oppo;

import java.util.Scanner;

public class Main2 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    draw(n);
  }

  public static void draw(int n) {
    int size = 5 * n;
    char[][] canvas = new char[size][size];

    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        int centerX = 2 * n;
        int centerY = 2 * n;
        int distanceX = Math.abs(i - centerX);
        int distanceY = Math.abs(j - centerY);

        if (distanceX <= n && distanceY <= n) {
          if (distanceX == n || distanceY == n) {
            canvas[i][j] = '*';
          } else {
            canvas[i][j] = 'O';
          }
        } else {
          canvas[i][j] = '.';
        }
      }
    }

    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        System.out.print(canvas[i][j]);
      }
      System.out.println();
    }
  }
}
