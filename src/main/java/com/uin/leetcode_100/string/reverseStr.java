package com.uin.leetcode_100.string;

import java.util.Scanner;

/**
 * 字符串反转
 */
public class reverseStr {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        System.out.println(helper(str));
        System.out.println(help(str));
    }

    public static String helper(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            char temp;
            temp = chars[i];
            chars[i] = chars[chars.length - i - 1];
            chars[chars.length - i - 1] = temp;
        }
        return new String(chars);
    }

    public static String help(String str) {
        StringBuilder builder = new StringBuilder(str);
        return builder.reverse().toString();
    }
}
