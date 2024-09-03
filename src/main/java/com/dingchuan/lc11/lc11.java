package com.dingchuan.lc11;

/**
 * 11. 盛最多水的容器
 */
public class lc11 {

  public int maxArea(int[] height) {
    int i = 0, j = height.length - 1, res = 0;
    while (i < j) {
      res = height[i] < height[j] ? Math.max(res, (j - i) * height[i++]) : Math.max(res, (j - i) * height[j--]);
    }
    return res;
  }

  public static void main(String[] args) {
    lc11 lc11 = new lc11();
    System.out.println(lc11.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
  }
}
