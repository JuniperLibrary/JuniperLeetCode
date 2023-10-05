package com.uin.leetcode_100.string.leetcode_1662;

/**
 * 1662. 检查两个字符串数组是否相等
 * 给你两个字符串数组 word1 和 word2 。如果两个数组表示的字符串相同，返回 true ；否则，返回 false 。
 * <p>
 * 数组表示的字符串是由数组中的所有元素 按顺序 连接形成的字符串。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：word1 = ["ab", "c"], word2 = ["a", "bc"]
 * 输出：true
 * 解释：
 * word1 表示的字符串为 "ab" + "c" -> "abc"
 * word2 表示的字符串为 "a" + "bc" -> "abc"
 * 两个字符串相同，返回 true
 * 示例 2：
 * <p>
 * 输入：word1 = ["a", "cb"], word2 = ["ab", "c"]
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：word1  = ["abc", "d", "defg"], word2 = ["abcddefg"]
 * 输出：true
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/check-if-two-string-arrays-are-equivalent
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        return join(word1).equals(join(word2));
    }

    private Object join(String[] word1) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String string : word1) {
            stringBuilder.append(string);
        }
        return stringBuilder.toString();
    }
}
