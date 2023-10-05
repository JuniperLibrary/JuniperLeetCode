package com.uin.leetcode_100.greedy.leetcode_1775;

import java.util.Arrays;

/**
 * 1775.通过最少操作次数使数组的和相等
 * 给你两个长度可能不等的整数数组 nums1 和 nums2 。两个数组中的所有值都在 1 到 6 之间（包含 1 和 6）。
 * 每次操作中，你可以选择 任意 数组中的任意一个整数，将它变成 1 到 6 之间 任意 的值（包含 1 和 6）。
 * 请你返回使 nums1 中所有数的和与 nums2 中所有数的和相等的最少操作次数。如果无法使两个数组的和相等，请返回 -1 。
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,3,4,5,6], nums2 = [1,1,2,2,2,2]
 * 输出：3
 * 解释：你可以通过 3 次操作使 nums1 中所有数的和与 nums2 中所有数的和相等。以下数组下标都从 0 开始。
 * - 将 nums2[0] 变为 6 。 nums1 = [1,2,3,4,5,6], nums2 = [6,1,2,2,2,2] 。
 * - 将 nums1[5] 变为 1 。 nums1 = [1,2,3,4,5,1], nums2 = [6,1,2,2,2,2] 。
 * - 将 nums1[2] 变为 2 。 nums1 = [1,2,2,4,5,1], nums2 = [6,1,2,2,2,2] 。
 * 示例 2：
 * <p>
 * 输入：nums1 = [1,1,1,1,1,1,1], nums2 = [6]
 * 输出：-1
 * 解释：没有办法减少 nums1 的和或者增加 nums2 的和使二者相等。
 * 示例 3：
 * <p>
 * 输入：nums1 = [6,6], nums2 = [1]
 * 输出：3
 * 解释：你可以通过 3 次操作使 nums1 中所有数的和与 nums2 中所有数的和相等。以下数组下标都从 0 开始。
 * - 将 nums1[0] 变为 2 。 nums1 = [2,6], nums2 = [1] 。
 * - 将 nums1[1] 变为 2 。 nums1 = [2,2], nums2 = [1] 。
 * - 将 nums2[0] 变为 4 。 nums1 = [2,2], nums2 = [4] 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums1.length, nums2.length <= 105
 * 1 <= nums1[i], nums2[i] <= 6
 */
public class Main {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5, 6}, nums2 = {1, 1, 2, 2, 2, 2};

    }

    /**
     * @param nums1
     * @param nums2
     * @return 返回两个数组和相等的最少操作次数
     */
    public int minOperations(int[] nums1, int[] nums2) {
        // 两个数组的值都在1-6区间
        int sum1 = Arrays.stream(nums1).sum();
        int sum2 = Arrays.stream(nums1).sum();
        if (sum1 < sum2) {
            return minOperations(nums2, nums1);
        }
        int ans = 0;

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = nums1.length - 1, j = 0;
        while (sum1 != sum2) {
            int diff = sum1 - sum2;
            int l = -1, r = -1;
            if (i >= 0 && nums1[i] != 1) {
                l = nums1[i] - 1;
            }

            if (j < nums2.length && nums2[j] != 6) {
                r = 6 - nums2[j];
            }

            if (l == -1 && r == -1) return -1;

            if (l >= r) {
                if (diff > l) {
                    sum1 -= nums1[i] - 1;
                } else {
                    sum1 = sum2;
                }
                i--;
            } else {
                if (diff > r) {
                    sum2 += 6 - nums2[j];
                } else {
                    sum2 = sum1;
                }
                j++;
            }
            ans++;
        }
        return sum1 == sum2 ? ans : -1;
    }
}
