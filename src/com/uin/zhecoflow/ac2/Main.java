package com.uin.zhecoflow.ac2;
/**
 * 重排字符串
 * 只有小写字母组成的字符串，只改变顺序，不改变数量，重排后小红想让新字符串不包含任意两个相同的相邻字母
 * <p>
 * 输入
 * 第一行正整数n，代表字符串的长度
 * 第二行长度为n的字符串
 * 输出
 * 可以重排 第一行输出yes，第二行输出重排之后的字符串。不能重排，输出no
 * ——————————————————————————————————————————
 * 5
 * aaaaa
 * ——————————————————————————————————————
 * no
 * ————————————————————————————————————————————
 * 7
 * aabbccc
 * ————————————————————————————————————————
 * yes
 * cabcabc
 * ——————————————————————————————————————————
 */

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static String str_true = "yes";
    private static String str_false = "no";

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.nextLine().split("").toString();
        System.out.println(helper(s));
    }

    public static String helper(String s) {
        if (s.length() == 0 || s == null) return str_false;


        //  如何判断字符串的每个字符相等
        char[] chars = s.toCharArray();
        if (Arrays.equals(chars, s.toCharArray())) {
            return str_false;
        }

        Arrays.sort(chars);
        return str_true;
    }
}
