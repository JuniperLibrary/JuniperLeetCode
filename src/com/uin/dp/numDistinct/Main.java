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
