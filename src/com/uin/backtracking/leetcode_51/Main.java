package com.uin.backtracking.leetcode_51;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 * leetcode 51.N 皇后
 * 按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
 * n皇后问题 研究的是如何将 n个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 给你一个整数 n ，返回所有不同的n皇后问题 的解决方案。
 * 每一种解法包含一个不同的n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 */
public class Main {
    List<List<String>> res = new ArrayList<>();
    int n;
    boolean[][] board;
    Set<Integer> column, pie, na;

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        this.board = new boolean[n][n];
        this.column = new HashSet<>();
        this.pie = new HashSet<>();
        this.na = new HashSet<>();
        dfs(0);
        return res;
    }


    public void dfs(int i) {
        if (i == n) {
            generate_result();
            return;
        }

        for (int j = 0; j < n; j++) {
            if (column.contains(j) || pie.contains(i + j) || na.contains(i - j)) continue;

            board[i][j] = true;
            column.add(j);
            pie.add(i + j);
            na.add(i - j);

            // 下一行
            dfs(i + 1);

            //复原
            column.remove(j);
            pie.remove(i + j);
            na.remove(i - j);
            board[i][j] = false;
        }
    }

    private void generate_result() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (board[i][j]) {
                    sb.append('Q');
                } else {
                    sb.append('.');
                }
            }
            list.add(sb.toString());
        }
        res.add(list);
    }
}
