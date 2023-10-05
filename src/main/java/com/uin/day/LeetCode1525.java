package main.java.com.uin.day;

import java.util.HashSet;
import java.util.Set;

public class LeetCode1525 {

  public int numSplits(String s) {
    // 一个字符串 s
    // 满足: 将 S 分割成 2 个字符串 P 和 Q ,他们连接起来等于 S, 且
    // P 和 Q 中 不同的字符数目相等

    // 当 S 中的字符是一样的 好分割 的数目 s.length()-1;

    int len = s.length();
    char[] chars = s.toCharArray();
    Set<Character> set = new HashSet<>();
    // dp[i] 存放[0,i]子数组中所含不同的数量
    int[] dp = new int[len];

    for (int i = 0; i < len; i++) {
      set.add(chars[i]);
      // 记录 每一个字符的个数
      dp[i] = set.size();
    }

    int ans = 0;
    set = new HashSet<>();
    for (int i = len - 1; i > 0; i--) {
      set.add(chars[i]);

      if (dp[i - 1] == set.size()) {
        ans++;
      } else if (dp[i - 1] < set.size()) {
        break;
      }
    }
    return ans;
  }
}
