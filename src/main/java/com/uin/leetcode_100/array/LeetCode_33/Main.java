package main.java.com.uin.leetcode_100.array.LeetCode_33;

/**
 * LeetCode 33 搜索旋转排序数组
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，
 * 使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。
 * 例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为[4,5,6,7,0,1,2] 。
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回-1。
 * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
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
        int mid = left + (right - left) / 2;
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
