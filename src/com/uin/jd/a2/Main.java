package com.uin.jd.a2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 嘤嘤的长城so easy
 * {2,1,2,1,2}、{1,9,1,9}是长城。对于长城一个元素的两边的元素相等，并且与他不相同
 * {2,1,3,2,4}不是长城
 * 给你一个数组，你可以每次将一个元素变成另一个元素，请问最少需要几次？
 * <p>
 * 输入：
 * 6  数组的长度
 * 1 1 4 5 1 4
 * <p>
 * 输出：
 * 3
 * <p>
 * 说明：
 * 得到的长城{1,5,1,5,1,5}
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        System.out.println(helper(nums));
    }

    public static int helper(int[] nums) {
        //conner case
        if (nums == null || nums.length == 0) return 0;
        int len = nums.length;
        int[] dp = new int[len];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = nums[i];
        }

        int count = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if (dp[j + 1] == nums[i] && nums[i]==dp[j+1]) {
                    return count;
                } else if (dp[j + 1] > nums[j]) {
                    nums[j] += 1;
                    swap(nums, i, j);
                    ++count;
                }
            }
        }
        return count;
    }

    public static void swap(int nums[], int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
