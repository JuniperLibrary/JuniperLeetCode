package com.uin.leetcode_100.string.leetcode_2287;

import java.util.HashMap;
import java.util.Map;

/**
 * 2287. 重排字符形成目标字符串
 * 给你两个下标从 0 开始的字符串 s 和 target 。你可以从 s 取出一些字符并将其重排，得到若干新的字符串。
 * <p>
 * 从 s 中取出字符并重新排列，返回可以形成 target 的 最大 副本数。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "i l o v e c o d i n g o n l e e t c o d e", target = "code"
 * 输出：2
 * 解释：
 * 对于 "code" 的第 1 个副本，选取下标为 4 、5 、6 和 7 的字符。
 * 对于 "code" 的第 2 个副本，选取下标为 17 、18 、19 和 20 的字符。
 * 形成的字符串分别是 "ecod" 和 "code" ，都可以重排为 "code" 。
 * 可以形成最多 2 个 "code" 的副本，所以返回 2 。
 * 示例 2：
 * <p>
 * 输入：s = "abcba", target = "abc"
 * 输出：1
 * 解释：
 * 选取下标为 0 、1 和 2 的字符，可以形成 "abc" 的 1 个副本。
 * 可以形成最多 1 个 "abc" 的副本，所以返回 1 。
 * 注意，尽管下标 3 和 4 分别有额外的 'a' 和 'b' ，但不能重用下标 2 处的 'c' ，所以无法形成 "abc" 的第 2 个副本。
 * 示例 3：
 * <p>
 * 输入：s = "abbaccaddaeea", target = "aaaaa"
 * 输出：1
 * 解释：
 * 选取下标为 0 、3 、6 、9 和 12 的字符，可以形成 "aaaaa" 的 1 个副本。
 * 可以形成最多 1 个 "aaaaa" 的副本，所以返回 1 。
 *
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 100
 * 1 <= target.length <= 10
 * s 和 target 由小写英文字母组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/rearrange-characters-to-make-target-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main {
    public static void main(String[] args) {
        rearrangeCharacters("ilovecodingonleetcode", "code");
    }

    public static int rearrangeCharacters(String s, String target) {
        // 输入：s = "i l o v e c o d i n g o n l e e t c o d e"
        // target = "code"

        int ans = Integer.MAX_VALUE;
        // 利用哈希表 进行字符映射
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // 统计目标字符的最大副本
        // 利用哈希表进行字符映射
        Map<Character, Integer> map1 = new HashMap<>();
        for (char c : target.toCharArray()) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }


        for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
            Character key = entry.getKey();
            Integer tCount = entry.getValue();
            int sCount = map.containsKey(key) ? map.get(key) : 0;
            int i = sCount / tCount;
            ans = Math.min(ans, i);
            if (ans == 0) {
                return ans;
            }
        }
        return ans;
    }

    public static int solution(String s, String target) {
        // 利用数组对字符进行哈希
        int[] sCnt = new int[26];
        int[] tCnt = new int[26];

        for (int i = 0; i < s.length(); i++) {
            sCnt[s.charAt(i) - 'a']++;
            // sCnt[i++] = s.charAt(i) - 'a';
        }

        for (int i = 0; i < target.length(); i++) {
            tCnt[target.charAt(i) - 'a']++;
            //tCnt[i++] = s.charAt(i) - 'a';
        }

        int ans = s.length();
        for (int i = 0; i < 26; i++) {
            if (tCnt[i] == 0) {
                continue;
            }
            ans = Math.min(ans, sCnt[i] / tCnt[i]);
        }
        return ans;
    }
}
