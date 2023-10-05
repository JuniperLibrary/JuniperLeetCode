package main.java.com.uin.leetcode_100.string.leetcode_2309;

import java.util.HashSet;
import java.util.Set;

/**
 * 2309. 兼具大小写的最好英文字母
 * 给你一个由英文字母组成的字符串 s ，请你找出并返回 s 中的 最好 英文字母。返回的字母必须为大写形式。如果不存在满足条件的字母，则返回一个空字符串。
 * <p>
 * 最好 英文字母的大写和小写形式必须 都 在 s 中出现。
 * <p>
 * 英文字母 b 比另一个英文字母a更好 的前提是：英文字母表中，b 在 a 之 后 出现。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "lEeTcOdE"
 * 输出："E"
 * 解释：
 * 字母 'E' 是唯一一个大写和小写形式都出现的字母。
 * 示例 2：
 * <p>
 * 输入：s = "arRAzFif"
 * 输出："R"
 * 解释：
 * 字母 'R' 是大写和小写形式都出现的最好英文字母。
 * 注意 'A' 和 'F' 的大写和小写形式也都出现了，但是 'R' 比 'F' 和 'A' 更好。
 * 示例 3：
 * <p>
 * 输入：s = "AbCdEfGhIjK"
 * 输出：""
 * 解释：
 * 不存在大写和小写形式都出现的字母。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 1000
 * s 由小写和大写英文字母组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/greatest-english-letter-in-upper-and-lower-case
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main {
    public String greatestLetter(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            set.add(c);
        }

        for (char a = 'Z'; a >= 'A'; --a) {
            if (set.contains(a) && set.contains((char) (a + 32))) {
                return String.valueOf(a);
            }
        }
        return "";
    }

    public String solution(String s) {

        int[] l = new int[26];
        int[] b = new int[26];
        for (char c : s.toCharArray()) {
            if (c >= 'a' && c <= 'z') l[c - 'a']++;
            else b[c - 'A']++;
        }
        for (int i = 25; i >= 0; i--) {
            if (l[i] > 0 && b[i] > 0) return String.valueOf((char) ('A' + i));
        }
        return "";
    }
}
