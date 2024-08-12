package com.dingchuan;

/**
 * 实现一个魔法字典
 */
public class MagicDictionary {

  private String[] words;


  public MagicDictionary() {

  }

  /**
   * 使用字符串数组 dictionary 设定该数据结构，dictionary 中的字符串互不相同
   *
   * @param dictionary
   */
  public void buildDict(String[] dictionary) {
    words = dictionary;
  }

  /**
   * 给定一个字符串 searchWord ，判定能否只将字符串中 一个 字母换成另一个字母，使得所形成的新字符串能够与字典中的任一字符串匹配。如果可以，返回 true ；否则，返回 false 。
   *
   * @param searchWord
   * @return
   */
  public boolean search(String searchWord) {
    for (String word : words) {
      if (word.length() != searchWord.length()) {
        continue;
      }
      int diff = 0;
      for (int i = 0; i < word.length(); i++) {
        if (word.charAt(i) != searchWord.charAt(i)) {
          ++diff;
          if (diff > 1) {
            break;
          }
        }
      }
      if (diff == 1) {
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    MagicDictionary magicDictionary = new MagicDictionary();
    magicDictionary.buildDict(new String[]{"hello", "hallo", "leetcode"});
    System.out.println(magicDictionary.search("hello"));
    System.out.println(magicDictionary.search("hhllo"));
    System.out.println(magicDictionary.search("hell"));
    System.out.println(magicDictionary.search("leetcoded"));
  }
}
