package com.uin.day;

import lombok.extern.slf4j.Slf4j;

/**
 * 318. 最大单词长度乘积
 * <p>
 * 给你一个字符串数组 words ，找出并返回 length(words[i]) * length(words[j])的最大值，并且这两个单词不含有公共字母。
 * <p>
 * 如果不存在这样的两个单词，返回 0 。
 * <p>
 * 输入：words = ["abcw","baz","foo","bar","xtfn","abcdef"]
 * <p>
 * 输出：16
 * <p>
 * 解释：这两个单词为 "abcw", "xtfn"。
 */
@Slf4j
public class LeetCode318 {

  public static int maxProduct(String[] words) {
    int length = words.length;
    int[] masks = new int[length];
    for (int i = 0; i < length; i++) {
      String word = words[i];
      int wordLength = word.length();
      for (int j = 0; j < wordLength; j++) {
        masks[i] |= 1 << (word.charAt(j) - 'a');
      }
    }
    int maxProd = 0;
    for (int i = 0; i < length; i++) {
      for (int j = i + 1; j < length; j++) {
        if ((masks[i] & masks[j]) == 0) {
          maxProd = Math.max(maxProd, words[i].length() * words[j].length());
        }
      }
    }
    return maxProd;
  }

  public static void main(String[] args) {
    String[] words ={"abcw","baz","foo","bar","xtfn","abcdef"};
    log.info("如果两个字符串没有公共字母，那么这两个字符串对应的二进制数的按位与的结果为0ans:{}",'a' & 'a');
    log.info("如果两个字符串没有公共字母，那么这两个字符串对应的二进制数的按位与的结果为ans:{}",'a' & 'b');
    log.info("最大单词长度乘积:{}",maxProduct(words));
  }
}
