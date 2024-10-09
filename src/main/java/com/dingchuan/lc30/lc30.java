package com.dingchuan.lc30;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class lc30 {

  public static void main(String[] args) {
    String[] words = {"foo", "bar"};
    System.out.println(new lc30().findSubstring("barfoothefoobarman", words));
  }
  public List<Integer> findSubstring(String s, String[] words) {
    int ls = s.length();            // 字符串s的长度
    int m = words.length;           // 总单词数量
    int n = words[0].length();     // 单个单词长度
    List<Integer> res = new ArrayList<>();  // 结果数组
    if (ls < m * n) {
      return res;     // 字符串s的长度小于所有单词拼接起来的长度，直接返回
    }
    // 枚举每一个切分单词的起点，共有[0, n-1]个起点
    for (int i = 0; i < n; i++) {
      Map<String, Integer> diff = new HashMap<>();    // 记录滑动窗口中每个单词和words中对应单词的个数差值，diff为空，说明滑动窗口中的单词与word一致
      String w;   // 子串
      // 从起点i开始，将前m个子串单词加入哈希表，前m个单词就是首个滑动窗口里的单词; j表示第几个单词
      for (int j = 0; j < m && i + (j + 1) * n <= ls; j++) {
        w = s.substring(i + j * n, i + (j + 1) * n);
        diff.put(w, diff.getOrDefault(w, 0) + 1);
      }
      // 遍历words，进行做差
      for (String word : words) {
        diff.put(word, diff.getOrDefault(word, 0) - 1);
        if (diff.get(word) == 0) {
          diff.remove(word);      // 单词数目为0，说明这个单词在滑动窗口和words的数目匹配，直接移除；
        }
      }
      // 移动这个长度固定为m*n的滑动窗口，左边界left为每个单词的起点，滑动窗口范围[left, left + m * n)
      for (int left = i; left <= ls - m * n; left += n) {
        // 从第二个单词开始，开始要加入新单词，移除旧单词
        if (left > i) {
          w = s.substring(left - n, left);    // 当前left的前一个单词是要移除的单词
          diff.put(w, diff.getOrDefault(w, 0) - 1);   // 滑动窗口中移除一个单词，相当于差值-1
          if (diff.get(w) == 0) {
            diff.remove(w);
          }
          w = s.substring(left + (m - 1) * n, left + m * n);  // 右边界right = left + (m - 1) * n，为要加入滑动窗口的单词的起点
          diff.put(w, diff.getOrDefault(w, 0) + 1);   // 滑动窗口中加入一个单词，相当于差值+1
          if (diff.get(w) == 0) {
            diff.remove(w);
          }
        }
        // diff为空，说明滑动窗口中的单词与word一致；left即为子串起点
        if (diff.isEmpty()) {
          res.add(left);
        }
      }
    }
    return res;
  }

}
