package com.uin.leetcode_100.backtracking.jzII_085;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 剑指 Offer II 085. 生成匹配的括号
 * 正整数 n 代表生成括号的对数，请设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(helper(3));
    }

    public static List<String> generateParenthesis(int n) {
        Set<String> set = new HashSet<>();
        set.add("()");

        for (int i = 1; i < n; i++) {
            List<String> list = new ArrayList<>(set);
            set.clear();
            for (String s : list) {
                StringBuilder sb = new StringBuilder(s);
                int len = sb.length();
                for (int k = 0; k <= len; k++) {
                    sb.insert(k, "()");
                    String newStr = sb.toString();
                    if (!set.contains(newStr)) {
                        set.add(newStr);
                    }
                    sb.delete(k, k + 2);
                }
            }
        }

        return new ArrayList<>(set);
    }

    public static List<String> helper(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    private static void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }

        if (open < max) {
            cur.append("(");
            backtrack(ans, cur, open + 1, close, max);
            cur.deleteCharAt(cur.length() - 1);
        }

        if (close < open) {
            cur.append(')');
            backtrack(ans, cur, open, close + 1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}
