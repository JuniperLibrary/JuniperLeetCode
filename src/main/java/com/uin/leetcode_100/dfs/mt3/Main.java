package com.uin.leetcode_100.dfs.mt3;

import java.util.TreeMap;

/**
 * MT3 拜访
 * 现在有一个城市销售经理，需要从公司出发，去拜访市内的某位商家，已知他的位置以及商家的位置，
 * 但是由于城市道路交通的原因，他每次移动只能在左右中选择一个方向 或 在上下中选择一个方向，
 * 现在问他有多少种最短方案到达商家地址。
 * 给定一个地图 CityMap 及它的 行长度 n 和 列长度 m ，
 * 其中1代表经理位置， 2 代表商家位置， -1 代表不能经过的地区，
 * 0 代表可以经过的地区，请返回方案数，保证一定存在合法路径。保证矩阵的长宽都小于等于 10。
 * 注意：需保证所有方案的距离都是最短的方案
 */
public class Main {
    TreeMap<Integer, Integer> pathLenCounter = new TreeMap<>();
    int[] dx = new int[]{-1, 1, 0, 0};
    int[] dy = new int[]{0, 0, -1, 1};

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param CityMap int整型二维数组
     * @param n       int整型
     * @param m       int整型
     * @return int整型
     */
    public int countPath(int[][] CityMap, int n, int m) {
        // write code here
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (CityMap[i][j] == 1) {
                    dfs(CityMap, i, j, 0, visited);
                }
            }
        }
        return pathLenCounter.firstEntry().getValue();
    }

    private void dfs(int[][] grid, int x, int y, int steps, boolean[][] visited) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == -1 ||
                visited[x][y] || (!pathLenCounter.isEmpty() && steps > pathLenCounter.firstKey())) {
            return;
        }
        if (grid[x][y] == 2) {
            pathLenCounter.put(steps, pathLenCounter.getOrDefault(steps, 0) + 1);
        } else {
            visited[x][y] = true;
            for (int i = 0; i < 4; i++) {
                dfs(grid, x + dx[i], y + dy[i], steps + 1, visited);
            }
            visited[x][y] = false;
        }
    }
}
