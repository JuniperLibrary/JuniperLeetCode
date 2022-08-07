package com.uin.leetcode_100.dp.leetcode_647;

public class Main {
    int res;
    char[] letters;

    public int countSubstrings(String s) {
        this.letters = s.toCharArray();
        for (int i = 0; i < letters.length; i++) {
            countPalind(i);
        }
        return res;
    }

    private void countPalind(int index) {
        int start = index, end = index;//奇数
        while (start >= 0 && end < letters.length && letters[start] == letters[end]) {
            res++;
            start--;
            end++;
        }

        start = index;
        end = index + 1; //偶数
        while (start >= 0 && end < letters.length && letters[start] == letters[end]) {
            res++;
            start--;
            end++;
        }
    }

}
