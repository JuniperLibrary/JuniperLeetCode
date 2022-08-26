package com.uin.search.leetcode_35;

/**
 * 35. 搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 请必须使用时间复杂度为 O(log n) 的算法。
 */
public class Main {
    /**
     * 迭代
     *
     * @param nums
     * @param target
     * @return int
     * @author wanglufei
     * @date 2022/8/26 9:55 PM
     */
    public int searchInsert(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return nums.length;
    }

    /**
     * 双指针
     *
     * @param nums
     * @param target
     * @return int
     * @author wanglufei
     * @date 2022/8/26 9:56 PM
     */
    public int solutionSearch(int[] nums, int target) {
        //双指针
        //nums = [1,3,5,6], target = 5  return 2
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {

            int mid = (left) + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left + 1;
    }
}
