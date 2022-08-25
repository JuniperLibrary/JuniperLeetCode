package com.uin.level.leetcode_844;

/**
 * 844. 比较含退格的字符串
 * 给定 s 和 t 两个字符串，当它们分别被输入到空白的文本编辑器后，如果两者相等，返回 true 。# 代表退格字符。
 * <p>
 * 注意：如果对空文本输入退格字符，文本继续为空。
 * ——————————————————————————————————————
 * 输入：s = "ab#c", t = "ad#c"
 * 输出：true
 * 解释：s 和 t 都会变成 "ac"。
 */
public class Main {
    /**
     * 双指针
     *
     * @param s
     * @param t
     * @return boolean
     * @author wanglufei
     * @date 2022/8/25 10:07 AM
     */
    public boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1;
        int j = t.length() - 1;

        int skS = 0, skT = 0;

        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (s.charAt(i) == '#') {
                    skS++;
                    i--;
                } else if (skS > 0) {
                    skS--;
                    i--;
                } else {
                    break;
                }
            }

            while (j >= 0) {
                if (t.charAt(j) == '#') {
                    skT++;
                    j--;
                } else if (skT > 0) {
                    skT--;
                    j--;
                } else {
                    break;
                }
            }

            if (i >= 0 && j >= 0) {
                if (s.charAt(i) != t.charAt(j)) {
                    return false;
                }
            } else {
                if (i >= 0 || j >= 0) {
                    return false;
                }
            }
            i--;
            j--;
        }
        return true;
    }

    /**
     * 重构字符串
     *
     * @param s
     * @param t
     * @return boolean
     * @author wanglufei
     * @date 2022/8/25 9:49 AM
     */
    public static boolean solve(String s, String t) {
        return build(s).equals(build(t));
    }

    private static String build(String s) {
        StringBuffer sb = new StringBuffer();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char at = s.charAt(i);
            if (at != '#') {
                sb.append(at);
            } else {
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        solve("ab#c", "ad#c");
    }
}
