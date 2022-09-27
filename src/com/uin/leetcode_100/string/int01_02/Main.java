package com.uin.leetcode_100.string.int01_02;

import java.util.Arrays;

/**
 * 面试题 01.02. 判定是否互为字符重排
 * 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 * <p>
 * 示例 1：
 * <p>
 * 输入: s1 = "abc", s2 = "bca"
 * 输出: true
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(CheckPermutation("abc", "bca"));
    }

    /**
     * 排序
     *
     * @param s1
     * @param s2
     * @return boolean
     * @author wanglufei
     * @date 2022/9/27 10:16 AM
     */
    public static boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        char[] s = s1.toCharArray();
        char[] p = s2.toCharArray();

        Arrays.sort(s);
        Arrays.sort(p);

        return Arrays.equals(s, p);
    }

    public static boolean helpers(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int[] table = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            table[s1.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s2.length(); i++) {
            table[s2.charAt(i) - 'a']--;
            if (table[s2.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
