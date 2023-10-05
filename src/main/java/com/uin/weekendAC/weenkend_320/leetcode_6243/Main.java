package com.uin.weekendAC.weenkend_320.leetcode_6243;

import java.util.ArrayList;
import java.util.List;

/**
 * 6243. 到达首都的最少油耗
 * 通过的用户数75
 * 尝试过的用户数90
 * 用户总通过次数75
 * 用户总提交次数101
 * 题目难度Medium
 * 给你一棵 n 个节点的树（一个无向、连通、无环图），每个节点表示一个城市，编号从 0 到 n - 1 ，且恰好有 n - 1 条路。0 是首都。给你一个二维整数数组 roads ，其中 roads[i] = [ai, bi] ，表示城市 ai 和 bi 之间有一条 双向路 。
 * <p>
 * 每个城市里有一个代表，他们都要去首都参加一个会议。
 * <p>
 * 每座城市里有一辆车。给你一个整数 seats 表示每辆车里面座位的数目。
 * <p>
 * 城市里的代表可以选择乘坐所在城市的车，或者乘坐其他城市的车。相邻城市之间一辆车的油耗是一升汽油。
 * <p>
 * 请你返回到达首都最少需要多少升汽油。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：roads = [[0,1],[0,2],[0,3]], seats = 5
 * 输出：3
 * 解释：
 * - 代表 1 直接到达首都，消耗 1 升汽油。
 * - 代表 2 直接到达首都，消耗 1 升汽油。
 * - 代表 3 直接到达首都，消耗 1 升汽油。
 * 最少消耗 3 升汽油。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：roads = [[3,1],[3,2],[1,0],[0,4],[0,5],[4,6]], seats = 2
 * 输出：7
 * 解释：
 * - 代表 2 到达城市 3 ，消耗 1 升汽油。
 * - 代表 2 和代表 3 一起到达城市 1 ，消耗 1 升汽油。
 * - 代表 2 和代表 3 一起到达首都，消耗 1 升汽油。
 * - 代表 1 直接到达首都，消耗 1 升汽油。
 * - 代表 5 直接到达首都，消耗 1 升汽油。
 * - 代表 6 到达城市 4 ，消耗 1 升汽油。
 * - 代表 4 和代表 6 一起到达首都，消耗 1 升汽油。
 * 最少消耗 7 升汽油。
 * 示例 3：
 * <p>
 * <p>
 * <p>
 * 输入：roads = [], seats = 1
 * 输出：0
 * 解释：没有代表需要从别的城市到达首都。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 105
 * roads.length == n - 1
 * roads[i].length == 2
 * 0 <= ai, bi < n
 * ai != bi
 * roads 表示一棵合法的树。
 * 1 <= seats <= 105
 */
public class Main {
    private static int cnt = 0;

    public static void main(String[] args) {
        int[][] roads = {{3, 1}, {3, 2}, {1, 0}, {0, 4}, {0, 5}, {4, 6}};
        int seats = 2;
        System.out.println(minimumFuelCost(roads, seats));
    }

    public static long minimumFuelCost(int[][] roads, int seats) {
        if (roads.length == 0) {
            return 0;
        }

        int n = roads.length;
        cnt = 0;

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] e : roads) {
            int a = e[0];
            int b = e[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        int[] dfn = new int[n + 1];
        int[] size = new int[n + 1];
        long[] cost = new long[n + 1];
        cnt = 0;
        dfs(graph, 0, dfn, size, seats, cost);
        return cost[0];
    }

    public static void dfs(List<List<Integer>> graph, int cur, int[] dfn, int[] size, int seats, long[] cost) {
        dfn[cur] = ++cnt;
        size[cur] = 1;
        for (int next : graph.get(cur)) {
            if (dfn[next] == 0) {
                dfs(graph, next, dfn, size, seats, cost);
                size[cur] += size[next];
                cost[cur] += cost[next];
                cost[cur] += (size[next] + seats - 1) / seats;
            }
        }
    }
}
