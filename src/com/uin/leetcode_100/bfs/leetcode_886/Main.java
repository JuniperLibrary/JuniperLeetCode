package com.uin.leetcode_100.bfs.leetcode_886;

import java.util.ArrayList;
import java.util.List;

/**
 * 886.可能的二分法
 * 给定一组n人（编号为1, 2, ..., n），我们想把每个人分进任意大小的两组。每个人都可能不喜欢其他人，那么他们不应该属于同一组。
 * 给定整数 n和数组 dislikes，其中dislikes[i] = [ai, bi]，表示不允许将编号为 ai和bi的人归入同一组。当可以用这种方法将所有人分进两组时，返回 true；否则返回 false。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 4, dislikes = [[1,2],[1,3],[2,4]]
 * 输出：true
 * 解释：group1 [1,4], group2 [2,3]
 * 示例 2：
 * <p>
 * 输入：n = 3, dislikes = [[1,2],[1,3],[2,3]]
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：n = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
 * 输出：false
 */
public class Main {
    public static void main(String[] args) {
        int[][] dislikes = {{1, 2}, {1, 3}, {2, 3}};
        System.out.println(helper(3, dislikes));
    }

    /**
     * 首先题目给定n个人为一组（编号为1，2，。。。，n），其中n为偶数，并给出数组dislike，其中dislike[i]={a,b}
     * 表示a的用户不喜欢b的用户。
     * 现在判断是否能将n个人分成两组，并满足当一个人不喜欢某一个人时，该两人不在同一组中出现。。
     * <p>
     * 我们可以尝试用染色法来解决问题：假设第一组中的人时红色，第二组中的人为蓝色。我们依次遍历每一个人，如果当前的人没有被分组，就将其分到第一组（即染为红色）
     * ，那么这个人不喜欢的人必须分到第二组中（染为蓝色）。
     * 然后任何被分到第二组中的人，其不喜欢的人必须被分到第一组，依次类推。如果在染色的过程中存在冲突，就表示这个任务是不能完成的。
     * 否则说明染色的过程有效（即存在合法的分组方案）
     *
     * @param n
     * @param dislikes
     * @return
     */
    public static boolean helper(int n, int[][] dislikes) {
        int[] color = new int[n + 1];
        List<Integer>[] g = new List[n + 1];

        for (int i = 0; i <= n; i++) {
            g[i] = new ArrayList<Integer>();
        }

        for (int[] dislike : dislikes) {
            g[dislike[0]].add(dislike[1]);
            g[dislike[1]].add(dislike[0]);
        }

        for (int i = 0; i <= n; i++) {
            if (color[i] == 0 && !dfs(i, 1, color, g)) {
                return false;
            }
        }
        return true;
    }

    private static boolean dfs(int curNode, int nowColor, int[] color, List<Integer>[] g) {
        color[curNode] = nowColor;
        for (int nextNode : g[curNode]) {
            if (color[nextNode] != 0 && color[nextNode] == color[curNode]) {
                return false;
            }
            if (color[nextNode] == 0 && !dfs(nextNode, 3 ^ nowColor, color, g)) {
                return false;
            }
        }
        return true;
    }
}
