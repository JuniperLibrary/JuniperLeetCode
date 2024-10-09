package com.dingchuan.lc3;

import java.util.HashSet;
import java.util.Set;

public class lc3 {

  public int lengthOfLongestSubstring(String s) {
    Set<Character> set = new HashSet<>();
    int n = s.length();
    int r = -1, ans = 0;
    for (int i = 0; i < n; i++) {
      if (i != 0) {
        // 左指针向右移动一格 移除一个字符
        set.remove(s.charAt(i - 1));
      }
      while (r + 1 < n && !set.contains(s.charAt(s.charAt(r + 1)))) {
        set.add(s.charAt(r + 1));
        ++r;
      }
      ans = Math.max(ans, r - i + 1);
    }
    return ans;
  }

  public static void main(String[] args) {
    System.out.println(new lc3().lengthOfLongestSubstring("abcabcbb"));
  }


  public void slidingWindowTemplates(String s) {
    int n = s.length();
    // 外层循环扩展右边界，内层循环扩展左边界
    for (int left = 0, right = 0; right < n; right++) {
      // 当前考虑的元素
      while (left <= right && check()) {
        // 扩展左边界
      }
      // 区间[left,right] 符合题意 统计相关信息
    }
  }

  private boolean check() {
    return false;
  }

  public int lengthOfLongestSubstring2(String s) {
    char[] charArray = s.toCharArray();
    Set<Character> set = new HashSet<>();

    int ans = 0;
    for (int left = 0, right = 0; right < charArray.length; right++) {
      while (set.contains(charArray[right])) {
        set.remove(charArray[left]);
        left++;
      }
      set.add(charArray[right]);
      ans = Math.max(ans, right - left + 1);
    }
    return ans;
  }

}
