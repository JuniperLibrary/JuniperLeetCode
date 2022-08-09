package com.uin.dp.leetcode_118;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 * <p>
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 *
 * @author wanglufei
 * @date 2022/8/9 8:15 PM
 */
public class Main {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> level = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            level.add(0, 1);
            for (int j = 1; j < level.size(); j++) {
                level.set(j, level.get(j) + level.get(j + 1));
            }
            res.add(new ArrayList<>(level));
        }
        return res;
    }
}
