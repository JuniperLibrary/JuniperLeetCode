package com.uin.backtracking.leetcode_51;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
