package com.dingchuan;

import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;

/**
 * @author dingchuan
 */
@Slf4j
public class LC88 {

  public static void main(String[] args) {
    int[] nums1 = {1, 2, 3, 0, 0, 0};
    int[] nums2 = {2, 5, 6};
    int m =3;
    int n =2;
    merge(nums1,m,nums2,n);
  }

  public static void merge(int[] nums1, int m, int[] nums2, int n) {
    for (int i = 0; i < n; i++) {
      nums1[m + i] = nums2[i];
    }
    Arrays.sort(nums1);
  }

  public static void merge2(int[] nums1, int m, int[] nums2, int n) {
    // 初始化两个指针 分别指向 nums1、nums2的末尾
    int p1 = m - 1;
    int p2 = n - 1;

    // 初始化一个指针 指向nums1的末尾
    int p = m + n - 1;

    // 从后往前遍历 nums1、nums2，比较两个指针的大小 将较大的放到nums1的末尾，并将指针后移
    while (p1 >= 0 && p2 >= 0) {
      if (nums1[p1] > nums2[p2]) {
        nums1[p] = nums1[p1];
        p1--;
      } else {
        nums1[p] = nums2[p2];
        p2++;
      }
      p--;
    }

    // 如果nums2 中还有元素

    while (p2 >= 0) {
      nums1[p] = nums2[p2];
      p2--;
      p++;
    }
  }

}
