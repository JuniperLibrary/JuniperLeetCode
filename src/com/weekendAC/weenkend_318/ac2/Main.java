package com.weekendAC.weenkend_318.ac2;

import java.util.HashSet;

/**
 * 6230. 长度为 K 子数组中的最大和
 * 通过的用户数0
 * 尝试过的用户数0
 * 用户总通过次数0
 * 用户总提交次数0
 * 题目难度Medium4
 * 给你一个整数数组 nums 和一个整数 k 。请你从 nums 中满足下述条件的全部子数组中找出最大子数组和：
 * <p>
 * 子数组的长度是 k，且
 * 子数组中的所有元素 各不相同 。
 * 返回满足题面要求的最大子数组和。如果不存在子数组满足这些条件，返回 0 。
 * <p>
 * 子数组 是数组中一段连续非空的元素序列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,5,4,2,9,9,9], k = 3
 * 输出：15
 * 解释：nums 中长度为 3 的子数组是：
 * - [1,5,4] 满足全部条件，和为 10 。
 * - [5,4,2] 满足全部条件，和为 11 。
 * - [4,2,9] 满足全部条件，和为 15 。
 * - [2,9,9] 不满足全部条件，因为元素 9 出现重复。
 * - [9,9,9] 不满足全部条件，因为元素 9 出现重复。
 * 因为 15 是满足全部条件的所有子数组中的最大子数组和，所以返回 15 。
 * 示例 2：
 * <p>
 * 输入：nums = [4,4,4], k = 3
 * 输出：0
 * 解释：nums 中长度为 3 的子数组是：
 * - [4,4,4] 不满足全部条件，因为元素 4 出现重复。
 * 因为不存在满足全部条件的子数组，所以返回 0 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= nums.length <= 105
 * 1 <= nums[i] <= 105
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 5, 4, 2, 9, 9, 9};
        int k = 3;
        System.out.println(maximumSubarraySum(nums, k));
    }

    public static long maximumSubarraySum(int[] nums, int k) {
        int left = 0,right = 0,i = 0,len = nums.length;
        long max = 0,tmp = 0;
        HashSet<Integer> set = new HashSet<>();
        while(i < len){
            if(set.contains(nums[i])){
                if(nums[i] == nums[left])
                    left++;
                else {
                    left = i;
                    set.clear();
                    set.add(nums[i]);
                    tmp = nums[i];
                }
            }else {
                tmp += nums[i];
                set.add(nums[i]);
            }
            right = i;
            if(right - left +1== k ) {
                max = Math.max(max,tmp);
                tmp -= nums[left];
                set.remove(nums[left]);
                left++;
            }
            i++;
        }

        return max;
    }
}
