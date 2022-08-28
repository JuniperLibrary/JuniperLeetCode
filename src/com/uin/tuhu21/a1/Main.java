package com.uin.tuhu21.a1;

/**
 * 途虎养车2021秋招Java笔试试卷A-计算组合数
 * <p>
 * 对于给定的非负整数r和n（r≤n），请编写程序计算组合数C(r,n) = n! / r! / (n-r)!。
 * （本题目用于测试的所有用例，都保证结果小于231-1）
 * 输入：
 * 2，3
 * 输出：
 * 3
 * C_{3}^{2} = 3
 */
public class Main {
    public int combination(int r, int n) {//n,k
        // write code here
        int a = 1, b = 1;
        if (n > r / 2) {
            n = r - n;
        }
        for (int i = 1; i <= n; i++) {
            a *= (n + 1 - i);
            b *= i;
        }
        return a / b;
    }

    public int combine(int n, int k) {
        if (k == 0 || k == n) {
            return 1;
        } else {
            return combination(n - 1, k) + combination(n - 1, k - 1);
        }
    }
}
