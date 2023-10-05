package main.java.com.uin.souhu20.a1;

import java.util.Scanner;

/**
 * 搜狐畅游2020校招笔试 - JAVA开发工程师--台阶问题
 * 有一座高度是n级台阶的楼梯，从下往上走，每跨一步只能向上1级或者2级台阶。要求用程序来求出一共有多少种走法。
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(helper(n));
    }

    public static int helper(int n) {
        if (n == 1) return 1;
        if (n == 2) return 1 + 1;

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 2;

        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }
}
