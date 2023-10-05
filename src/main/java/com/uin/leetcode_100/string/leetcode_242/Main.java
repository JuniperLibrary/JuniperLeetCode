package main.java.com.uin.leetcode_100.string.leetcode_242;

import java.util.Arrays;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * @author wanglufei
 * @date 2022/8/10 7:10 PM
 */
public class Main {
    public static void main(String[] args) {
        String s ="anagram";
        String t ="nagaram";
        System.out.println(isAnagram(s, t));
    }
    public static boolean isAnagram(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();

        if (len1 != len2) return false;

        int[] arr1 = new int[26];
        int[] arr2 = new int[26];

        for (int i = 0; i < len1; i++) {
            arr1[s.charAt(i) - 'a']++;
            arr2[t.charAt(i) - 'a']++;
        }
        return Arrays.equals(arr1, arr2);
    }
}
