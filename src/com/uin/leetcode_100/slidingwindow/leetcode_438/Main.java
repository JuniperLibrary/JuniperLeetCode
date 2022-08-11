package com.uin.leetcode_100.slidingwindow.leetcode_438;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();

        int plength = s.length();
        int slength = p.length();

        if (plength > slength) return res;

        int[] arrs = new int[26];
        int[] arrp = new int[26];

        for (int i = 0; i < plength; i++) {
            arrs[s.charAt(i) - 'a'] += 1;
            arrp[s.charAt(i) - 'a'] += 1;
        }

        if (Arrays.equals(arrs, arrp)) {
            res.add(0);
        }

        for (int i = 1; plength + i - 1 < slength; i++) {
            arrs[s.charAt(i - 1) - 'a'] -= 1;
            arrs[s.charAt(plength + i - 1) - 'a'] += 1;

            if (Arrays.equals(arrs, arrp)) {
                res.add(i);
            }
        }
        return res;
    }

    public List<Integer> helper(String s, String p) {
        ArrayList<Integer> res = new ArrayList<>();
        char[] chars = p.toCharArray();
        Arrays.sort(chars);

        String s1 = new String(chars);
        for (int i = 0; i < s.length() - p.length() + 1; i++) {
            String tmp = s.substring(i, i + p.length());
            char[] chars1 = tmp.toCharArray();
            Arrays.sort(chars1);
            for (int j = 0; j < chars.length; j++) {
                if (chars[j] != chars1[j]) {
                    break;
                }
                if (j == chars.length - 1) {
                    res.add(i);
                }
            }
        }
        return res;
    }
}
