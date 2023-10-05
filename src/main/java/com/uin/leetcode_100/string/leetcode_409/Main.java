package main.java.com.uin.leetcode_100.string.leetcode_409;

import java.util.HashMap;
import java.util.Map;

/**
 * 409. 最长回文串 Longest Palindrome
 * 给定一个包含大写字母和小写字母的字符串 s ，返回 通过这些字母构造成的 最长的回文串 。
 * ——————————————————————————————————————————————————————————————————————
 * 两种回文串：
 * 奇数个字符的回文串，除中间的字符以外，其他字符镜面对称（即其他字符出现的偶数次）
 * 偶数个字符的回文字符串：所有的字符全部都镜面对称（即所有字符都出现偶数次）
 * 思路分析：
 * 回文串的本质：（可能除去一个字母外）其他的字母都出现偶数次
 * 最长回文串的构成：是所有字母竟可能的出现偶数次+1（如果此时还有字母没用完）
 * ——————————————————————————————————————————————————————————————————————
 * 哈希表：也叫散列表，是一种根据关键码值（Key-Value）而直接进行访问的数据结构
 * 最终思路：以字母的ASCII码值作为KEY-VALUE存储进哈希表，然后根据哈希表中各个字母出现的次数确定最长的回文串的长度
 */
public class Main {
    public int longestPalindrome(String s) {
        //统计各字符的出现的次数
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.merge(s.charAt(i), 1, (a, b) -> a + b);
        }
        //统计回文串的最大长度
        int res = 0, odd = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            //将当前的字母出现次数向下取整
            int count = entry.getValue();
            int rem = count % 2;
            res = res + count - rem;
            //说明为奇数
            if (rem == 1) odd = 1;

        }
        return res + odd;
    }
}
