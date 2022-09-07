package com.uin.didi.didi17.a2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 滴滴出行2017秋招笔试真题-编程题汇总--餐馆
 * 某餐馆有n张桌子，每张桌子有一个参数：a 可容纳的最大人数；
 * 有m批客人，每批客人有两个参数:
 * -- b人数，c预计消费金额。
 * 在不允许拼桌的情况下，请实现一个算法选择其中一部分客人，使得总预计消费金额最大
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int m = in.nextInt();

            int[] table = new int[n];
            for (int i = 0; i < n; i++) {
                table[i] = in.nextInt();
            }

            int[][] cus = new int[m][2];
            for (int i = 0; i < m; i++) {
                cus[i][0] = in.nextInt();//人数
                cus[i][1] = in.nextInt();//金额
            }

            //整体思路就是cus金额大的先安排,table桌子升序排列
            Arrays.sort(table);
            Arrays.sort(cus, (a, b) -> b[1] - a[1]);

            long res = 0;
            int index = 0;

            boolean[] b = new boolean[n];
            for (int i = 0; i < m; i++) {
                if (cus[i][0] > table[n - 1]) {
                    continue;
                }
                index = bs(table, cus[i][0]);

                while (index < n && b[index] == true) {
                    index++;
                }
                if (index < n) {
                    res += cus[i][1];
                    b[index] = true;
                }
            }

            System.out.println(res);
        }
        in.close();
    }

    private static int bs(int[] table, int cus) {
        int l = 0, h = table.length - 1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (table[mid] >= cus) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
