package com.uin.leetcode_100.dp.leetcode_1235;

import java.util.Arrays;

/**
 * 1235.规划兼职找工作
 * 你打算利用空闲时间来做兼职工作赚些零花钱。
 * <p>
 * 这里有n份兼职工作，每份工作预计从startTime[i]开始到endTime[i]结束，报酬为profit[i]。
 * <p>
 * 给你一份兼职工作表，包含开始时间startTime，结束时间endTime和预计报酬profit三个数组，请你计算并返回可以获得的最大报酬。
 * <p>
 * 注意，时间上出现重叠的 2 份工作不能同时进行。
 * <p>
 * 如果你选择的工作在时间X结束，那么你可以立刻进行在时间X开始的下一份工作。
 * <p>
 * <p>
 * 输入：startTime = [1,2,3,3], endTime = [3,4,5,6], profit = [50,10,40,70]
 * 输出：120
 * 解释：
 * 我们选出第 1 份和第 4 份工作，
 * 时间范围是 [1-3]+[3-6]，共获得报酬 120 = 50 + 70。
 */
public class Main {
    public static void main(String[] args) {
        int[] startTime = {1, 2, 3, 3}, endTime = {3, 4, 5, 6}, profit = {50, 10, 40, 70};
    }

    /**
     * 二分+动态规划：
     * 首先按照开始时间排序每个工作，对于每个工作的开始时间t1，从t1开始工作的最大收入等于最早从它的结束时间t2开始工作的最大收入加上这份工作的收入
     * （当然计算出的结果，还要与下一个比t1稍晚一点开始工作的收入比较大小），查找最早开始时间的过程可以利用二分搜索
     *
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @param profit    利润
     * @return 返回获得最大的报酬
     */
    public static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] jobs = new int[n][];

        for (int i = 0; i < n; i++) {
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }

        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);

        // ans[i] 表示的是最晚从jobs[i][0]开始兼职可以最多得到多少钱
        int[] ans = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            if (jobs[i][1] <= jobs[n - 1][0]) {
                int l = i + 1, r = n - 1;
                while (l < r) {
                    int mid = (l + r) >> 1;
                    if (jobs[mid][0] >= jobs[i][1]) {
                        r = mid;
                    } else {
                        l = mid + 1;
                    }
                    if (l == r) {
                        if (jobs[l][0] >= jobs[i][1]) {
                            r = l;
                        }
                        break;
                    }
                }
                ans[i] = jobs[i][2] + ans[r];
            } else {
                // 只能做一份工作
                ans[i] = jobs[i][2];
            }
            if (i < n - 1) {
                ans[i] = Math.max(ans[i], ans[i + 1]);
            }
        }
        return ans[0];
    }

    public static int helper(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] jobs = new int[n][];
        for (int i = 0; i < n; i++) {
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        Arrays.sort(jobs, (a, b) -> a[1] - b[1]);
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int k = binarySearch(jobs, i - 1, jobs[i - 1][0]);
            dp[i] = Math.max(dp[i - 1], dp[k] + jobs[i - 1][2]);
        }
        return dp[n];
    }

    private static int binarySearch(int[][] jobs, int right, int target) {
        int left = 0;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (jobs[mid][1] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
