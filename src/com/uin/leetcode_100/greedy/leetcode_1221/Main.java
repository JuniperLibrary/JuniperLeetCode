package com.uin.leetcode_100.greedy.leetcode_1221;

import java.util.Arrays;

/**
 * 1221.分割平衡字符串
 * 在一个 平衡字符串 中，'L' 和 'R' 字符的数量是相同的。
 * 给你一个平衡字符串s，请你将它分割成尽可能多的平衡字符串。
 * 注意：分割得到的每个字符串都必须是平衡字符串，且分割得到的平衡字符串是原平衡字符串的连续子串。
 * 返回可以通过分割得到的平衡字符串的 最大数量 。
 */
public class Main {
    public static void main(String[] args) {
        String s = "RLRRLLRLRL";
        System.out.println(balancedStringSplit(s));
    }

    public static int balancedStringSplit(String s) {
        char[] chars = s.toCharArray();
        int num = 0;
        int count = 0;
        for (char c : chars) {
            if (c == 'R') {
                count++;
            }
            if (c == 'L') {
                count--;
            }
            if (count == 0) {
                num++;
            }
        }
        return num;
    }
}
