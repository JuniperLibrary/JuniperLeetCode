package com.weekendAC.weenkend_328.leetcode_6291;

import java.util.Arrays;

/**
 * 6291. 数组元素和与数字和的绝对差
 * 给你一个正整数数组 nums 。
 * <p>
 * 元素和 是 nums 中的所有元素相加求和。
 * 数字和 是 nums 中每一个元素的每一数位（重复数位需多次求和）相加求和。
 * 返回 元素和 与 数字和 的绝对差。
 * <p>
 * 注意：两个整数 x 和 y 的绝对差定义为 |x - y| 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,15,6,3]
 * 输出：9
 * 解释：
 * nums 的元素和是 1 + 15 + 6 + 3 = 25 。
 * nums 的数字和是 1 + 1 + 5 + 6 + 3 = 16 。
 * 元素和与数字和的绝对差是 |25 - 16| = 9 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：0
 * 解释：
 * nums 的元素和是 1 + 2 + 3 + 4 = 10 。
 * nums 的数字和是 1 + 2 + 3 + 4 = 10 。
 * 元素和与数字和的绝对差是 |10 - 10| = 0 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 2000
 * 1 <= nums[i] <= 2000
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(differenceOfSum(new int[]{1, 2, 3, 4}));
    }

    public static int differenceOfSum(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int digitSum = 0;
        for (int num : nums) {
//            if (num / 10 < 1) {
//                digitSum += num;
//            } else {
//                char[] chars = String.valueOf(num).toCharArray();
//                for (char aChar : chars) {
//                    digitSum += aChar - '0';
//                }
//            }
            while (num > 0) {
                digitSum += num % 10;
                num /= 10;
            }

        }
        return Math.abs(sum - digitSum);
    }
}
