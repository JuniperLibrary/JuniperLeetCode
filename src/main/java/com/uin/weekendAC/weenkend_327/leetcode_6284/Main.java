package com.uin.weekendAC.weenkend_327.leetcode_6284;

import java.util.HashMap;
import java.util.Map;

/**
 * 6284. 使字符串总不同字符的数目相等
 * 给你两个下标从 0 开始的字符串 word1 和 word2 。
 * <p>
 * 一次 移动 由以下两个步骤组成：
 * <p>
 * 选中两个下标i 和 j ，分别满足 0 <= i < word1.length 和 0 <= j < word2.length ，
 * 交换 word1[i] 和 word2[j] 。
 * 如果可以通过 恰好一次 移动，使 word1 和 word2 中不同字符的数目相等，则返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：word1 = "ac", word2 = "b"
 * 输出：false
 * 解释：交换任何一组下标都会导致第一个字符串中有 2 个不同的字符，而在第二个字符串中只有 1 个不同字符。
 * 示例 2：
 * <p>
 * 输入：word1 = "abcc", word2 = "aab"
 * 输出：true
 * 解释：交换第一个字符串的下标 2 和第二个字符串的下标 0 。之后得到 word1 = "abac" 和 word2 = "cab" ，各有 3 个不同字符。
 * 示例 3：
 * <p>
 * 输入：word1 = "abcde", word2 = "fghij"
 * 输出：true
 * 解释：无论交换哪一组下标，两个字符串中都会有 5 个不同字符。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= word1.length, word2.length <= 105
 * word1 和 word2 仅由小写英文字母组成。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/make-number-of-distinct-characters-equal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main {
    public boolean isItPossible(String word1, String word2) {
        // abcc
        // aab
        Map<Character, Integer> map1 = new HashMap<>(), map2 = new HashMap<>();

        for (int i = 0; i < word1.length(); i++) {
            map1.put(word1.charAt(i), map1.getOrDefault(word1.charAt(i), 0) + 1);
        }

        for (int i = 0; i < word2.length(); i++) {
            map2.put(word2.charAt(i), map2.getOrDefault(word2.charAt(i), 0) + 1);
        }

        int cnt1, cnt2, num1, num2;
        char c, d;

        for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
            c = entry.getKey();
            num1 = entry.getValue();

            for (Map.Entry<Character, Integer> characterIntegerEntry : map2.entrySet()) {
                cnt1 = map1.size();
                cnt2 = map2.size();
                d = characterIntegerEntry.getKey();
                num2 = characterIntegerEntry.getValue();

                if (c == d) {
                    if (cnt1 == cnt2) {
                        return true;
                    }
                    continue;
                }

                if (!map1.containsKey(d)) {
                    ++cnt1;
                }
                if (!map2.containsKey(c)) {
                    ++cnt2;
                }

                if (num1 == 1) {
                    cnt1--;
                }
                if (num2 == 1) {
                    cnt2--;
                }

                if (cnt1 == cnt2) {
                    return true;
                }

            }
        }
        return false;
    }
}
