package com.uin.leetcode_100.string.leetcode_5;

/**
 * leetcode 5 最长回文子串
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * ——————————————————————————————————
 */
public class Main {
    /**
     * 暴力解法
     *
     * @param s
     * @return java.lang.String
     * @author wanglufei
     * @date 2022/8/14 5:02 PM
     */
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int maxLen = 1;
        int begin = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (j - i + 1 > maxLen && validPalindromic(chars, i, j)) {
                    maxLen = j - i + 1;
                    begin = 1;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    /**
     * 验证回文字符串
     *
     * @param chars
     * @param left
     * @param right
     * @return boolean
     * @author wanglufei
     * @date 2022/8/14 5:03 PM
     */
    private boolean validPalindromic(char[] chars, int left, int right) {
        while (left < right) {
            if (chars[left] != chars[right]) {
                return false;
            }
            left++;
            right++;
        }
        return true;
    }

    /**
     * 中心扩散
     *
     * @param s
     * @return java.lang.String
     * @author wanglufei
     * @date 2022/8/14 5:05 PM
     */
    public String middleOpen(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int maxLen = 1;
        int begin = 0;
        char[] chars = s.toCharArray();

        for (int i = 0; i < len - 1; i++) {
            //奇数
            int odd = expandAroundCenter(chars, i, i);
            //偶数
            int even = expandAroundCenter(chars, i, i + 1);

            int curMaxLen = Math.max(odd, even);
            if (curMaxLen > maxLen) {
                maxLen = curMaxLen;
                //向下取整
                begin = i - (maxLen - 1) / 2;
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    /**
     * @param chars
     * @param left  左边界
     * @param right 右边界
     * @return int
     * @author wanglufei
     * @date 2022/8/14 5:08 PM
     */
    private int expandAroundCenter(char[] chars, int left, int right) {
        int length = chars.length;
        int i = left;
        int j = right;

        while (i >= 0 && j < length) {
            if (chars[i] == chars[j]) {
                i--;
                j++;
            } else {
                break;
            }
        }
        //不想等
        //回文串的长度 j-i+1-2=j-i-1
        return j - i - 1;
    }

    /**
     * 动态规划
     *
     * @param s
     * @return java.lang.String
     * @author wanglufei
     * @date 2022/8/14 5:18 PM
     */
    public String dp(String s) {
        int n = s.length();
        if (n < 2) return s;

        //为了截取字符串返回
        int maxLen = 1;
        int begin = 0;

        boolean[][] dp = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        char[] chars = s.toCharArray();

        for (int j = 1; j < n; j++) {
            for (int i = 0; i < j; i++) {
                if (chars[i] != chars[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                //记录回文长度的起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    /**
     * 马拉车算法
     *
     * @param s
     * @return java.lang.String
     * @author wanglufei
     * @date 2022/8/14 5:44 PM
     */
    public String manacher(String s) {
        return s;
    }


}
