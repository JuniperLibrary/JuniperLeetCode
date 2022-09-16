package com.uin.leetcode_100.string.leetcode_1624;

import java.util.Arrays;

/**
 * 1624.两个相同字符之间的最长子字符串
 * 给你一个字符串 s，请你返回 两个相同字符之间的最长子字符串的长度 ，计算长度时不含这两个字符。如果不存在这样的子字符串，返回 -1 。
 * 子字符串 是字符串中的一个连续字符序列。
 */
public class Main {
    public static void main(String[] args) {
        String s = "abca";
        //System.out.println('c' - 'a');
        System.out.println(maxLengthBetweenEqualCharacters(s));
    }

    public static int maxLengthBetweenEqualCharacters(String s) {
        int[] firstIndex = new int[26];
        //初始化时 firstIndex 中的每个元素都初始化为 -1，表示该字符还未出现。
        Arrays.fill(firstIndex, -1);
        int maxLen = -1;
        for (int i = 0; i < s.length(); i++) {
            // 记录每个字符出现的位置
            if (firstIndex[s.charAt(i) - 'a'] < 0) {
                firstIndex[s.charAt(i) - 'a'] = i;
            } else {
                maxLen = Math.max(maxLen, i - firstIndex[s.charAt(i) - 'a'] - 1);
            }
        }
        return maxLen;
    }
}
