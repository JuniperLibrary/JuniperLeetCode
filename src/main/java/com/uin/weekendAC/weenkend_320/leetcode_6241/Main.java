package main.java.com.uin.weekendAC.weenkend_320.leetcode_6241;

/**
 * 6241. 数组中不等三元组的数目 显示英文描述
 * 给你一个下标从 0 开始的正整数数组 nums 。请你找出并统计满足下述条件的三元组 (i, j, k) 的数目：
 * <p>
 * 0 <= i < j < k < nums.length
 * nums[i]、nums[j] 和 nums[k] 两两不同 。
 * 换句话说：nums[i] != nums[j]、nums[i] != nums[k] 且 nums[j] != nums[k] 。
 * 返回满足上述条件三元组的数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [4,4,2,4,3]
 * 输出：3
 * 解释：下面列出的三元组均满足题目条件：
 * - (0, 2, 4) 因为 4 != 2 != 3
 * - (1, 2, 4) 因为 4 != 2 != 3
 * - (2, 3, 4) 因为 2 != 4 != 3
 * 共计 3 个三元组，返回 3 。
 * 注意 (2, 0, 4) 不是有效的三元组，因为 2 > 0 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,1,1,1,1]
 * 输出：0
 * 解释：不存在满足条件的三元组，所以返回 0 。
 */
public class Main {
    public static void main(String[] args) {
//        int[] nums = {4, 4, 2, 4, 3};
        int[] nums = {1, 3, 1, 2, 4};
        System.out.println(unequalTriplets(nums));
    }

    public static int unequalTriplets(int[] nums) {
//        int left = 0, right = nums.length - 1, count = 0;
//        while (left < right) {
//            int mid = (left + right) / 2;
//            if (nums[left] != nums[right] && nums[left] != nums[mid] && nums[mid] != nums[right]) {
//                count++;
//            }
//            left++;
//        }
//        return count;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length; j++) {
                for (int k = 2; k < nums.length; k++) {
                    if (nums[i] != nums[j] && nums[i] != nums[k] && nums[k] != nums[j] && i < j && j < k && i < k) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
