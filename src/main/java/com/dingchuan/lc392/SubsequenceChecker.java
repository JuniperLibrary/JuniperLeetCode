package com.dingchuan.lc392;

import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

/**
 * 如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。
 * <p>
 * 在这种情况下，你会怎样改变代码？
 * <p>
 * 当面对大量输入字符串 S1, S2, ..., Sk（其中 k >= 10亿），并且需要检查它们是否为字符串 T 的子序列时，我们需要考虑性能优化。这里有几个策略可以采用：
 * <p>
 * 1. 缓存已检查的结果：如果多个字符串 Si 包含相同的子序列，那么可以缓存之前计算的结果以避免重复计算。
 * <p>
 * 2. 使用索引结构：构建一个索引结构来加速查找过程，例如使用字典树（Trie）来存储 T 的所有子串的起始位置。
 * <p>
 * 3. 多线程处理：利用多线程并行处理不同的字符串，以减少总的处理时间。
 */
@Slf4j
public class SubsequenceChecker {

  private final String t;
  private final Map<String, Boolean> cache = new HashMap<>();

  public SubsequenceChecker(String t) {
    this.t = t;
  }

  public boolean isSubsequence(String s) {
    if (cache.containsKey(s)) {
      return cache.get(s);
    }

    int indexS = 0;
    int indexT = 0;

    while (indexS < s.length() && indexT < t.length()) {
      if (s.charAt(indexS) == t.charAt(indexT)) {
        indexS++;
      }
      indexT++;
    }
    boolean result = indexS == s.length();
    cache.put(s, result); // 缓存结果
    return result;
  }

  public static void main(String[] args) {
    String t = "abcde";
    SubsequenceChecker checker = new SubsequenceChecker(t);

    // 示例数据
    String[] sList = {"ace", "aec", "abc", "ade"};

    for (String s : sList) {
      log.info("Is \"" + s + "\" a subsequence of \"" + t + "\": {} ", checker.isSubsequence(s));
    }
  }
}
