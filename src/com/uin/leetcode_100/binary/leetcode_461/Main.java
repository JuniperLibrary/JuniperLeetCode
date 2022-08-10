package com.uin.leetcode_100.binary.leetcode_461;

public class Main {
    public int hammingDistance(int x, int y) {
        int ans = 0;
        for (int i = 0; i < 31; i++) {
            int bx = x % 2;
            int by = y % 2;
            if (bx != by) ans++;
            x >>= 1;
            y >>= 1;
        }
        return ans;
    }
}
