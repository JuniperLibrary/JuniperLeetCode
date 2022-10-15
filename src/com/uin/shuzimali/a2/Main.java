package com.uin.shuzimali.a2;

import java.util.Scanner;

/**
 * 字符串最后一个单词的长度
 * 输入一个字符串，有很多的单词，单词以空格隔开。计算字符串最后一个单词的长度。
 * <p>
 * hello nowcoder
 * 8
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

    }

    public static int helper(String s) {
        int end = s.length() - 1;
        while (end >= 0 && s.charAt(end) == ' ') {
            end--;
        }
        if (end < 0) {
            return 0;
        }
        int start = end;
        while (start >= 0 && s.charAt(start) != ' ') {
            start--;
        }
        return end - start;
    }
}
