package com.uin.leetcode_100.array.LeetCode_49;

import java.util.*;

/**
 * 49. 字母异位词分组
 *
 * @author dingchuan
 */
public class Solution {

  public List<List<String>> groupAnagrams(String[] strs) {
    List<List<String>> res = new ArrayList<>();
    if (strs == null) {
      return res;
    }

    Map<String, List<String>> map = new HashMap<>();
    for (int i = 0; i < strs.length; i++) {
      char[] curr = strs[i].toCharArray();
      Arrays.sort(curr);
      String key = String.valueOf(curr);
      if (!map.containsKey(key)) {
        map.put(key, new ArrayList<>());
      }
      map.get(key).add(strs[i]);
    }
    for (List<String> value : map.values()) {
      res.add(new ArrayList<>(value));
    }
    return res;
  }

  public List<List<String>> groupAnagrams2(String[] strs) {
    Map<String, List<String>> map = new HashMap<>();
    for (String str : strs) {
      char[] array = str.toCharArray();
      Arrays.sort(array);
      String key = new String(array);
      List<String> list = map.getOrDefault(key, new ArrayList<>());
      list.add(str);
      map.put(key, list);
    }
    return new ArrayList<>(map.values());
  }

  public static void main(String[] args) {
    String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
    System.out.println(new Solution().groupAnagrams(strs));

    System.out.println(new Solution().groupAnagrams2(strs));
  }
}
