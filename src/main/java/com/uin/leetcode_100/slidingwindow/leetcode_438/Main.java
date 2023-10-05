package main.java.com.uin.leetcode_100.slidingwindow.leetcode_438;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 438. 找到字符串中所有字母异位词
 * 给定两个字符串s和 p，找到s中所有p的异位词的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * <p>
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 */
public class Main {
    public List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length(), pLen = p.length();

        if (sLen < pLen) {
            return new ArrayList<Integer>();
        }

        List<Integer> res = new ArrayList<Integer>();
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        for (int i = 0; i < pLen; ++i) {
            ++sCount[s.charAt(i) - 'a'];
            ++pCount[p.charAt(i) - 'a'];
        }

        if (Arrays.equals(sCount, pCount)) {
            res.add(0);
        }

        for (int i = 0; i < sLen - pLen; ++i) {
            --sCount[s.charAt(i) - 'a'];
            ++sCount[s.charAt(i + pLen) - 'a'];

            if (Arrays.equals(sCount, pCount)) {
                res.add(i + 1);
            }
        }

        return res;
    }

    public List<Integer> helper(String s, String p) {
        ArrayList<Integer> res = new ArrayList<>();
        char[] chars = p.toCharArray();
        Arrays.sort(chars);

        String s1 = new String(chars);
        for (int i = 0; i < s.length() - p.length() + 1; i++) {
            String tmp = s.substring(i, i + p.length());
            char[] chars1 = tmp.toCharArray();
            Arrays.sort(chars1);
            for (int j = 0; j < chars.length; j++) {
                if (chars[j] != chars1[j]) {
                    break;
                }
                if (j == chars.length - 1) {
                    res.add(i);
                }
            }
        }
        return res;
    }
}
