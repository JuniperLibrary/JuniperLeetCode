package main.java.com.uin.leetcode_100.string.leetcode_856;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 856. 括号的分数
 * 给定一个平衡括号字符串S，按下述规则计算该字符串的分数：
 * <p>
 * () 得 1 分。
 * AB 得A + B分，其中 A 和 B 是平衡括号字符串。
 * (A) 得2 * A分，其中 A 是平衡括号字符串。
 * <p>
 * 示例 1：
 * <p>
 * 输入： "()"
 * 输出： 1
 * 示例 2：
 * <p>
 * 输入： "(())"
 * 输出： 2
 * 示例3：
 * <p>
 * 输入： "()()"
 * 输出： 2
 * 示例4：
 * <p>
 * 输入： "(()(()))"
 * 输出： 6
 */
public class Main {
    public static void main(String[] args) {
        String s = "()()";
        System.out.println(scoreOfParentheses(s));
    }

    public static int scoreOfParentheses(String s) {
        Deque<Integer> st = new ArrayDeque<Integer>();
        st.push(0);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                st.push(0);
            } else {
                int v = st.pop();
                int top = st.pop() + Math.max(2 * v, 1);
                st.push(top);
            }
        }
        return st.peek();
    }

    public static int helper(String s) {
        if (s.length() == 2) {
            return 1;
        }
        int bal = 0, n = s.length(), len = 0;
        for (int i = 0; i < n; i++) {
            bal += (s.charAt(i) == '(' ? 1 : -1);
            if (bal == 0) {
                len = i + 1;
                break;
            }
        }
        if (len == n) {
            return 2 * helper(s.substring(1, n - 1));
        } else {
            return helper(s.substring(0, len)) + helper(s.substring(len));
        }
    }
}
