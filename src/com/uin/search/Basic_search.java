package com.uin.search;

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
