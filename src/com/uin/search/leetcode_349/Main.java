package com.uin.search.leetcode_349;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 349. 两个数组的交集
 * 给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
 */
public class Main {
    /**
     * 排序+双指针
     *
     * @param nums1
     * @param nums2
     * @return int[]
     * @author wanglufei
     * @date 2022/9/9 10:57 PM
     */
    public static int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int len1 = nums1.length;
        int len2 = nums2.length;

        int[] ans = new int[len1 + len2];

        int index = 0, index1 = 0, index2 = 0;
        while (index1 < len1 && index2 < len2) {
            int num1 = nums1[index1], num2 = nums2[index2];
            if (num1 == num2) {
                if (index == 0 || num1 != ans[index - 1]) {
                    ans[index++] = num1;
                }
                index1++;
                index2++;
            } else if (num1 < num2) {
                index1++;
            } else {
                index2++;
            }
        }
        return Arrays.copyOfRange(ans, 0, index);
    }

    /**
     * 模拟
     *
     * @param nums1
     * @param nums2
     * @return int[]
     * @author wanglufei
     * @date 2022/9/9 10:42 PM
     */
    public int[] helper(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        for (int num : nums1) {
            set1.add(num);
        }
        for (int num : nums2) {
            set2.add(num);
        }
        return solve(set1, set2);
    }

    private int[] solve(HashSet<Integer> set1, HashSet<Integer> set2) {
        if (set1.size() > set2.size()) {
            return solve(set2, set1);
        }

        HashSet<Integer> set = new HashSet<>();
        for (Integer integer : set1) {
            if (set2.contains(integer)) {
                set.add(integer);
            }
        }

        int[] ans = new int[set.size()];
        int idx = 0;
        for (int an : set) {
            ans[idx++] = an;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        System.out.println(intersection(nums1, nums2));
    }
}
