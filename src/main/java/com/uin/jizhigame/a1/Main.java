package com.uin.jizhigame.a1;

import java.util.Scanner;

/**
 * 找出多个单词最长的公共前缀
 * good,go,goal
 * go
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] strs = in.nextLine().split(",");
        System.out.println(helper(strs));
    }

    public static String helper(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }

        String first = strs[0];
        int max = first.length() - 1;
        for (int i = 1; i < strs.length; i++) {
            String curr = strs[i];
            max = Math.min(curr.length() - 1, max);

            for (int j = 0; j <= max; j++) {
                if (curr.charAt(j) == first.charAt(j)) {

                } else {
                    if (j == 0) {
                        return "";
                    } else {
                        max = j - 1;
                        break;
                    }
                }
            }
        }
        String s = first.substring(0, max + 1);
        return s == null ? "null" : s;
    }


    public String solution(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        int length = strs.length;
        String prefix = strs[0];
        for (int i = 1; i < length; i++) {
            prefix = longestCommonPrefix(prefix, strs[i]);

            if (prefix.isEmpty()) return prefix;
        }
        return prefix;
    }

    private String longestCommonPrefix(String s1, String s2) {
        if (s1.isEmpty() || s2.isEmpty()) return "";

        int len = Math.min(s1.length(), s2.length());

        for (int i = 0; i < len; ) {
            if (s1.charAt(i) == s2.charAt(i)) {
                i++;
            } else {
                return s1.substring(0, i);
            }
        }
        return s1.substring(0, len);
    }
}
