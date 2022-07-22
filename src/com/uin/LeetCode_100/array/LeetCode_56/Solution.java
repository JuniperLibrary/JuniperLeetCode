package com.uin.LeetCode_100.array.LeetCode_56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return intervals;

        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        int[] curr = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            //end>start 说明不需要合并了
            if (intervals[i][0] > curr[1]) {
                res.add(curr);
                curr = intervals[i];
            } else {
                curr[1] = Math.max(curr[1], intervals[i][1]);
            }
        }
        res.add(curr);
        /**
         * 需要解决两个问题
         *  1.怎么找到合并所有重叠区间
         *  2.怎么合并所有重叠区间
         */
        //[[1,3],[2,6],[8,10],[15,18]]
        //[1,2,3,6]==>[1,6]
        //[[1,6],[8,10],[15,18]]
        return res.toArray(new int[res.size()][2]);
    }

    public static void main(String[] args) {
        int[][] nums = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] merge = merge(nums);
        System.out.println(merge);
    }
}
