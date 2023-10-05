package com.uin.didi.didi23.a1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 桃子装箱
 * <p>
 * 小昱家的桃园丰收了！小昱采摘下来n个桃子，并对这些桃子称重，其中第i个桃子的重量为ai。
 * 小昱想选择一些桃子装成一箱后送给朋友，但是小昱不希望一箱桃子中有一些太大的桃子而影响整体美观。
 * 于是他给装箱工人提出了一个要求：一箱桃子中最重的桃子重量不能超过平均重量的k倍。装箱工人想知道在满足小昱要求的情况下，一箱最多能装多少个桃子。
 * <p>
 * 第一行输入两个正整数 n, k，表示桃子个数、倍数系数。
 * 接下来一行输入n个正整数a1, a2,...... an，其中ai表示第 i 个桃子的重量。
 * 1 ≤ n, k ≤ 100000, 1≤ ai ≤ 109
 * <p>
 * 输出一个整数，表示一箱最多能装桃子数量。
 * <p>
 * 5 2
 * 3 10 5 4 2
 * <p>
 * 4
 * <p>
 * 可以将第1、3、4、5个桃子装成一箱，桃子平均重量为(3 + 5 + 4 + 2) / 4 = 3.5，最重的桃子重量为5，不超过平均重量的两倍，是一种可行方案。
 * 如果将所有桃子装成一箱，桃子平均重量为(3 + 10 + 5 + 4 + 2) / 5 = 4.8，最重桃子的重量为10，超过平均重量的两倍了，故一箱不能装5个桃子。
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();//桃子个数
        int k = in.nextInt();//倍数
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            weights[i] = in.nextInt();
        }
        System.out.println(helper(weights, k));
    }

    public static int helper(int[] weights, int k) {
        int n = weights.length;
        Arrays.sort(weights);
        int maxWeight = weights[n - 1];
        int sum = 0;
        for (int weight : weights) {
            sum += weight;
        }
        //3.5

        int avgWeight = sum / n;
        int ans = 0;
        for (int weight : weights) {
            maxWeight -= weight;
            if (maxWeight <= k * avgWeight && maxWeight >= 0) {
                ans++;
            } else {
                break;
            }
        }
        return ans;
    }
}
