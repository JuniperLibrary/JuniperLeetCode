package main.java.com.uin.leetcode_100.array.LeetCode_84;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * <p>
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *
 * @author wanglufei
 * @date 2022/7/26 6:50 AM
 */
public class Main {
    /**
     * 维护一个单调递增（值）栈（存索引，不存值，是因为值会重复）
     *
     * @param heights
     * @return int
     * @author wanglufei
     * @date 2022/7/26 7:20 AM
     */
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int max = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        for (int i = 0; i < n; i++) {
            //开始更新单调递增栈
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                max = Math.max(max, heights[stack.pop()] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {
            max = Math.max(max, heights[stack.pop()] * (n - stack.peek() - 1));
        }
        return max;
    }
}
