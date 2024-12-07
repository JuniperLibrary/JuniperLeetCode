package com.dingchuan;

import lombok.extern.slf4j.Slf4j;

/**
 * 709. 转换成小写字母
 * <p>
 * 给你一个字符串 s ，将该字符串中的大写字母转换成相同的小写字母，返回新的字符串
 * <p>
 * 输入：s = "Hello"
 * <p>
 * 输出："hello"
 */
@Slf4j
public class ToLowerCase {

  public String toLowerCase(String s) {
    StringBuilder sb = new StringBuilder();
    char[] charArray = s.toCharArray();
    for (char c : charArray) {
      // 大写字母 A - Z 的 ASCII 码范围为 [65,90]：
      // 小写字母 a - z 的 ASCII 码范围为 [97,122]。
      if (c >= 65 && c <= 90) {
        c |= 32;
      }
      sb.append(c);
    }
    return sb.toString();
  }

  public String toLowerCase2(String s) {
    StringBuilder sb = new StringBuilder();
    char[] charArray = s.toCharArray();
    for (char c : charArray) {
      if (c >= 'A' && c <= 'Z') {
        c += 'a' - 'A';
      }
      sb.append(c);
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    log.info("result:{}", new ToLowerCase().toLowerCase("Hello"));
    log.info("result:{}", new ToLowerCase().toLowerCase2("Hello"));
  }
}
