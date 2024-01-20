package com.uin.day;

import java.util.Arrays;

/**
 * @author dingchuan
 */
public class LC2171 {
  public static long minimumRemoval(int[] beans) {
    Arrays.sort(beans);
    int sum = 0,max=0;
    int n=beans.length;
    for (int i = 0; i < n; i++) {
      sum +=beans[i];
      max = Math.max(max,beans[i]*(n-i));
    }
    return sum-max;
  }

  public static void main(String[] args) {
    int[] beans ={4,1,5,6};
    System.out.println(minimumRemoval(beans));
  }
}
