package com.uin.leetcode_100.Binarysearch.leetcode_4;

/**
 * 4. 寻找两个正序数组的中位数
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组nums1 和nums2。请你找出并返回这两个正序数组的 中位数 。
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 */
public class Main {
    /**
     * 合并数组 找中位数
     *
     * @param nums1
     * @param nums2
     * @return double
     * @author wanglufei
     * @date 2022/9/8 1:21 PM
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums;
        int m = nums1.length;
        int n = nums2.length;

        nums = new int[m + n];

        if (m == 0) {
            if (n % 2 == 0) {
                return (nums2[n / 2 - 1] + nums2[n / 2]) / 2.0;
            } else {
                return nums2[n / 2];
            }
        }

        if (n == 0) {
            if (m % 2 == 0) {
                return (nums1[m / 2 - 1] + nums1[m / 2]) / 2.0;
            } else {
                return nums1[m / 2];
            }
        }

        int count = 0;
        int i = 0, j = 0;
        while (count != (m + n)) {
            if (i == m) {
                while (j != n) {
                    nums[count++] = nums2[j++];
                }
                break;
            }
            if (j == n) {
                while (i != m) {
                    nums[count++] = nums1[i++];
                }
                break;
            }

            if (nums1[i] < nums[j]) {
                nums[count++] = nums1[i++];
            } else {
                nums[count++] = nums2[j++];
            }
        }

        if (count % 2 == 0) {
            return (nums[count / 2 - 1] + nums[count / 2]) / 2.0;
        } else {
            return nums[count / 2];
        }
    }


    public double helper(int[] nums1, int[] nums2) {
        int[] num3 = new int[nums1.length + nums2.length];
        int start1 = 0, start2 = 0;
        for (int i = 0; i < num3.length; i++) {
            if (start1 < nums1.length && start2 < nums2.length)
                if (nums1[start1] < nums2[start2]) {
                    num3[i] = nums1[start1++];
                } else {
                    num3[i] = nums2[start2++];
                }
            else {
                if (start1 < nums1.length) {
                    num3[i] = nums1[start1++];
                } else {
                    num3[i] = nums2[start2++];
                }
            }
        }
        if (num3.length % 2 == 0) {//偶数个，中位数取中间两个数的平均
            return (num3[(num3.length / 2)] + num3[(num3.length / 2 - 1)]) / 2.0;
        } else {  //基数个，中位数等于中间元素
            return num3[(num3.length / 2)];
        }
    }
}
