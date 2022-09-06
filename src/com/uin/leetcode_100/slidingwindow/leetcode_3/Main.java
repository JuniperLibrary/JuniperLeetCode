package com.uin.leetcode_100.slidingwindow.leetcode_3;

import java.util.HashMap;
import java.util.Map;

/**
 * 3. 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
public class Main {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> window = new HashMap<>();
        //滑动窗口左下标，
        int left = 0;
        int res = 0;
        // i相当于滑动窗口右下标
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //当发现重复元素的时候，窗口左指针右移
            if (window.containsKey(c)) {
                left = Math.max(window.get(c) + 1, left);
            }
            //比较两个参数的大小
            res = Math.max(res, i - left + 1);
            //再更新map中a映射的下标
            window.put(c, i);
        }
        return res;
    }
}
