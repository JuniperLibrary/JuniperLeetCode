package com.uin.weekendAC.weenkend_329.leetcode_6296;

/**
 * 6296. 交替数字和
 * 给你一个正整数 n 。n 中的每一位数字都会按下述规则分配一个符号：
 * <p>
 * 最高有效位 上的数字分配到 正 号。
 * 剩余每位上数字的符号都与其相邻数字相反。
 * 返回所有数字及其对应符号的和。
 */
public class Main {
    public static void main(String[] args) {
        alternateDigitSum(521);
    }

    public static int alternateDigitSum(int n) {
        int ans = 0;
        if (n / 10 < 1) {
            ans += n;
        } else {
            char[] chars = String.valueOf(n).toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (i % 2 == 0) {
                    ans += chars[i] - '0';
                } else {
                    ans -= chars[i] - '0';
                }
            }
        }

        return ans;
    }
}
