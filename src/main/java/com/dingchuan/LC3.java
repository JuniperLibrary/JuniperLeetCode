package com.dingchuan;

import java.util.HashSet;
import java.util.Set;

public class LC3 {

  public int lengthOfLongestSubstring(String s) {
    Set<Character> occ = new HashSet<>();
    int n = s.length();
    // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
    int right = -1, ans = 0;
    for (int i = 0; i < n; ++i) {
      if (i != 0) {
        // 左指针向右移动一格，移除一个字符
        occ.remove(s.charAt(i - 1));
      }
      // 不断地移动右指针
      while (right + 1 < n && !occ.contains(s.charAt(right + 1))) {
        occ.add(s.charAt(right + 1));
        ++right;
      }
      // 第 i 到 right 个字符是一个极长的无重复字符子串
      ans = Math.max(ans, right - i + 1);
    }
    return ans;
  }

  public static void main(String[] args) {
    System.out.println(new LC3().lengthOfLongestSubstring("abcabcbb"));
    System.out.println(new LC3().lengthOfLongestSubstring("bbbbb"));
    System.out.println(new LC3().lengthOfLongestSubstring("pwwkew"));
  }
}
