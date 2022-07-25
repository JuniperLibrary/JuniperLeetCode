package com.uin.tencent.String;

/**
 * 小红最近在研究 k-size 字符串。
 * 一个字符串为 k-size 指，字符串的连续段共有 k 个。所谓连续段指尽可能多的相同连续字母组成的子串。
 * 例如：aabbbccc为3-size，因为（'aa' 'bb' 'ccc'），ababaab为6-size，因为 （'a' 'b' 'a' 'b' 'aa' 'b'）。
 * 小红认为当且仅当每个连续段长度 至少为2 时，该字符串是合法的。例如aabbbccc是合法的，但ababaab不是合法的。
 * 小红想知道，给定 n 和 k，长度为n的，仅由小写字母组成的 合法的 k-size 字符串共有多少个？由于答案可能过大，请对  取模。
 *
 * @author wanglufei
 * @date 2022/7/23 2:20 PM
 */
public class Main1 {
    /**
     * @param n 字符串长度
     * @param k 连续段
     * @return int
     * @author wanglufei
     * @date 2022/7/23 2:22 PM
     */
    public int numsOfStrings(int n, int k) {
        final int MOD = 1000000;
        int[][] dp = new int[n + 1][k + 1];
        int m = Math.min(k, n / 2);
        for (int i = 2; i <= n; i++) dp[i][1] = 26;
        for (int i = 4; i <= n; i++) { //开始为1时长度为0 为2时固定是26
            for (int j = 2; j <= m; j++) {
                dp[i][j] = dp[i - 1][j] + 25 * dp[i - 2][j - 1];
                dp[i][j] %= MOD;
            }
        }
        return dp[n][k];
    }
}
