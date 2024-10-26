package com.dingchuan.lc383;

import lombok.extern.slf4j.Slf4j;

/**
 * @author dingchuan
 */
@Slf4j
public class Main {

  /**
   * 判断是否可以从杂志字符串中构造赎金信字符串
   *
   * @param ransomNote 赎金信字符串，需要构造的目标
   * @param magazine 杂志字符串，提供构造赎金信的字符来源
   * @return 如果可以构造赎金信，则返回true；否则返回false
   */
  public boolean canConstruct(String ransomNote, String magazine) {
      // 判断 ransomNote 能不能由 magazine 里面的字符构成。
      if (ransomNote.length()>magazine.length()){
        return false;
      }
      // 使用数组记录杂志中每个字符出现的次数
      int[] arr = new int[26];
      // 统计 magazine 里每个字符出现的次数
      for (char c : magazine.toCharArray()) {
        arr[c - 'a']++;
      }

      // 检查 ransomNote 中的每个字符是否都可以由 magazine 中的字符构成
      for (char c : ransomNote.toCharArray()) {
        // 使用数组记录 ransomNote 中每个字符出现的次数，并尝试从 magazine 中减去对应字符的出现次数
        arr[c - 'a']--;
        // 如果 magazine 里已经不包含 ransomNote 的字符，直接返回 false
        if (arr[c - 'a'] < 0) {
          return false;
        }
      }
      // 如果所有字符都可以由 magazine 构成，则返回 true
      return true;
    }

  public static void main(String[] args) {
    String ransomNote = "aab";
    String magazine = "baa";
    log.info("result : {}", new Main().canConstruct(ransomNote, magazine));
  }
}
