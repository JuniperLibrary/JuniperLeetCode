package com.uin.level.leetcode_205;

import java.util.HashMap;

/**
 * 同构字符串
 * 输入：s = "egg", t = "add"
 * 输出：true
 */
public class Main {
    public static void main(String[] args) {
        helper("egg", "add");
    }

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                if (map.containsValue(t.charAt(i))) {
                    return false;
                }
                map.put(s.charAt(i), t.charAt(i));
            } else {
                if (map.get(s.charAt(i)) != t.charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean helper(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) return false;
        HashMap<Character, Character> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);
            if (map.containsKey(a)) {
                if (map.get(a) == b) {
                    continue;
                } else {
                    return false;
                }
            } else {
                if (map.containsValue(b)) {
                    return false;
                } else {
                    map.put(a, b);
                }
            }
        }
        return true;
    }
}
