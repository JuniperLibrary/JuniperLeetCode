package com.day;

import java.util.Arrays;

/**
 * @author lin.liu
 */
public class LeetCode4 {

  /*
  4. Median of Two Sorted Arrays
     */
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int len1 = nums1.length;
    int len2 = nums2.length;
    int[] arr = new int[len1 + len2];
    // src , srcPos , dest ,destPos , length
    System.arraycopy(nums1, 0, arr, 0, len1);
    System.arraycopy(nums2, 0, arr, len1, len2);
    Arrays.sort(arr);
    if (arr.length % 2 == 0) {
      int right = arr.length / 2;
      int left = (arr.length / 2) - 1;
      return (double) (arr[right] + arr[left]) / 2;
    }
    int mid = arr.length / 2;
    return (double) arr[mid];
  }
}
