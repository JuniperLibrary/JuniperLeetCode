package com.uin.shuzimali.a1;

import java.util.Scanner;

/**
 * 统计大写字母的个数
 * 找出给定字符串中的大写字母即("A"-"Z")的个数
 * <p>
 * NowCoder
 * 2
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        System.out.println(helper(s));
    }

    public static int helper(String s) {
        char[] chars = s.toCharArray();
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (!Character.isLowerCase(chars[i])) {
                count++;
            }
        }
        return count;
    }
}
