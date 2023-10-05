package main.java.com.uin.leetcode_100.string.leetcode_541;

/**
 * 541. 反转字符串 II
 * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
 * <p>
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 * <p>
 * 输入：s = "abcdefg", k = 2
 * 输出："bacdfeg"
 */
public class Main {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int n = chars.length;

        for (int i = 0; i < n; i += 2 * k) {
            int end = i + k - 1;

            if (end <= n - 1) {
                reverse(chars, i, i + k - 1);
            } else {
                reverse(chars, i, n - 1);
            }
        }
        //return chars.toString(); 长记性！！！！！！
        return new String(chars);
    }

    /**
     * 反转
     *
     * @param chars
     * @param start
     * @param end
     * @author wanglufei
     * @date 2022/8/28 7:29 PM
     */
    private void reverse(char[] chars, int start, int end) {
        while (start<end){
            char temp = chars[start];
            chars[start]=chars[end];
            chars[end]=temp;
            start++;
            end--;
        }
    }
}
