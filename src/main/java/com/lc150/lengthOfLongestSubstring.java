package com.lc150;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import java.util.HashSet;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class lengthOfLongestSubstring {

  public int solution(String s) {
    char[] charArray = s.toCharArray();
    Set<Character> set = new HashSet<>();

    int ans = 0;

    for (int left = 0, right = 0; right < charArray.length; right++) {
      char c = charArray[right];
      while (set.contains(c)) {
        char c1 = charArray[left];
        set.remove(c1);
        left++;
      }
      set.add(c);
      ans = Math.max(ans, right - left + 1);
    }
    log.info(JSONUtil.toJsonStr(set));
    return ans;
  }

  public static void main(String[] args) {
    int abcabcbb = new lengthOfLongestSubstring().solution("abcabcbb");
    log.info("无重复的最长子串:{}", abcabcbb);
  }
}
