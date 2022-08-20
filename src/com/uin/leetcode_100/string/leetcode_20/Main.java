package com.uin.leetcode_100.string.leetcode_20;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 */
public class Main {
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        for (char aChar : chars) {
            if (aChar == '(') {
                stack.push(')');
            } else if (aChar == '[') {
                stack.push(']');
            } else if (aChar == '{') {
                stack.push('}');
            } else {
                if (stack.isEmpty()) return false;
                if (stack.pop() != aChar) return false;
            }
        }
        return stack.isEmpty();
    }
}
