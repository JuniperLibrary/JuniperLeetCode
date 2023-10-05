package com.uin.leetcode_100.dp.int_17_09;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * 面试题 17.09. 第 k 个数
 * 有些数的素因子只有 3，5，7，请设计一个算法找出第 k 个数。注意，不是必须有这些素因子，而是必须不包含其他的素因子。例如，前几个数按顺序应该是 1，3，5，7，9，15，21。
 * <p>
 * 示例 1:
 * <p>
 * 输入: k = 5
 * <p>
 * 输出: 9
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(dp_helper(5));
    }

    /**
     * 最小堆
     *
     * @param k
     * @return int
     * @author wanglufei
     * @date 2022/9/28 9:14 AM
     */
    public static int getKthMagicNumber(int k) {
        int[] factors = {3, 5, 7};
        Set<Long> set = new HashSet<>();
        Queue<Long> heap = new PriorityQueue<>();

        set.add(1L);
        heap.offer(1L);
        int ugly = 0;

        for (int i = 0; i < k; i++) {
            long cur = heap.poll();
            ugly = (int) cur;
            for (int factor : factors) {
                long next = cur * factor;
                if (set.add(next)) {
                    heap.offer(next);
                }
            }
        }
        return ugly;
    }

    public static int dp_helper(int k) {
        int[] dp = new int[k + 1];
        dp[1] = 1;
        int p3 = 1, p5 = 1, p7 = 1;
        for (int i = 2; i <= k; i++) {
            int num3 = dp[p3] * 3, num5 = dp[p5] * 5, num7 = dp[p7] * 7;
            dp[i] = Math.min(Math.min(num3, num5), num7);
            if (dp[i] == num3) {
                p3++;
            }
            if (dp[i] == num5) {
                p5++;
            }
            if (dp[i] == num7) {
                p7++;
            }
        }
        return dp[k];
    }
}
