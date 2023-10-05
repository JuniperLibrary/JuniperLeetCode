package main.java.com.uin.leetcode_100.greedy.leetcode_452;

import java.util.Arrays;

/**
 * 452.用最少数量的箭引爆气球
 * 有一些球形气球贴在一堵用 XY 平面表示的墙面上。
 * 墙面上的气球记录在整数数组points，其中points[i] = [xstart, xend]表示水平直径在xstart和xend之间的气球。你不知道气球的确切 y 坐标。
 * 一支弓箭可以沿着 x 轴从不同点 完全垂直 地射出。
 * 在坐标 x 处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend，且满足 xstart≤ x ≤ xend，则该气球会被 引爆。
 * 可以射出的弓箭的数量 没有限制 。 弓箭一旦被射出之后，可以无限地前进。
 * 给你一个数组 points ，返回引爆所有气球所必须射出的 最小 弓箭数。
 * <p>
 * 输入：points = [[10,16],[2,8],[1,6],[7,12]]
 * 输出：2
 * 解释：气球可以用2支箭来爆破:
 * - 在x = 6处射出箭，击破气球[2,8]和[1,6]。
 * - 在x = 11处发射箭，击破气球[10,16]和[7,12]。
 */
public class Main {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }

        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        int end = points[0][1];
        int count = 1;
        for (int[] point : points) {
            int start = point[0];
            // 找到不重叠区间（边界重叠也算重叠）
            if (start > end) {
                count++;
                end = point[1];
            }
        }
        return count;
    }
}
