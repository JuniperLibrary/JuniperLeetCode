package com.dingchuan.lc392;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class lc392 {

  public static boolean isSubsequence(String s, String t) {
    int indexS = 0; // 指向 s 的当前位置
    int indexT = 0; // 指向 t 的当前位置

    while (indexS < s.length() && indexT < t.length()) {
      if (s.charAt(indexS) == t.charAt(indexT)) {
        indexS++; // 当字符匹配时，s 的指针向前移动
      }
      indexT++; // 不论是否匹配，t 的指针都向前移动
    }

    // 如果 indexS 已经到达 s 的末尾，则 s 是 t 的子序列
    return indexS == s.length();
  }

  public static void main(String[] args) {
    String s = "ace";
    String t = "abcde";
    log.info("{}", isSubsequence(s, t)); // 输出 true

    s = "aec";
    t = "abcde";
    log.info("{}", isSubsequence(s, t)); // 输出 false
  }
}
