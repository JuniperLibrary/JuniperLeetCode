package com.uin.leetcode_100.slidingwindow.leetcode_567;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";
        System.out.println(checkInclusion(s1, s2));
    }

    public static boolean checkInclusion(String s1, String s2) {
        int s1Len = s1.length();
        int s2Len = s2.length();

        if (s1Len > s2Len) return false;

        int[] arr1 = new int[26];
        int[] arr2 = new int[26];

        for (int i = 0; i < s1Len; i++) {
            arr1[s1.charAt(i) - 'a']++;
            arr2[s2.charAt(i) - 'a']++;
        }
        int left = 0, right = s1Len - 1;

        while (right < s2Len) {
            if (Arrays.equals(arr1, arr2)) {
                return true;
            }
            right++;
            if (right != s2Len) {
                arr2[s2.charAt(right) - 'a']++;
            }
            arr2[s2.charAt(left) - 'a']--;
            left++;
        }
        return false;
    }
}
