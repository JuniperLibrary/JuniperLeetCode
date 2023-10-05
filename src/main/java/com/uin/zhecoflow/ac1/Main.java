package com.uin.zhecoflow.ac1;
//hanamaru和zura。

import java.util.Arrays;
import java.util.Scanner;

/**
 * hanamaru有zura的口癖，他习惯给每一句话加一个"zura"语气词
 * 现在给定一个hanamaru说过的话。请判断他说了多少句话。
 * <p>
 * 输入仅一行，为一个小写字母、空格和特殊的字符号组成，代表他说的话，保证这个一"zura"结尾。
 * <p>
 * 输出他说了几句话。
 * <p>
 * miraizura~watashi minnagadaisukizura
 * 2
 * <p>
 * 解释：{miraizura}和{~watashi minnagadaisukizura}
 */

public class Main {
    /**
     * 语气词
     */
    private static String YEEP = "zura";

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        findSays(s);
    }

    public static int findSays(String str) {
        int res = 0;
        int m = str.length();
        int n = YEEP.length();

        if (m < n) return 0;

        //小写字母、空格和特殊字符
        int[] arr1 = new int[28];
        int[] arr2 = new int[28];

        for (int i = 0; i < n; i++) {
            arr1[str.charAt(i) - 'a']++;
            arr2[str.charAt(i) - 'a']++;
        }

        if (Arrays.equals(arr1, arr2)) res += res;

        for (int i = 1; n + i - 1 < m; i++) {
            arr1[str.charAt(i - 1) - 'a'] -= 1;
            arr1[str.charAt(n + i - 1) - 'a'] += 1;
            if (Arrays.equals(arr1, arr2)) {
                res += res;
            }
        }
        return res;
    }
}
