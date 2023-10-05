package main.java.com.uin.leetcode_100.bfs.leetcode_210;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 210. 课程表 II
 * 现在你总共有 numCourses 门课需要选，记为0到numCourses - 1。给你一个数组prerequisites ，其中 prerequisites[i] = [ai, bi] ，表示在选修课程 ai 前 必须 先选修bi 。
 * <p>
 * 例如，想要学习课程 0 ，你需要先完成课程1 ，我们用一个匹配来表示：[0,1] 。
 * 返回你为了学完所有课程所安排的学习顺序。可能会有多个正确的顺序，你只要返回 任意一种 就可以了。如果不可能完成所有课程，返回 一个空数组 。
 */
public class Main {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] input = new int[numCourses];
        int[] res = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        // 统计节点的入度
        for (int[] edge : prerequisites) {
            input[edge[0]]++;
        }
        // 将入度为0的点入队
        for (int i = 0; i < numCourses; i++) {
            if (input[i] == 0) {
                queue.offer(i);
            }
        }
        int idx = 0;
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            res[idx++] = temp;
            // 修改节点入度
            for (int[] edge : prerequisites) {
                if (edge[1] == temp) {
                    input[edge[0]]--;
                    if (input[edge[0]] == 0) {
                        queue.offer(edge[0]);
                    }
                }
            }
        }
        // 出现环了(res中没包括所有点, idx没走完)
        if (idx != numCourses) {
            return new int[]{};
        }
        return res;
    }
}
