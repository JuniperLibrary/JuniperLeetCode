package com.uin.leetcode_100.string.leetcode_1678;

/**
 * 1678. 设计 Goal 解析器
 * 请你设计一个可以解释字符串 command 的 Goal 解析器 。command 由 "G"、"()" 和/或 "(al)" 按某种顺序组成。
 * Goal 解析器会将 "G" 解释为字符串 "G"、"()" 解释为字符串 "o" ，"(al)" 解释为字符串 "al" 。
 * 然后，按原顺序将经解释得到的字符串连接成一个字符串。
 * <p>
 * 给你字符串 command ，返回 Goal 解析器 对 command 的解释结果。
 */
public class Main {
    public String interpret(String command) {
        int n = command.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (command.charAt(i) == 'G') {
                sb.append("G");
            }
            if (command.charAt(i) == '(' && command.charAt(i + 1) == ')') {
                sb.append("o");
            }

            if (command.charAt(i) == '(' && command.charAt(i + 1) == 'a' && command.charAt(i + 1 + 1) == 'l' && command.charAt(i + 1 + 1 + 1) == ')') {
                sb.append("al");
            }
        }
        return sb.toString();
    }


    public String helper(String command) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < command.length(); i++) {
            if (command.charAt(i) == 'G') {
                res.append("G");
            } else if (command.charAt(i) == '(') {
                if (command.charAt(i + 1) == ')') {
                    res.append("o");
                } else {
                    res.append("al");
                }
            }
        }
        return res.toString();
    }
}
