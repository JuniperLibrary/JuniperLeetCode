package main.java.com.uin.leetcode_100.string.leetcode_792;

import java.util.ArrayList;
import java.util.List;

/**
 * 792. 匹配子序列的单词数
 * 给定字符串 s 和字符串数组 words, 返回  words[i] 中是s的子序列的单词个数 。
 * <p>
 * 字符串的 子序列 是从原始字符串中生成的新字符串，可以从中删去一些字符(可以是none)，而不改变其余字符的相对顺序。
 * <p>
 * 例如， “ace” 是 “abcde” 的子序列。
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "abcde", words = ["a","bb","acd","ace"]
 * 输出: 3
 * 解释: 有三个是 s 的子序列的单词: "a", "acd", "ace"。
 * Example 2:
 * <p>
 * 输入: s = "dsahjpjauf", words = ["ahjpjau","ja","ahbwzgqnuk","tnmlanowax"]
 * 输出: 2
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= s.length <= 5 * 104
 * 1 <= words.length <= 5000
 * 1 <= words[i].length <= 50
 * words[i]和 s 都只由小写字母组成。
 */
public class Main {
    public static void main(String[] args) {
        String s = "abcde";
        String[] words = {"a", "bb", "acd", "ace"};
        System.out.println(helper(s, words));
    }

    public static int numMatchingSubseq(String s, String[] words) {
        int ans = 0;
        for (int i = 0; i < words.length; i++) {
            if (isSubSeq(s, words[i])) {
                ans++;
            }
        }
        return ans;
    }

    private static boolean isSubSeq(String s, String word) {
        int m = s.length(), n = word.length(), i = 0, j = 0;
        while (i < m && j < n) {
            char c = word.charAt(j);
            while (i < m && s.charAt(i) != c) {
                i++;
            }
            if (i == m) {
                return false;
            }
            i++;
            j++;
        }
        return j == n;
    }

    public static int helper(String s, String[] words) {
        List<Integer>[] pos = new List[26];
        for (int i = 0; i < 26; i++) {
            pos[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < s.length(); i++) {
            pos[s.charAt(i) - 'a'].add(i);
        }

        int res = words.length;
        for (String word : words) {
            if (word.length() > s.length()) {
                --res;
                continue;
            }

            int p = -1;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (pos[c - 'a'].isEmpty() || pos[c - 'a'].get(pos[c - 'a'].size() - 1) <= p) {
                    --res;
                    break;
                }
                p = binarySearch(pos[c - 'a'], p);
            }
        }
        return res;
    }

    private static int binarySearch(List<Integer> list, int target) {
        int left = 0, right = list.size() - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return list.get(left);
    }
}
