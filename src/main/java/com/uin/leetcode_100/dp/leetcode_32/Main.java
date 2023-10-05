package com.uin.leetcode_100.dp.leetcode_32;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 32. 最长有效括号
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 *
 * @author wanglufei
 * @date 2022/8/8 8:19 PM
 */
public class Main {
    //利用stack
    public int longestValidParentheses(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        int res = 0;
        int start = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    start = i;
                } else {
                    stack.pop();
                    if (stack.isEmpty()) {
                        res = Math.max(res, i - start);
                    } else {
                        res = Math.max(res, i - stack.peek());
                    }
                }
            }
        }
        return res;
    }
    //dp
    public int helper(String s) {
        int n = s.length();
        int max = 0;
        int[] dp = new int[n];

        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0);
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }
}
