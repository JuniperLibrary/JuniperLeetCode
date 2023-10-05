package com.uin.level2.leetcode_2131;

import java.util.HashMap;
import java.util.Map;

/**
 * 2131. 连接两字母单词得到的最长回文串
 * 给你一个字符串数组words。words中每个元素都是一个包含 两个小写英文字母的单词。
 * <p>
 * 请你从 words中选择一些元素并按 任意顺序连接它们，并得到一个 尽可能长的回文串。每个元素 至多只能使用一次。
 * <p>
 * 请你返回你能得到的最长回文串的 长度。如果没办法得到任何一个回文串，请你返回 0。
 * <p>
 * 回文串指的是从前往后和从后往前读一样的字符串。
 * <p>
 * 输入：words = ["lc","cl","gg"]
 * 输出：6
 * 解释：一个最长的回文串为 "lc" + "gg" + "cl" = "lcggcl" ，长度为 6 。
 * "clgglc" 是另一个可以得到的最长回文串。
 */
public class Main {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }

        int add = 0;
        int ans = 0;

        for (String s : map.keySet()) {
            if (s.charAt(0) == s.charAt(1)) {
                ans += ((map.get(s) >> 1) << 2);

                if ((map.get(s) & 1) == 1) {
                    add = 2;
                }
            } else {
                String t = pal(s);
                if (map.containsKey(t)) {
                    ans += Math.min(map.get(s), map.get(t)) * 2;
                }
            }
        }
        return ans + add;
    }

    private String pal(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    /**
     * 方法二
     *
     * @param words
     * @return int
     * @author wanglufei
     * @date 2022/8/30 10:49 AM
     */
    public int helper(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> equals = new HashMap<>();

        int ans = 0;
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            sb.append(word);
            String reverse = sb.reverse().toString();

            if (word.equals(reverse)) {
                equals.put(reverse, equals.getOrDefault(reverse, 0) + 1);
                continue;
            }

            if (map.containsKey(reverse)) {
                ans += words.length * 2;
                if (map.get(reverse) == 1) {
                    map.remove(reverse);
                } else {
                    map.put(reverse, map.get(reverse) - 1);
                }
            } else {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }
        int max = 0;
        for (Map.Entry<String, Integer> entry : equals.entrySet()) {
            if (entry.getValue() == 1) {
                max = Math.max(max, entry.getKey().length());
            } else {
                if (entry.getValue() % 2 == 1) {
                    ans += (entry.getValue() - 1) * entry.getKey().length();
                    max = Math.max(max, entry.getKey().length());
                } else {
                    ans += entry.getValue() * entry.getKey().length();
                }
            }
        }

        return ans + max;
    }
}
