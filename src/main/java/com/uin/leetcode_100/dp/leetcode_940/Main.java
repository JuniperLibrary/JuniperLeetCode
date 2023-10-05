package main.java.com.uin.leetcode_100.dp.leetcode_940;

import java.util.HashMap;
import java.util.Map;

/**
 * 940. 不同的子序列 II
 * 给定一个字符串 s，计算 s 的 不同非空子序列 的个数。因为结果可能很大，所以返回答案需要对 10^9 + 7 取余 。
 * <p>
 * 字符串的 子序列 是经由原字符串删除一些（也可能不删除）字符但不改变剩余字符相对位置的一个新字符串。
 * <p>
 * 例如，"ace" 是 "abcde" 的一个子序列，但 "aec" 不是。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abc"
 * 输出：7
 * 解释：7 个不同的子序列分别是 "a", "b", "c", "ab", "ac", "bc", 以及 "abc"。
 * 示例 2：
 * <p>
 * 输入：s = "aba"
 * 输出：6
 * 解释：6 个不同的子序列分别是 "a", "b", "ab", "ba", "aa" 以及 "aba"。
 * 示例 3：
 * <p>
 * 输入：s = "aaa"
 * 输出：3
 * 解释：3 个不同的子序列分别是 "a", "aa" 以及 "aaa"。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/distinct-subsequences-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(distinctSubseqII("abc"));
    }

    public static int distinctSubseqII(String s) {
        // 记录每个字符结尾的字符串个数
        Map<Character, Integer> map = new HashMap<>();
        // 拆成字符数组
        char[] cs = s.toCharArray();
        // 记录第 i 个字符结尾时候的字符串个数
        int[] f = new int[cs.length];

        f[0] = 1;
        map.put(cs[0], 1);
        for (int i = 1; i < cs.length; i++) {
            int prevNum = f[i - 1];
            int currNum = 1 + prevNum;
            Integer oldNum = map.get(cs[i]);
            if (oldNum != null) {
                // 有重复项
                f[i] = prevNum + currNum - oldNum;
                if (f[i] < 0) {
                    f[i] += (int) (1e9 + 7);
                }
                f[i] %= ((int) (1e9 + 7));
            } else {
                // 没有重复项
                f[i] = prevNum + currNum;
                f[i] %= ((int) (1e9 + 7));
            }
            map.put(cs[i], currNum);
        }

        return f[cs.length - 1];
    }
}
