package com.lc150;

public class LC14 {
  public String longestCommonPrefix(String[] strs) {
    if (strs.length == 0) {
      return "";
    }
    // 假设第一个字符串为公共前缀
    String prefix = strs[0];
    // 遍历字符串数组，将公共前缀与当前字符串比较，若不
    for (int i = 1; i < strs.length; i++) {
      // 如果当前字符串不包含公共前缀，则公共前缀长度减一
      while (strs[i].indexOf(prefix) != 0) {
        prefix = prefix.substring(0, prefix.length() - 1);
        if (prefix.isEmpty()) {
          return "";
        }
      }
    }
    return prefix;
  }

  public static void main(String[] args) {
    String[] strs = new String[]{"flower", "flow", "flight"};
    System.out.println(new LC14().longestCommonPrefix(strs));
  }
}
