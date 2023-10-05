package main.java.com.uin.leetcode_100.string.leetcode_791;

import java.util.Arrays;

/**
 * 791. 自定义字符串排序
 * 给定两个字符串 order 和 s 。order 的所有单词都是 唯一 的，并且以前按照一些自定义的顺序排序。
 * <p>
 * 对 s 的字符进行置换，使其与排序的 order 相匹配。更具体地说，如果在 order 中的字符 x 出现字符 y 之前，那么在排列后的字符串中， x 也应该出现在 y 之前。
 * <p>
 * 返回 满足这个性质的 s 的任意排列 。
 * 示例 1:
 * <p>
 * 输入: order = "cba", s = "abcd"
 * 输出: "cbad"
 * 解释:
 * “a”、“b”、“c”是按顺序出现的，所以“a”、“b”、“c”的顺序应该是“c”、“b”、“a”。
 * 因为“d”不是按顺序出现的，所以它可以在返回的字符串中的任何位置。“dcba”、“cdba”、“cbda”也是有效的输出。
 * 示例 2:
 * <p>
 * 输入: order = "cbafg", s = "abcd"
 * 输出: "cbad"
 * 1 <= order.length <= 26
 * 1 <= s.length <= 200
 * order和s由小写英文字母组成
 * order中的所有字符都 不同
 */
public class Main {
    public static String customSortString(String order, String s) {
        int[] arr = new int[26];
        Arrays.fill(arr, 30);
        for (int i = 0; i < order.length(); i++) {
            arr[order.charAt(i) - 97] = i;
        }
        Character[] c = new Character[s.length()];
        for (int i = 0; i < s.length(); i++) {
            c[i] = s.charAt(i);
        }
        Arrays.sort(c, (a, b) -> arr[a - 97] - arr[b - 97]);
        String ans = "";
        for (int i = 0; i < c.length; i++) {
            ans += c[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(help("cba", "abcd"));
    }

    public static String help(String order, String s) {
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            ++freq[ch - 'a'];
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < order.length(); ++i) {
            char ch = order.charAt(i);
            while (freq[ch - 'a'] > 0) {
                ans.append(ch);
                freq[ch - 'a']--;
            }
        }
        for (int i = 0; i < 26; ++i) {
            while (freq[i] > 0) {
                ans.append((char) (i + 'a'));
                freq[i]--;
            }
        }
        return ans.toString();
    }
}
