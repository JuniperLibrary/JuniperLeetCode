package com.uin.leetcode_100.tree.leetcode_96;

/**
 * @author wanglufei
 */
public class Main {
    public int numsTrees(int n) {
        //最小的子问题
        if (n <= 1) return 1;
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += numsTrees(i) * numsTrees(n - 1 - i);
        }
        return res;
    }
}
