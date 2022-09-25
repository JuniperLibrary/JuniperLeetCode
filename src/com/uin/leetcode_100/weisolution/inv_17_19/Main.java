package com.uin.leetcode_100.weisolution.inv_17_19;

/**
 * 面试题 17.19. 消失的两个数字
 * 给定一个数组，包含从 1 到 N 所有的整数，但其中缺了两个数字。你能在 O(N) 时间内只用 O(1) 的空间找到它们吗？
 * <p>
 * 以任意顺序返回这两个数字均可。
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(missingTwo(nums));
    }

    public static int[] missingTwo(int[] nums) {
        // 记录结果
        int[] res = new int[2];
        // 记录每一个数出现的次数的数组
        int[] count = new int[nums.length + 3];
        // 记录找到的数的个数
        int idx = 0;
        // 得到每一个数出现的次数
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }
        for (int i = 1; i <= nums.length + 2; i++) {
            // 找到了两个数，跳出循环
            if (idx >= 2) {
                break;
            }
            // 当前数字没有出现，并且还没有找到两个数字，记录一次结果
            if (count[i] == 0 && idx < 2) {
                res[idx++] = i;
            }
        }
        // 如果从头到尾都没有找到数字，那么这两个数字是最后两个数字
        if (res[0] == 0) {
            return new int[]{nums.length + 1, nums.length + 2};
        }
        return res;
    }
}
