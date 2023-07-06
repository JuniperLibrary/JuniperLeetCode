package com.uin.leetcode_100.greedy.leetcode_1234;

/**
 * 1234. 替换子串得到平衡字符串 有一个只含有'Q', 'W', 'E','R'四种字符，且长度为 n的字符串。
 * <p>
 * 假如在该字符串中，这四个字符都恰好出现n/4次，那么它就是一个「平衡字符串」。
 * <p>
 * 
 * <p>
 * 给你一个这样的字符串 s，请通过「替换一个子串」的方式，使原字符串 s 变成一个「平衡字符串」。
 * <p>
 * 你可以用和「待替换子串」长度相同的任何 其他字符串来完成替换。
 * <p>
 * 请返回待替换子串的最小可能长度。
 * <p>
 * 如果原字符串自身就是一个平衡字符串，则返回 0。 示例 1：
 * <p>
 * 输入：s = "QWER" 输出：0 解释：s 已经是平衡的了。 示例 2：
 * <p>
 * 输入：s = "QQWE" 输出：1 解释：我们需要把一个 'Q' 替换成 'R'，这样得到的 "RQWE" (或 "QRWE") 是平衡的。
 */
public class Main {

  public static void main(String[] args) {
    balancedString("QQQW");
  }

  public static int balancedString(String s) {
    char[] chars = s.toCharArray();
    char[] cnt = new char['X'];
    for (char c : chars) {
      ++cnt[c];
    }
    int n = chars.length, m = n / 4;
    if (cnt['Q'] == m && cnt['W'] == m && cnt['E'] == m && cnt['R'] == m) {
      return 0;
    }
    int ans = n, left = 0;
    for (int right = 0; right < n; right++) {
      --cnt[chars[right]];
      while (cnt['Q'] <= m && cnt['W'] <= m && cnt['E'] <= m && cnt['R'] <= m) {
        ans = Math.min(ans, right - left + 1);
      }
    }
    return ans;
  }
}
