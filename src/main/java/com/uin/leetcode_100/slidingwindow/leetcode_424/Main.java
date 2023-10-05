package main.java.com.uin.leetcode_100.slidingwindow.leetcode_424;

/**
 * 424. 替换后的最长重复字符
 * 给你一个字符串 s 和一个整数 k 。你可以选择字符串中的任一字符，并将其更改为任何其他大写英文字符。该操作最多可执行 k 次。
 * <p>
 * 在执行上述操作后，返回包含相同字母的最长子字符串的长度。
 * 输入：s = "ABAB", k = 2
 * 输出：4
 * 解释：用两个'A'替换为两个'B',反之亦然。
 * ——————————————————————————————————————————————————
 * 输入：s = "AABABBA", k = 1
 * 输出：4
 * 解释：
 * 将中间的一个'A'替换为'B',字符串变为 "AABBBBA"。
 * 子串 "BBBB" 有最长重复字母, 答案为 4。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/longest-repeating-character-replacement
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main {
    public int characterReplacement(String s, int k) {
        int len = s.length();
        if (len < k) return len;

        char[] chars = s.toCharArray();
        int[] freq = new int[26];
        int maxCount = 0;
        int left = 0;
        int right = 0;
        //  [left,right)  内最多替换k个字符可以得到的只有一种字符串
        while (right < len) {
            freq[chars[right] - 'A']++;
            maxCount = Math.max(maxCount, freq[chars[right] - 'A']);
            right++;

            if (right - left > maxCount + k) {
                freq[chars[left] - 'A']--;
                left++;
            }
        }
        return right - left;
    }
}
