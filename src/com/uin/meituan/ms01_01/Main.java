package com.uin.meituan.ms01_01;

/**
 * 面试题 01.01. 判定字符是否唯一
 * 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
 * 输入: s = "leetcode"
 * 输出: false
 */
public class Main {
    public static void main(String[] args) {
        String s = "leetcode";
        isUnique(s);
    }

    /**
     * 遍历
     *
     * @param astr
     * @return boolean
     * @author wanglufei
     * @date 2022/9/2 10:14 AM
     */
    public static boolean isUnique(String astr) {
        char[] chars = astr.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] == chars[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 位运算
     *
     * @param s
     * @return boolean
     * @author wanglufei
     * @date 2022/9/2 10:14 AM
     */
    public boolean helper(String s) {
        long low64 = 0;
        long high64 = 0;

        for (char c : s.toCharArray()) {
            if (c >= 64) {
                long bitIndex = 1L << (c - 64);
                if ((high64 & bitIndex) != 0) {
                    return false;
                }
                high64 |= bitIndex;
            } else {
                long bitIndex = 1L << c;
                if ((low64 & bitIndex) != 0) {
                    return false;
                }

                low64 |= bitIndex;
            }
        }
        return true;
    }
}
