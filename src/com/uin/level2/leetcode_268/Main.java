package com.uin.level2.leetcode_268;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 268. 丢失的数字
 * 给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
 */
public class Main {
    /**
     * 遍历
     *
     * @param nums
     * @return int
     * @author wanglufei
     * @date 2022/9/16 9:49 AM
     */
    public int missingNumber(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            if (i != nums[i]) {
                return i;
            }
        }
        return n;
    }

    /**
     * 哈希集合
     *
     * @param nums
     * @return int
     * @author wanglufei
     * @date 2022/9/16 9:49 AM
     */
    public int helper(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
        }
        int miss = -1;
        for (int i = 0; i <= n; i++) {
            if (!set.contains(i)) {
                miss = i;
                break;
            }
        }
        return miss;
    }
}
