package main.java.com.uin.jd.a1;

import java.util.Scanner;

/**
 * 小红的字符串字母大写变换
 * 前k个字母大写 n-k小写
 * 输入：
 * n  k
 * 5 3
 * aBcBa
 * <p>
 * 输出：
 * ABCba
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        in.nextLine();
        String s = in.nextLine();
        System.out.println(helper(s, k));
    }

    public static String helper(String str, int k) {
        int n = str.length();
        //conner case
        if (n == 0 || str.isEmpty()) {
            return null;
        }

        char[] chars = str.toCharArray();

        for (int i = 0; i <= k; i++) {
            chars[i] = Character.toUpperCase(chars[i]);
        }

        for (int i = k; i < n; i++) {
            chars[i] = Character.toLowerCase(chars[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            sb.append(chars[i]);
        }
        return String.valueOf(sb);
    }
}
