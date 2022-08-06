package com.uin.meituan.ac6;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 字符串第k位
 * 小美和小团拥有一个字符串生成机器，每次将字符串s丢入这个机器中，这个机器将会弹出s+r(s)+”wow”，其中，加号表示字符串的拼接，r(s)表示将字符串s逆序。
 * <p>
 * 例如当s=”abc”时，得到的字符串为s+r(s)+”wow”=”abccbawow”。
 * <p>
 * 当s=”MeiTuan”时，得到的字符串为”MeiTuannauTieMwow”。
 * <p>
 * 小美和小团想知道，如果有一个初始字符串”MeiTuan”，然后将这个字符串丢入机器得到一个新串，然后不断地将新串再次丢入机器中，循环往复得到的无限长的字符串的第k位字符（k从1开始）是什么？
 * （根据生成规则可知，每次丢入机器的串都会是生成的结果串的一个前缀）
 * <p>
 * <p>
 * <p>
 * 输入描述
 * 第一行是一个整数T，表示有T个询问。
 * <p>
 * 接下来T行每行一个整数k，表示询问无限长字符串中第k个字符是多少。
 * <p>
 * 1<=T<=10,   1<=k<=10^18
 * <p>
 * 输出描述
 * T行，第 i 行包含一个字符，表示第i个询问的答案。
 *
 * @author wanglufei
 * @date 2022/8/6 11:22 AM
 */
public class Main {
    private static String S = "MeiTuan";
    private static String STR = "WoW";

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int k = 0;
        for (int i = 0; i < t; i++) {
            k = in.nextInt();
            String c = solutions(S, k);
            System.out.println(c);
        }
    }

    public static String solutions(String s, int k) {
        String newStr = s + helper(s) + STR;
        String[] strs = newStr.split("\n");
        String str = strs[k];
        return str;
    }

    /**
     * 字符串逆序
     *
     * @param str
     * @author wanglufei
     * @date 2022/8/6 11:30 AM
     */
    public static String helper(String str) {
        String[] s = str.split("\n");
        int[] array = Arrays.stream(s).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < array.length; i++) {
            for (int j = array.length - 1; j > 0; j--) {
                swap(array, i, j);
            }
        }
        return s.toString();
    }

    /**
     * 交换
     *
     * @param nums
     * @param a
     * @param b
     * @author wanglufei
     * @date 2022/8/6 11:35 AM
     */
    public static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
