package com.uin.leetcode_100.string.leetcode_1832;

import java.util.HashSet;
import java.util.Set;

/**
 * 1832.判断句子是否为全字母句
 * 全字母句 指包含英语字母表中每个字母至少一次的句子。
 * 给你一个仅由小写英文字母组成的字符串 sentence ，请你判断sentence 是否为 全字母句 。
 * 如果是，返回 true ；否则，返回 false 。
 *
 * 示例 1：
 *
 * 输入：sentence = "thequickbrownfoxjumpsoverthelazydog"
 * 输出：true
 * 解释：sentence 包含英语字母表中每个字母至少一次。
 * 示例 2：
 *
 * 输入：sentence = "leetcode"
 * 输出：false
 * 
 *
 * 提示：
 *
 * 1 <= sentence.length <= 1000
 * sentence 由小写英语字母组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/check-if-the-sentence-is-pangram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main {
    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println(checkIfPangram(s));
    }

    public static boolean checkIfPangram(String sentence) {
        if (sentence == null) return false;

        char[] chars = sentence.toCharArray();
        Set<Character> set = new HashSet<>();

        for (char c : chars) {
            set.add(c);
        }
        return set.size() == 26;
    }


    public static boolean helper(String s) {
        boolean[] exists = new boolean[26];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            exists[c - 'a'] = true;
        }

        for (boolean exist : exists) {
            if (!exist) {
                return exist;
            }
        }
        return true;
    }
}
