package main.java.com.uin.leetcode_100.slidingwindow.leetcode_3;

import java.util.HashMap;
import java.util.Map;

/**
 * 3. 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */

/**
 * 1、首先，判断当前字符是否包含在map中，如果不包含，将该字符添加到map（字符，字符在数组下标）,
 * 此时没有出现重复的字符，左指针不需要变化。此时不重复子串的长度为：i-left+1，与原来的maxLen比较，取最大值；
 * <p>
 * 2、如果当前字符 ch 包含在 map中，此时有2类情况：
 * 1）当前字符包含在当前有效的子段中，如：abca，当我们遍历到第二个a，当前有效最长子段是 abc，我们又遍历到a，
 * 那么此时更新 left 为 map.get(a)+1=1，当前有效子段更新为 bca；
 * 2）当前字符不包含在当前最长有效子段中，如：abba，我们先添加a,b进map，此时left=0，我们再添加b，发现map中包含b，
 * 而且b包含在最长有效子段中，就是1）的情况，我们更新 left=map.get(b)+1=2，此时子段更新为 b，而且map中仍然包含a，map.get(a)=0；
 * 随后，我们遍历到a，发现a包含在map中，且map.get(a)=0，如果我们像1）一样处理，就会发现 left=map.get(a)+1=1，实际上，left此时
 * 应该不变，left始终为2，子段变成 ba才对。
 * <p>
 * 为了处理以上2类情况，我们每次更新left，left=Math.max(left , map.get(ch)+1).
 * 另外，更新left后，不管原来的 s.charAt(i) 是否在最长子段中，我们都要将 s.charAt(i) 的位置更新为当前的i，
 * 因此此时新的 s.charAt(i) 已经进入到 当前最长的子段中！
 */
public class Main {
    public int lengthOfLongestSubstring(String s) {
        // 哈希集合，记录每个字符是否出现过
        Map<Character, Integer> window = new HashMap<>();
        // 滑动窗口左指针
        int left = 0;
        // 用于记录最大不重复子串的长度
        int maxLen = 0;
        // i相当于滑动窗口右下标
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 当发现重复元素的时候，窗口左指针右移
            if (window.containsKey(c)) {
                left = Math.max(window.get(c) + 1, left);
            }
            // 比较两个参数的大小
            maxLen = Math.max(maxLen, i - left + 1);
            // 再更新map中a映射的下标
            window.put(c, i);
        }
        return maxLen;
    }
}
