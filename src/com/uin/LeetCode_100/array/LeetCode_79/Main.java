package com.uin.LeetCode_100.array.LeetCode_79;

/**
 * DFS
 *
 * @author wanglufei
 * @date 2022/7/25 11:07 PM
 */

import java.util.HashMap;
import java.util.HashSet;

/**
 * DFS和BFS的区别
 * 1.DFS特点是纵向搜索，又一个起点，就是你不停在里面搜索，看存不存在可行解
 * 2.BFS一般需要配合Deque来辅助
 */
public class Main {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, i, j, 0, word, new HashSet<String>())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * @param board   矩阵
     * @param i       控制上下
     * @param j       控制左右
     * @param index   字符串的索引
     * @param word    字符串
     * @param disCont 去重的保证每个字母被使用一次或者使用boolean[0][0]=true
     * @author wanglufei
     * @date 2022/7/25 11:19 PM
     */
    public boolean dfs(char[][] board, int i, int j, int index, String word, HashSet<String> disCont) {
        if (index == word.length()) return true;
        if (i < 0
                || i >= board.length
                || j < 0
                || j >= board[0].length
                || disCont.contains(i + "," + j)
                || board[i][j] != word.charAt(index))
            return false;
        disCont.add(i + "," + j);
        if (dfs(board, i + 1, j, index + 1, word, disCont)//向下
                || dfs(board, i - 1, j, index + 1, word, disCont)//向上
                || dfs(board, i, j + 1, index + 1, word, disCont)//右
                || dfs(board, i, j - 1, index + 1, word, disCont))//左
            return true;
        disCont.remove(i + "," + j);
        return false;
    }
}
