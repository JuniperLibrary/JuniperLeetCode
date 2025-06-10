package com.lc150;

import java.util.*;

public class MaxDifference {
  public static int maxDifference(String s) {
    Map<Character, Integer> freqMap = new HashMap<>();

    for (char c : s.toCharArray()) {
      freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
    }

    Integer maxOdd = null;
    Integer minEven = null;

    // 2. 分别找最大奇数频率和最小偶数频率
    for (int count : freqMap.values()) {
      if (count % 2 == 1) {  // 奇数次
        if (maxOdd == null || count > maxOdd) {
          maxOdd = count;
        }
      } else {  // 偶数次
        if (minEven == null || count < minEven) {
          minEven = count;
        }
      }
    }

    // 3. 返回最大差值
    if (maxOdd != null && minEven != null) {
      return maxOdd - minEven;
    } else {
      return -1;  // 无法计算差值
    }
  }

  public static int maxOddEvenFreqDiff(String s) {
    Map<Character, Integer> freqMap = new HashMap<>();

    // 统计每个字符的出现频次
    for (char ch : s.toCharArray()) {
      freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
    }

    int maxOdd = Integer.MIN_VALUE;
    int minEven = Integer.MAX_VALUE;
    boolean hasOdd = false;
    boolean hasEven = false;

    // 遍历频次，找最大奇数和最小偶数
    for (int count : freqMap.values()) {
      if (count % 2 == 1) { // 奇数次
        maxOdd = Math.max(maxOdd, count);
        hasOdd = true;
      } else { // 偶数次
        minEven = Math.min(minEven, count);
        hasEven = true;
      }
    }

    // 如果都存在，返回差值；否则返回 -1
    return (hasOdd && hasEven) ? (maxOdd - minEven) : -1;
  }

  public static void main(String[] args) {
    System.out.println(maxDifference("aabbccc")); // 输出 1 （3 - 2）
    System.out.println(maxDifference("abcde"));   // 输出 -1 （无偶数频率）
  }
}
