package com.uin.leetcode_100.greedy.pdd3;

import java.util.Arrays;
import java.util.Scanner;

/**
 * PDD3 六一儿童节
 * 六一儿童节，老师带了很多好吃的巧克力到幼儿园。每块巧克力j的重量为w[j]，对于每个小朋友i，当他分到的巧克力大小达到h[i] (即w[j]>=h[i])，他才会上去表演节目。
 * 老师的目标是将巧克力分发给孩子们，使得最多的小孩上台表演。可以 保证每个w[i]> 0 且 不能将多块巧克力分给一个孩子 或 将一块分给多个孩子。
 * <p>
 * 第一行：n，表示h数组元素个数
 * 第二行：n个h数组元素
 * 第三行：m，表示w数组元素个数
 * 第四行：m个w数组元素
 * <p>
 * 3
 * 2 2 3
 * 2
 * 3 1
 * <p>
 * 1
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] h = new int[n];
        for (int i = 0; i < n; i++) {
            h[i] = in.nextInt();
        }

        int m = in.nextInt();
        int[] w = new int[m];
        for (int j = 0; j < m; j++) {
            w[j] = in.nextInt();
        }
        System.out.println(helper(h, w));
    }

    public static int helper(int[] h, int[] w) {
        int ans = 0;
        Arrays.sort(h);
        Arrays.sort(w);
        int idw = 0;
        for (int i = 0; i < h.length; i++) {
            while (idw < w.length) {
                if (w[idw] >= h[i]) {
                    ans++;
                    idw++;
                    break;
                } else {
                    idw++;
                }
            }
        }
        return ans;
    }
}
