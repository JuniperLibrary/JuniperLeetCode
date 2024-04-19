package com.lc150;

public class LC58 {
  public int lengthOfLastWord(String s) {
    String[] s1 = s.split(" ");
    return s1[s1.length-1].length();
  }
//  public static void main(String[] args) {
//    LC58 lc58 = new LC58();
//    System.out.println(lc58.lengthOfLastWord("   fly me   to   the moon  "));
//  }

  public int lengthOfLastWord1(String s) {
    int end = s.length()-1;
    // 去除末尾的空格
    while (end >=0 && s.charAt(end) == ' '){
      // 找到最后一个单词的末尾
      end--;
    }
    // 如果字符串全是空格，返回0
    if (end < 0){
      return 0;
    }
    // 找到最后一个单词的开头
    int start = end;
    // 找到最后一个单词的开头
    while (start >= 0 && s.charAt(start) != ' '){
      // 找到最后一个单词的开头
      start--;
    }
    return end -start;
  }

  public static void main(String[] args) {
    LC58 lc58 = new LC58();
    System.out.println(lc58.lengthOfLastWord1("   fly me   to   the moon  "));
  }

}
