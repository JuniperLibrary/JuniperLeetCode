package com.uin.leetcode_100.dp.leetcode_1664;

/**
 * 1664. 生成平衡数组的方案数
 */
public class Main {
    public static void main(String[] args) {
        waysToMakeFair(new int[]{6, 1, 7, 4, 1});
    }

    public static int waysToMakeFair(int[] nums) {
        // 你需要恰好选择一个下标 并删除对应的元素
        // 请注意剩下元素的下标可能会因为删除操作而发生改变。
        // 6,1,7,4,1
        // 6,7,4,1
        // 6,1,4,1
        // 6,1,7,4

        // 如果一个数组满足奇数下标元素的和与偶数下标元素的和相等，该数组就是一个 平衡数组

        // 请你返回删除操作后，剩下的数组 nums 是 平衡数组 的 方案数 。

        // 是s1 偶数之后 s2 奇数和
        // 从后遍历nums的每个元素v，用变量 t1 和 t2 分别记录已遍历的偶数下表元素之和 以及奇数下标元素之和
        // 对于遍历的当前元素v，如果我们删除了，那么该元素之后的奇偶下标之和就会发生变化
        // 此时，我们先判断该位置下标i是奇数还是偶数
        // - 如果i原来是偶数下标，删除之后 数组奇数下标元素之和 t2+s1-t1-v 偶数下标之和t1 +s2-t2
        // - 如果是i原来是奇数下表，删除之后，数组偶数下标元素之和t1+s2-t2-v 偶数下表元素之和 t2+s1-t1
        // 然后根据下标的奇偶性 更新t1和t2

        int n = nums.length;
        int s1 = 0, s2 = 0;

        for (int i = 0; i < n; i++) {
            s1 += i % 2 == 0 ? nums[i] : 0;
            s2 += i % 2 == 0 ? 0 : nums[i];
        }

        int t1 = 0, t2 = 0;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            int v = nums[i];
            ans += i % 2 == 0 && t2 + s1 - t1 - v == t1 + s2 - t2 ? 1 : 0;
            ans += i % 2 == 1 && t1 + s2 - t2 - v == t2 + s1 - t1 ? 1 : 0;
            t1 += i % 2 == 0 ? v : 0;
            t2 += i % 2 == 1 ? v : 0;
        }
        return ans;
    }
}
