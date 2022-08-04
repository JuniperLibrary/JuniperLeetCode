package com.uin.leetcode_100.array.leetcode_128;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wanglufei
 */
public class Main {
    /**
     * 时间复杂度为 O(n) 的算法
     */
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int longestStreak = 0;
        for (Integer integer : set) {
            if (!set.contains(integer - 1)){
                int currentNum=integer;
                int currentStreak = 1;

                while (set.contains(currentNum+1)){
                    currentNum++;
                    currentStreak++;
                }
                longestStreak=Math.max(longestStreak,currentStreak);
            }
        }
        return longestStreak;
    }
}
