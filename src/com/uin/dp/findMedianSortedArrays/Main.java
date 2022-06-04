package com.uin.dp.findMedianSortedArrays;

/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * <p>
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 *
 * @author wanglufei
 * @date 2022/5/30 10:30 PM
 */
public class Main {
    public static void main(String[] args) {
        int nums1[] = {1, 3};
        int nums2[] = {2};

        int i = nums1.length;
        int j = nums2.length;
        int left = (i + j + 1) / 2;
        int right = (i + j + 1) / 2;

        //solution(nums1, i, nums2, j, k);
    }

    public static double solution(int nums1[], int i, int nums2[], int j, int k) {
        if (i >= nums1.length) return nums2[j + k - 1];//nums1为空数组
        if (j >= nums2.length) return nums1[i + k - 1];//nums2为空数组
        if (k == 1) {
            return Math.min(nums1[i], nums2[j]);
        }
        int midVal1 = (i + k / 2 - 1 < nums1.length) ? nums1[i + k / 2 - 1] : Integer.MAX_VALUE;
        int midVal2 = (j + k / 2 - 1 < nums2.length) ? nums2[j + k / 2 - 1] : Integer.MAX_VALUE;
        if (midVal1 < midVal2) {
            return solution(nums1, i + k / 2, nums2, j, k - k / 2);
        } else {
            return solution(nums1, i, nums2, j + k / 2, k - k / 2);
        }
    }


}
