package com.lc150;

public class answerString {

  public String answerString(String word, int numFriends) {
    if (numFriends == 1) {
      return word;
    }
    int n = word.length();
    String ans = "";
    for (int i = 0; i < n; i++) {
      String substring = word.substring(i, Math.min(i + n - numFriends + 1, n));
      if (ans.compareTo(substring) <= 0) {
        ans = substring;
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    answerString a = new answerString();
    System.out.println(a.answerString("abc", 1));
    System.out.println(a.answerString("abc", 2));
    System.out.println(a.answerString("abcde", 3));
    System.out.println(a.answerString("gggg", 4));
    System.out.println(a.answerString("dbca", 2));
  }
}
