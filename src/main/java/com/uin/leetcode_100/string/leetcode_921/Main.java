package com.uin.leetcode_100.string.leetcode_921;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 921. 使括号有效的最少添加
 * 只有满足下面几点之一，括号字符串才是有效的：
 * <p>
 * 它是一个空字符串，或者
 * 它可以被写成AB（A与B连接）, 其中A 和B都是有效字符串，或者
 * 它可以被写作(A)，其中A是有效字符串。
 * 给定一个括号字符串 s ，移动N次，你就可以在字符串的任何位置插入一个括号。
 * <p>
 * 例如，如果 s = "()))" ，你可以插入一个开始括号为 "(()))" 或结束括号为 "())))" 。
 * 返回 为使结果字符串 s 有效而必须添加的最少括号数。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "())"
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：s = "((("
 * 输出：3
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 1000
 * s 只包含 '(' 和 ')' 字符。
 */
public class Main {
    public static void main(String[] args) {
        //String s = "(((";
        String s = "()";
        System.out.println(minAddToMakeValid(s));
    }

    // 括号匹配问题 创建栈 左括号直接入栈，右括号直接入栈
    // 如果栈顶是左括号则左括号数量+1 否则右括号数量+1 最后返回剩余左括号和右括号数量之和
    public static int minAddToMakeValid(String s) {
        char[] chars = s.toCharArray();
        int left_count = 0, right_count = 0;
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                stack.push(chars[i]);
                left_count++;
            }
            if (chars[i] == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                    left_count--;
                    continue;
                }
                stack.push(chars[i]);
                right_count++;
            }
        }
        return left_count + right_count;
    }

    public static int greedyHelper(String s) {
        int res = 0;
        char[] chars = s.toCharArray();
        int left_count = 0;

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                left_count++;
            } else {
                if (left_count > 0) {
                    left_count--;
                } else {
                    res++;
                }
            }
        }
        res += left_count;
        return res;
    }
}
