package com.uin.level2.leetcode_43;

/**
 * 43. 字符串相乘
 * 给定两个以字符串形式表示的非负整数num1和num2，返回num1和num2的乘积，它们的乘积也表示为字符串形式。
 * <p>
 * 注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 */
public class Main {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int len1 = num1.length();
        int len2 = num2.length();

        int[] ans = new int[len1 + len2];
        for (int i = len1 - 1; i >= 0; i--) {
            int x = num1.charAt(i) - '0';
            for (int j = len2 - 1; j >= 0; j--) {
                int y = num2.charAt(j) - '0';
                ans[i + j + 1] += x * y;
            }
        }

        for (int i = len1 + len2 - 1; i > 0; i--) {
            ans[i - 1] += ans[i] / 10;
            ans[i] %= 10;
        }
        StringBuilder builder = new StringBuilder();
        int index = ans[0] == 0 ? 1 : 0;
        while (index < len1 + len2) {
            builder.append(ans[index]);
            index++;
        }
        return builder.toString();
    }
}
