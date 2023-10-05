package com.uin.leetcode_100.string.leetcode_58;

/**
 * 58. 最后一个单词的长度
 * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
 * <p>
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/length-of-last-word
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main {
    public int lengthOfLastWord(String s) {
        String[] split = s.split(" ");
        return split[split.length - 1].length();
    }
}
