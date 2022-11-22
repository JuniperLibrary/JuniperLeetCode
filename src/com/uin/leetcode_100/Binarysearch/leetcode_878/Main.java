package com.uin.leetcode_100.Binarysearch.leetcode_878;

/**
 * 878. 第 N 个神奇数字
 * 一个正整数如果能被 a 或 b 整除，那么它是神奇的。
 * 给定三个整数 n , a , b ，返回第 n 个神奇的数字。因为答案可能很大，所以返回答案 对 109 + 7 取模 后的值。
 * 示例 1：
 * <p>
 * 输入：n = 1, a = 2, b = 3
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：n = 4, a = 2, b = 3
 * 输出：6
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 109
 * 2 <= a, b <= 4 * 104
 */
public class Main {
    public static final int MOD = 1000000007;

    public int nthMagicalNumber(int n, int a, int b) {
        int c = lcm(a, b);
        int m = c / a + c / b - 1;
        int r = n % m;
        int res = (int) ((long) c * (n / m) % MOD);
        if (r == 0) {
            return res;
        }
        int addA = a, addB = b;
        for (int i = 0; i < r - 1; ++i) {
            if (addA < addB) {
                addA += a;
            } else {
                addB += b;
            }
        }
        return (res + Math.min(addA, addB) % MOD) % MOD;
    }


    public int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    public int gcd(int a, int b) {
        return b != 0 ? gcd(b, a % b) : a;
    }
}
