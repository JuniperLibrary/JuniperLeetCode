package com.uin.dp.numDistinct;

/**
 * 给定一个字符串s和一个字符串t，计算在s的子序列中t出现的个数
 */
public class Main {
    public static void main(String[] args) {
        String s = "rabbbit";
        String t = "rabbit";
        int solution = solution(s, t);
        System.out.println(solution);
    }

    public static int solution(String s, String t) {
        int s_len = s.length();
        int t_len = t.length();

        //初始状态
        //定义dp数组 t_len表示t的字符串 s_len表示s的字符串
        //dp[i][j]
        //dp[t_len][s_len]
        int[][] dp = new int[t_len+1][s_len+1];

        //base case 边界条件
        for (int j = 0; j < s_len; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i <= t_len; i++) {
            for (int j = 1; j <= s_len; j++) {
                //递推公式
                /**
                 * 1. 如果t和s的最后一个字符串相等，那么就有两种情况，
                 *  s: r a b b b i t
                 *  t:   r a b b i t
                 *  此时:
                 *      r a b b b i
                 *        r a b b i
                 *   也就是：
                 *      dp[i - 1][j - 1]
                 *   还有一种情况：
                 *      不用字符串的s的第j个字符和t的第i个字符匹配，只需要计算"rabbbi"中含有多少个"rabbit"
                 *   也就是:
                 *      dp[i][j - 1]
                 * 2. 如果字符串t的第i个字符和字符串s的第j个字符不一样，
                 *   也就是说字符串s的第j个字符 不能匹配字符串t的第i个字符。
                 *   那么我们只能计算字符串s的前j-1个字符构成的子序列
                 *   中包含字符串t的前i个字符组成的字符串的个数。
                 */
                if (t.charAt(i - 1) == s.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                }else {
                    dp[i][j]=dp[i][j-1];
                }
            }
        }
        return dp[t_len][s_len];
    }
}
