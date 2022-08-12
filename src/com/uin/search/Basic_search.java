package com.uin.search;

/**
 * 二分搜索
 *
 * @author wanglufei
 * @date 2022/8/12 2:48 PM
 */
public class Basic_search {
    public static void main(String[] args) {

    }

    public static int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > mid) {
                right = mid + 1;
            }
        }
        return -1;
    }
}
