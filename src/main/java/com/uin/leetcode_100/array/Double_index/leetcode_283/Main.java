package com.uin.leetcode_100.array.Double_index.leetcode_283;

/**
 * 283.将数字零移动到数组末尾
 */
public class Main {

    public static void main(String[] args) {
        int[] nums = {847, 847, 0, 0, 0, 399, 416, 416, 879, 879, 206, 206, 206, 272};
        moveZeroes(nums);
        for (int num : nums) {
            System.out.print(num + ",");
        }
    }

    public static void moveZeroes(int[] nums) {
        int n = nums.length, left = 0, right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;

                left++;
            }
            right++;
        }
    }
}
