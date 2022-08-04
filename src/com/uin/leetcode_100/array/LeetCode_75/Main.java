package com.uin.leetcode_100.array.LeetCode_75;

public class Main {
    public void colorSort(int[] nums) {
        //双指针
        int left = 0;
        int right = nums.length - 1;
        //移动的指针
        int i = 0;
        while (i <= right) {
            if (nums[i] == 0) {
                swap(nums, left, i);
                i++;
                left++;
            } else if (nums[i] == 2) {
                swap(nums, right, i);
                //i++ 有可能换回来的是0 所以不能i++
                right--;
            } else {
                i++;
            }
        }
    }

    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
