package main.java.com.uin.leetcode_100.string.leetcode_1805;

import java.util.HashSet;
import java.util.Set;

/**
 * 1805.字符串中不同整数的数目
 * 给你一个字符串 word ，该字符串由数字和小写英文字母组成。
 * 请你用空格替换每个不是数字的字符。例如，"a123bc34d8ef34" 将会变成 " 123  34 8  34" 。注意，剩下的这些整数为（相邻彼此至少有一个空格隔开）："123"、"34"、"8" 和 "34" 。
 * 返回对 word 完成替换后形成的 不同 整数的数目。
 * 只有当两个整数的 不含前导零 的十进制表示不同， 才认为这两个整数也不同。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：word = "a123bc34d8ef34"
 * 输出：3
 * 解释：不同的整数有 "123"、"34" 和 "8" 。注意，"34" 只计数一次。
 * 示例 2：
 * <p>
 * 输入：word = "leet1234code234"
 * 输出：2
 * 示例 3：
 * <p>
 * 输入：word = "a1b01c001"
 * 输出：1
 * 解释："1"、"01" 和 "001" 视为同一个整数的十进制表示，因为在比较十进制值时会忽略前导零的存在。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= word.length <= 1000
 * word 由数字和小写英文字母组成
 */
public class Main {
    public static void main(String[] args) {
        String word = "a123bc34d8ef34";
        //System.out.println(numDifferentIntegers(word));
        System.out.println(helper(word));
    }

    /**
     * 使用Set进行种类的去重，若当前字符为数字，那么找到其终止位置后，去除前导0保存在Set中即可。
     * 对于数字0，可以转化为保存空字符串。
     *
     * @param word
     * @return
     */
    public static int numDifferentIntegers(String word) {
        Set<String> set = new HashSet<>();
        int n = word.length();
        for (int i = 0; i < n; i++) {
            // <= '9' 说明是数字
            if (word.charAt(i) <= '9') {
                int j = i;
                while (j < word.length() && word.charAt(j) <= '9') {
                    j++;
                }
                while (i < j && word.charAt(i) == '0') {
                    i++;
                }
                set.add(word.substring(i, j));
            }
        }
        return set.size();
    }


    public static int helper(String word) {
        Set<String> set = new HashSet<>();
        for (String str : word.split("[a-z]+")) {
            if (str.length() > 0) {
                set.add(str.replaceAll("^0+", ""));
            }
        }
        return set.size();
    }


}
