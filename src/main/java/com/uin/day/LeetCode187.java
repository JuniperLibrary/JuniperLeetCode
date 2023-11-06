package com.uin.day;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LeetCode187 {

  /**
   * 187. 重复的DNA序列
   * <p>
   * DNA序列 由一系列核苷酸组成，缩写为 'A', 'C', 'G' 和 'T'.。
   * <p>
   * 例如，"ACGAATTCCG" 是一个 DNA序列 。 在研究 DNA 时，识别 DNA 中的重复序列非常有用。
   * <p>
   * 给定一个表示 DNA序列 的字符串 s ，返回所有在 DNA 分子中出现不止一次的 长度为 10 的序列(子字符串)。你可以按 任意顺序 返回答案。
   * <p>
   * 输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT" 输出：["AAAAACCCCC","CCCCCAAAAA"]
   */

  public static List<String> findRepeatedDnaSequences(String s) {
    Map<String, Integer> cnt = new HashMap<>();
    List<String> ans = new ArrayList<>();
    for (int i = 0; i < s.length() - 10 + 1; i++) {
      String t = s.substring(i, i + 10);
      // 判断子序列t在map中出现的次数
      if (cnt.merge(t, 1, Integer::sum) == 2) {
        ans.add(t);
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
    log.info(s.substring(0, 10));
    log.info("重复的DNA序列:{}", findRepeatedDnaSequences(s));
  }
}
