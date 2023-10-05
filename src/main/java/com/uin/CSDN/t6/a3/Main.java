package com.uin.CSDN.t6.a3;


import java.util.HashMap;

/**
 * 收件邮箱
 * 已知字符串str，str表示邮箱的不标准格式。 其中”.”会被记录成”dot”，”@”记录成”at”。 写一个程序将str转化成可用 的邮箱格式。
 * (可用格式中字符串中除了开头结尾所有”dot”,都会被转换,”at”只会被转化一次，开头结尾的不转化)v
 */
public class Main {
    public static void main(String[] args) {
        String s = "mxyatoxcoderdotcom";
        System.out.println(helper(s));
    }

    public static String helper(String s) {
        char[] chars = s.toCharArray();
        int pos = 0;

        for (int i = 0; i < chars.length; i++) {
            int type = transfer(chars, i);

            if (type == 1) {
                chars[pos++] = '@';
                i++;
            } else if (type == 2) {
                chars[pos++] = '.';
                i += 2;
            } else {
                chars[pos++] = chars[i];
            }
        }
        return new String(chars, 0, pos);
    }

    private static boolean atCount = true;

    //'at' replace '@'
    //'dot' replace '.'
    private static int transfer(char[] chars, int begin) {
        int n = chars.length;
        if (atCount && (begin + 1) < n && chars[begin] == 'a' && chars[begin + 1] == 't') {
            //开头和结尾不换
            if (begin != 0 && begin != (n - 2)) {
                atCount = false;
                return 1;
            }
        }

        if ((begin + 2) < n && chars[begin] == 'd' && chars[begin + 1] == 'o' && chars[begin + 2] == 't') {
            //开头和结尾不转换
            if (begin != 0 && begin != (n - 3)) {
                return 2;
            }
        }
        return 0;
    }


    public static String slidingWindow(String s) {
        HashMap<Character, Integer> window = new HashMap<>();
        int n = s.length();
        int left = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (window.containsKey(c)) {
                //left=
            }
        }
        return "";
    }
}
