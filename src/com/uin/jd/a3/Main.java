package com.uin.jd.a3;

import java.util.Scanner;

/**
 * 小红的漂亮串
 * 漂亮串：至少有2个"red"子串。
 * "redcred"是。"reedred"不是。
 * 小红想知道，长度为n、仅包含小写字母的字符串中，共有多少中不同的漂亮串？
 *
 * <p>
 * 输入：
 * 6  :表示字符窜的长度
 * 输出：
 * 1  :仅有redred这一个漂亮串
 * 长度为n的，漂亮串串的种类数。10^9+7取模。
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(helper(n));
    }

    public static int helper(int n) {
        //conner case
        if (n < 6) return 0;

        int[] freq = new int[26];
        int maxCount = 0;
        int left = 0;
        int right = 0;

        if (left < n) {

        }

        return maxCount;
    }
}
