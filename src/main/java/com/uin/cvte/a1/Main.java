package com.uin.cvte.a1;

/**
 * 对一个有n个元素的数组，求最大的连续子数组的和，并求其开始、结束下标。
 * 输入:[0,2,1,4,3,5,6,7，8]
 * 输出：[0,8]
 * https://blog.csdn.net/weixin_41462047/article/details/81950705
 */
public class Main {
    public int[] solutions(int[] nums) {
        if (nums == null || nums.length == 0) return new int[]{-1, -1};
        int max = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        int cur = 0;

        for (int i = 0, j = 0; i < nums.length; i++) {
            if (cur <= 0) {
                cur = nums[i];
                j = i;
            } else {
                cur += nums[i];
            }
            if (cur > max) {
                start = j;
                end = i;
            }
        }
        return new int[]{start, end};
    }
}
