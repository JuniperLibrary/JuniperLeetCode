package main.java.com.uin.leetcode_100.string.leetcode_459;


/**
 * 459. 重复的子字符串
 * 给定一个非空的字符串 s ，检查是否可以通过由它的一个子串重复多次构成。
 */
public class Solution {
    public static void main(String[] args) {
        String s = "abcabcabcabc";
        System.out.println(helper(s));
    }

    /**
     * n 一定是n· 的倍数
     * s· 一定是 s 的前缀
     * 对于任意的 i
     */
    private static boolean helper(String s) {
        int n = s.length();
        for (int i = 1; i * 2 <= n; i++) {
            if (n % i == 0) {
                boolean match = true;
                for (int j = i; j < n; j++) {
                    if (s.charAt(j) != s.charAt(j - i)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    return true;
                }
            }
        }
        return false;
    }
}
