package com.uin.leetcode_100.array.LeetCode_55;

public class Solution {
    public boolean canJump(int[] nums) {
        //[2,3,1,1,4]
        //能跳多远 维护的max的一个变量
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            //如果当前的位置已经大于max
            if (i > max) return false;
            //先拿到当前这个位置最远 能跳哪里
            int curr = i + nums[i];
            //根据max 和 当前的位置 选出来一个最大的
            max = Math.max(max, curr);
        }
        //如果跳最远的距离大于等于数组的最后的位置 说明可以跳的到
        return max >= nums.length - 1;
    }
}
