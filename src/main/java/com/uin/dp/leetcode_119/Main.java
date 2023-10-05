package com.uin.dp.leetcode_119;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> level = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            level.add(0, 1);
            for (int j = 1; j < level.size() - 1; j++) {
                level.set(j, level.get(j) + level.get(j + 1));
            }
        }
        return level;
    }
}
