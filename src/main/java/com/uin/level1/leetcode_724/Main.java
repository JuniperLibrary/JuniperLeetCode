package com.uin.level1.leetcode_724;

import java.util.Arrays;
//寻找数组的中心索引
public class Main {
    public int pivotIndex(int[] nums) {
        int total = Arrays.stream(nums).sum();
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (2 * leftSum + nums[i] == total) {
                return i;
            }
            leftSum = leftSum + nums[i];
        }
        return -1;
    }
}
