package main.java.com.uin.leetcode_100.bfs.leetcode_864;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 864. 获取所有钥匙的最短路径
 * 给定一个二维网格 grid ，其中：
 * <p>
 * '.' 代表一个空房间
 * '#' 代表一堵
 * '@' 是起点
 * 小写字母代表钥匙
 * 大写字母代表锁
 * 我们从起点开始出发，一次移动是指向四个基本方向之一行走一个单位空间。我们不能在网格外面行走，也无法穿过一堵墙。如果途经一个钥匙，我们就把它捡起来。除非我们手里有对应的钥匙，否则无法通过锁。
 * <p>
 * 假设 k 为 钥匙/锁 的个数，且满足 1 <= k <= 6，字母表中的前 k 个字母在网格中都有自己对应的一个小写和一个大写字母。换言之，每个锁有唯一对应的钥匙，每个钥匙也有唯一对应的锁。另外，代表钥匙和锁的字母互为大小写并按字母顺序排列。
 * <p>
 * 返回获取所有钥匙所需要的移动的最少次数。如果无法获取所有钥匙，返回 -1 。
 * 示例 1：
 * 输入：grid = ["@.a.#","###.#","b.A.B"]
 * 输出：8
 * 解释：目标是获得所有钥匙，而不是打开所有锁。
 * 示例 2：
 * 输入：grid = ["@..aA","..B#.","....b"]
 * 输出：6
 * 示例 3:
 * 输入: grid = ["@Aa"]
 * 输出: -1
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 30
 * grid[i][j] 只含有 '.', '#', '@', 'a'-'f' 以及 'A'-'F'
 * 钥匙的数目范围是 [1, 6]
 * 每个钥匙都对应一个 不同 的字母
 * 每个钥匙正好打开一个对应的锁
 */
public class Main {
    int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int shortestPathAllKeys(String[] grid) {
        // '.' 代表一个空房间
        // '#' 墙
        // '@' 起点
        int m = grid.length, n = grid[0].length(), startX = -1, startY = -1, count = 0;
        //先遍历网格找到起点坐标以及字母个数
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = grid[i].charAt(j);
                if (c == '@') {
                    startX = i;
                    startY = j;
                } else if (c >= 'a' && c < 'g') {
                    count = Math.max(count, c - 'a' + 1);
                }
            }
        }
        int max = 1 << count;
        int step[][][] = new int[m][n][max];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(step[i][j], (int) 1e9);
            }
        }
        step[startX][startY][0] = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startX, startY, 0, 0});//坐标，钥匙情况，步数
        while (q.size() > 0) {
            int a[] = q.poll();
            for (int i = 0; i < 4; i++) {
                int x = a[0] + move[i][0], y = a[1] + move[i][1];
                if (x < 0 || x == m || y < 0 || y == n) {
                    continue;
                }
                char c = grid[x].charAt(y);
                if (c == '#') {
                    continue;
                }
                if (c == '.' || c == '@') {
                    if (step[x][y][a[2]] > a[3] + 1) {
                        step[x][y][a[2]] = a[3] + 1;
                        q.add(new int[]{x, y, a[2], a[3] + 1});
                    }
                } else if (Character.isUpperCase(c)) {
                    if ((a[2] & (1 << (c - 'A'))) == 0 || step[x][y][a[2]] <= a[3] + 1) {
                        continue;
                    }
                    step[x][y][a[2]] = a[3] + 1;
                    q.add(new int[]{x, y, a[2], a[3] + 1});
                } else {
                    if (step[x][y][a[2] | (1 << (c - 'a'))] <= a[3] + 1) {
                        continue;
                    }
                    if (max - 1 == (a[2] | (1 << (c - 'a')))) {

                        return a[3] + 1;
                    }
                    step[x][y][a[2] | (1 << (c - 'a'))] = a[3] + 1;
                    q.add(new int[]{x, y, a[2] | (1 << (c - 'a')), a[3] + 1});
                }
            }
        }
        return -1;

    }
}
