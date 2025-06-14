package com.lc150;

public class canConstruct {

  public boolean canConstruct(String ransomNote, String magazine) {
    if (ransomNote.length() > magazine.length()) {
      return false;
    }
    int[] cnt = new int[26];
    for (char c : magazine.toCharArray()) {
      cnt[c - 'a']++;
    }
    for (char c : ransomNote.toCharArray()) {
      cnt[c - 'a']--;
      if (cnt[c - 'a'] < 0) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    canConstruct c = new canConstruct();
    System.out.println(c.canConstruct("aab", "baa"));
  }
}
