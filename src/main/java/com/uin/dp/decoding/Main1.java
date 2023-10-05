package com.uin.dp.decoding;

public class Main1 {
    public static void main(String[] args) {
        String s = "12305";
        int solution = solution(s);
        System.out.println(solution(s));
    }

    public static int solution(String s) {
        int length = s.length();
        int[] dp = new int[length + 1];
        dp[0] = 1;

        for (int i = 1; i <= length; i++) {
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }
            if (i >= 2 && (s.charAt(i - 2) == '1' ||
                    s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6')) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[length];
    }
}
