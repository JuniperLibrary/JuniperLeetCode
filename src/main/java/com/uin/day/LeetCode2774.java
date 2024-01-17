package com.uin.day;

import java.util.Arrays;

/**
 * @author dingchuan
 */
public class LeetCode2774 {


  public static int maximumNumberOfStringPairs2(String[] words){
    // "cd","ac","dc","ca","zz"
    int ans =0;
    boolean[][] seen = new boolean[26][26];
    for (String s : words) {
      int x = s.charAt(0) -'a';
      int y = s.charAt(1) -'a';
      if (seen[y][x]){
        ans++;
      }else {
        seen[x][y]=true;
      }
    }
    return ans;
  }

  public static int maximumNumberOfStringPairs(String[] words) {
    // 字符串words[i] 等于 words[j]的反转字符串
    // 0 <= i < j < words.length
    // 返回最大匹配数目 每个字符串最多匹配一次
    int ans = 0;
    for (int i = 0; i < words.length; i++) {
      for (int j = i + 1; j < words.length; j++){
        if (isReversed(words[i],words[j])){
          ++ans;
        }
      }
    }
    return ans;
  }

  private static boolean isReversed(String word, String word1) {
    char[] reverse = reverse(word.toCharArray(), 0, word.length());
    char[] charArray = word1.toCharArray();
    return Arrays.equals(reverse, charArray);
  }

  private static char[] reverse(char[] word,int begin,int end){
      int i = Math.max(begin, 0);
      for(int j = Math.min(word.length, end) - 1; j > i; ++i) {
        char tmp = word[i];
        word[i] = word[j];
        word[j] = tmp;
        --j;
      }
      return word;
  }



  public static void main(String[] args) {
    String[] words ={"cd","ac","dc","ca","zz"};
    System.out.print( maximumNumberOfStringPairs2(words));
  }
}
