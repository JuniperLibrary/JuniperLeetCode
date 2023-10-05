package main.java.com.uin.leetcode_100.greedy.leetcode_435;

import java.util.Arrays;

/**
 * 435.无重叠区间
 * 给定一个区间的集合intervals，其中 intervals[i] = [start, end]。返回 需要移除区间的最小数量，使剩余区间互不重叠。
 * 输入: intervals = [[1,2],[2,3],[3,4],[1,3]]
 * 输出: 1
 * 解释: 移除 [1,3] 后，剩下的区间没有重叠。
 */
public class Main {
    /**
     * dp
     *
     * @param intervals
     * @return int
     * @author wanglufei
     * @date 2022/9/11 10:01 AM
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        int n = intervals.length;
        int[] f = new int[n];

        Arrays.fill(f, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (intervals[j][1] <= intervals[i][0]) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
        }
        return n - Arrays.stream(f).max().getAsInt();
    }

    /**
     * 贪心
     *
     * @param intervals
     * @return int
     * @author wanglufei
     * @date 2022/9/11 10:01 AM
     */
    public int helper(int[][] intervals) {
        int n = intervals.length;
        // 按 end 升序排序
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        // 至少有一个区间不相交
        int count = 1;
        // 排序后，第一个区间就是 x
        int end = intervals[0][1];
        for (int[] interval : intervals) {
            int start = interval[0];
            if (start >= end) {
                // 排序后，第一个区间就是 x
                count++;
                end = interval[1];
            }
        }
        return n - count;
    }
}
