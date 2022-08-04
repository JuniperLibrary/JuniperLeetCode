package com.uin.leetcode_100.array.LeetCode_33;

/**
 * LeetCode 33 搜索旋转排序数组
 *
 * @author wanglufei
 * @date 2022/7/11 1:43 PM
 */
public class Main {
    public static void main(String[] args) {
        int nums[] = new int[]{4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        int solution = solution(nums, target);
        System.out.println(solution);
    }

    public static int solution(int nums[], int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = (left + right) / 2;
        while (left <= right) {
            if (nums[mid] == target) {
                return mid;
            }
            //4 <= 7 「 true 」 target=0
            if (nums[0] <= nums[mid]) {
                // 4 <= 0 「false」 && 7 > 0 「true」
                if (nums[0] <= target && nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = right - 1;
                }
            }
        }
        return -1;
    }
}
