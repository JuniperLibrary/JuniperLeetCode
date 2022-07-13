package com.uin.LeetCode_100.array.LeetCode_560.preSum;

/**
 * LeetCode 724 寻找数组的中心索引
 *
 * @author wanglufei
 * @date 2022/7/13 2:34 PM
 */
public class LeetCode_724 {
    public static void main(String[] args) {
        int[] nums = {1, 7, 3, 6, 5, 6};
        System.out.println(solution(nums));
    }

    public static int solution(int[] nums) {
        int preSum = 0;
        //数组求和
        for (int num : nums) {
            preSum += num;
        }
        int leftSum = 0;
        //第二次遍历的时候，直接进行对比左半部分和右半部分是否相同
        for (int i = 0; i < nums.length; i++) {
            if (leftSum == preSum - nums[i] - leftSum)
                return i;
            leftSum += nums[i];
        }
        return -1;
    }
}
