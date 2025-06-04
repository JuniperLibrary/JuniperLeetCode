package com.lc150;

import java.util.*;

public class answerString2 {

  private String maxString;

  public String answerString(String word, int numFriends) {
    maxString = "";  // 初始化字典序最大字符串
    dfs(word, numFriends, 0, new ArrayList<>());
    return maxString;
  }

  private void dfs(String word, int numFriends, int start, List<String> parts) {
    if (parts.size() == numFriends) {
      if (start == word.length()) {
        for (String part : parts) {
          if (part.compareTo(maxString) > 0) {
            maxString = part;
          }
        }
      }
      return;
    }

    int remaining = numFriends - parts.size();
    // i 从 start+1 开始，至少留 enough chars 供后面每个部分1个字符
    for (int i = start + 1; i <= word.length() - (remaining - 1); i++) {
      String part = word.substring(start, i);
      parts.add(part);
      dfs(word, numFriends, i, parts);
      parts.remove(parts.size() - 1);
    }
  }

  public static void main(String[] args) {
    answerString2 solution = new answerString2();
    String result = solution.answerString("abcde", 3);
    System.out.println(result);  // 输出应为 "e"
  }
}
