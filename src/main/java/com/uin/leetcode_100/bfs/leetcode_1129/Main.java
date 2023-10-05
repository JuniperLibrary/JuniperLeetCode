package com.uin.leetcode_100.bfs.leetcode_1129;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        solution(3, new int[][]{{0, 1}, {1, 2}}, new int[][]{});
    }

    public static int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        // 1129. 颜色交替的最短路径
        // 在一个有向图
        // red_edges 中的每一个 [i, j] 对表示从节点 i 到节点 j 的红色有向边。
        // blue_edges 中的每一个 [i, j] 对表示从节点 i 到节点 j 的蓝色有向边。

        // 返回长度为n的数组answer，其中answer[x]是从节点0到节点x的红色边框和蓝色边交替出现的最短路径长度。
        // 如果不存在这样的路径，那么answer[x]=-1。

        // redEdges 和 blueEdges 边框交替出现的最短路径长度

        // 题目实际上是最短路径问题，可以考虑使用BFS来解决。
        // 1. 首先对所有边进行预处理，将所有的边按照颜色分类，存储到多维数组g中。
        //    g[0]存储所有红色边，g[1]存储所有蓝色边。
        List<Integer>[][] g = new List[2][n];
        for (List[] lists : g) {
            Arrays.setAll(lists, k -> new ArrayList());
        }
        for (int[] redEdge : redEdges) {
            g[0][redEdge[0]].add(redEdge[1]);
        }

        for (int[] blueEdge : blueEdges) {
            g[1][blueEdge[0]].add(blueEdge[1]);
        }
        // 2. 队列queue 存储当前搜索到的节点，以及当前边的颜色。
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0});
        queue.offer(new int[]{0, 1});

        //    集合vis 存储已经搜索过的节点，以及当前边的颜色。
        boolean[][] vis = new boolean[n][2];
        //    变量 distance 用来表示当前搜索的层数，即当前搜索到的节点到起点的距离。
        int distance = 0;
        //    数组ans：用来存储每个节点到起点的最短距离。将数组ans数组中的所有元素初始化为-1，
        //    表示所有的距离都未知
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        // 3. 我们首先将起点0和起点边的颜色0或1入队，表示从起点出发，且当前是红色或脸色边。
        while (!queue.isEmpty()) {
            // 4. 接下来，我们开始进行BFS搜索。我们每次从队列取出一个节点（i，c），
            //    如果我们当前节点的答案还未更新，则将当前节点的答案更新为当前层数d，即ans[i]=d
            //    然后，我们将当前边的颜色 c 取反，即如果当前边为红色，则将其变为蓝色，反之亦然。
            //    我们取出颜色对应的所有边，如果边的另一端节点 j 未被搜索过，则将其入队。
            for (int k = queue.size(); k > 0; --k) {
                int[] poll = queue.poll();
                int i = poll[0], c = poll[1];
                if (ans[i] == -1) {
                    ans[i] = distance;
                }
                vis[i][c] = true;
                c ^= 1;
                for (int j : g[c][i]) {
                    if (!vis[j][c]) {
                        queue.offer(new int[]{j, c});
                    }
                }
            }
        }
        return ans;
    }

    public static int[] solution(int n, int[][] redEdges, int[][] blueEdges) {

        List<Integer>[] redList = new List[n];
        List<Integer>[] blueList = new List[n];

        for (int i = 0; i < n; ++i) {
            redList[i] = new ArrayList<>();
            blueList[i] = new ArrayList<>();
        }

        for (int[] e : redEdges) {
            redList[e[0]].add(e[1]);
        }

        for (int[] e : blueEdges) {
            blueList[e[0]].add(e[1]);
        }

        int[] redAns = new int[n];// 最后一步为 [红色] 时到达点i的 [最小] 步数
        int[] blueAns = new int[n];// 最后一步为 [蓝色] 时到达点i的 [最小] 步数

        // 初始化 所有 [最小] 步数全部设置成 [MAX]
        // 从 [1] 开始因为从 [点0] 到 [点0] 需要 [0] 步
        for (int i = 1; i < n; i++) {
            redAns[i] = Integer.MAX_VALUE;
            blueAns[i] = Integer.MAX_VALUE;
        }

        Queue<int[]> queue = new ArrayDeque<>();// 由长度为 [2] 的数组表示每个点
        // 点的序号 + 下一次要走的 [颜色]

        // [0] 表示下一次要走 [红色]
        queue.add(new int[]{0, 0});
        // [1] 表示下一次要走 [蓝色]
        queue.add(new int[]{0, 1});
        // 初始状态有 [2] 个因为一开始可以走 [红色] 或者 [蓝色]

        // bfs的层数 = 走的步数
        int level = 0;
        // 在层数 [i] 到达的点 意味着从 [0] 开始走 [i] 步可以到达这个点

        while (!queue.isEmpty()) {
            level++;// bfs的层数 [+1]

            int size = queue.size();

            for (int i = 0; i < size; i++)// 对于每个准备走的点
            {
                int[] curArr = queue.poll();
                int cur = curArr[0];

                // 如果这个点下一步要走 [红色]
                if (curArr[1] == 0) {
                    for (int next : redList[cur])// 从 [红色] 的邻接表里找可以走到的下一个点'next'
                    {
                        if (level < redAns[next])// 如果记录的最后一步为 [红色] 时到达点'next'
                        {                       // 的 [最小] 步数 [大于] 当前层数

                            redAns[next] = level;// 更新 [最小] 步数
                            queue.offer(new int[]{next, 1});//将点'next'入队 并且下一次要走 [蓝色]
                        }
                    }
                } else {
                    // 如果这个点下一步要走 [蓝色] 时同理

                    for (int next : blueList[cur]) {
                        if (level < blueAns[next]) {
                            blueAns[next] = level;
                            queue.offer(new int[]{next, 0});
                        }
                    }
                }
            }
        }

        // 到达一个点的最小步数为 min([红色]结尾时的[最小]步数，[蓝色]结尾时的[最小]步数)
        for (int i = 0; i < redAns.length; i++) {
            if (blueAns[i] < redAns[i]) {
                redAns[i] = blueAns[i];
            } else if (redAns[i] == Integer.MAX_VALUE)// 如果都为 [MAX] 证明无法走到
            {
                redAns[i] = -1;
            }
        }

        return redAns;
    }
}
