package com.uin.day;

import java.util.ArrayList;

public class main {

  public static void main(String[] args) {
    System.out.println(kInArray(1, 2));
  }

  public static boolean kInArray(int k, int target) {
    // write code here
    int left = Math.abs(k * 2 + 1);
    int right = Math.abs(k * 3 + 1);
    ArrayList<Integer> integers = new ArrayList<>();

    while (left <= right) {
      integers.add(left++);
    }
    return integers.contains(target);
  }
}
