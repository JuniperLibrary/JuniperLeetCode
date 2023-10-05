package main.java.com.uin.weekendAC.weenkend_320.leetcode_6244;

/**
 * 6244. 完美分割的方案数
 * 给你一个字符串 s ，每个字符是数字 '1' 到 '9' ，再给你两个整数 k 和 minLength 。
 * <p>
 * 如果对 s 的分割满足以下条件，那么我们认为它是一个 完美 分割：
 * <p>
 * s 被分成 k 段互不相交的子字符串。
 * 每个子字符串长度都 至少 为 minLength 。
 * 每个子字符串的第一个字符都是一个 质数 数字，最后一个字符都是一个 非质数 数字。质数数字为 '2' ，'3' ，'5' 和 '7' ，剩下的都是非质数数字。
 * 请你返回 s 的 完美 分割数目。由于答案可能很大，请返回答案对 109 + 7 取余 后的结果。
 * <p>
 * 一个 子字符串 是字符串中一段连续字符串序列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "23542185131", k = 3, minLength = 2
 * 输出：3
 * 解释：存在 3 种完美分割方案：
 * "2354 | 218 | 5131"
 * "2354 | 21851 | 31"
 * "2354218 | 51 | 31"
 * 示例 2：
 * <p>
 * 输入：s = "23542185131", k = 3, minLength = 3
 * 输出：1
 * 解释：存在一种完美分割方案："2354 | 218 | 5131" 。
 * 示例 3：
 * <p>
 * 输入：s = "3312958", k = 3, minLength = 1
 * 输出：1
 * 解释：存在一种完美分割方案："331 | 29 | 58" 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= k, minLength <= s.length <= 1000
 * s 每个字符都为数字 '1' 到 '9' 之一。
 */
public class Main {
    static int MOD = 1000000007;
    static boolean[] flag = new boolean[]{false, false, true, true, false, true, false, true, false, false};

    public static void main(String[] args) {
        String s = "23542185131";
        int k = 3, minLength = 2;
        System.out.println(beautifulPartitions(s, k, minLength));
    }

    public static int beautifulPartitions(String s, int k, int minLength) {
        char[] cs = s.toCharArray();
        int N = cs.length;
        long[][] dp = new long[N + 1][k + 1];
        if (!flag[cs[0] - '0'] || flag[cs[N - 1] - '0']) {
            return 0;
        }
        dp[0][0] = 1;
        for (int i = 1; i <= N; i++) {
            if (i == 4) {
                int a = 3;
            }
            for (int j = 1; j <= k; j++) {
                long cur = 0;
                if (i >= minLength && !flag[cs[i - 1] - '0']) {
                    for (int l = i - minLength + 1; l >= 1; l--) {
                        if (flag[cs[l - 1] - '0']) {
                            cur += dp[l - 1][j - 1];
                        }
                    }
                }
                cur %= MOD;
                dp[i][j] = cur;
            }
        }
        return (int) dp[N][k];
    }
}
