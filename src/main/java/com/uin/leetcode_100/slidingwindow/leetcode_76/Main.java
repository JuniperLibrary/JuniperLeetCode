package com.uin.leetcode_100.slidingwindow.leetcode_76;

import java.util.HashMap;

/**
 * 76. 最小覆盖子串
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 ""
 * - 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * - 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 * <p>
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 */
public class Main {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));
    }

    /**
     * https://leetcode.cn/problems/minimum-window-substring/solution/leetcode-76-zui-xiao-fu-gai-zi-chuan-cja-lmqz/
     */
    public static String minWindow(String s, String t) {
        HashMap<Character, Integer> maps = new HashMap<>();
        HashMap<Character, Integer> mapt = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            mapt.put(t.charAt(i), mapt.getOrDefault(t.charAt(i), 0) + 1);
        }
        String ans = "";
        int len = 0x3f3f3f3f, cnt = 0;  //有多少个元素符合

        for (int i = 0, j = 0; i < s.length(); i++) {
            maps.put(s.charAt(i), maps.getOrDefault(s.charAt(i), 0) + 1);
            if (mapt.containsKey(s.charAt(i)) && maps.get(s.charAt(i)) <= mapt.get(s.charAt(i))) {
                cnt++;
            }
            while (j < i && (!mapt.containsKey(s.charAt(j)) || maps.get(s.charAt(j)) > mapt.get(s.charAt(j)))) {
                int count = maps.get(s.charAt(j)) - 1;
                maps.put(s.charAt(j), count);
                j++;
            }

            if (cnt == t.length() && i - j + 1 < len) {
                len = i - j + 1;
                ans = s.substring(j, i + 1);
            }

        }
        return ans;
    }
}
