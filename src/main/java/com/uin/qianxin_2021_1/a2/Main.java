package com.uin.qianxin_2021_1.a2;

import java.util.Scanner;

/**
 * 【2021】奇安信春招Java方向试卷1 - 黄金瞳
 * 小庄在一次机缘巧合的机会，眼睛获取了黄金瞳，黄金瞳的功能是可以看到m种物品10天以后的价格。但是这些物品属于限购物资，最多只能购买一定的数量。现在小庄有资金x可以投资这些物品，如何操作才能实现10天后资产价值最大。
 * 输入描述:
 * - 第一行 当前资金 x
 * - 第二行物品种类m
 * - 第三行每种物品限购数量，m个数字
 * - 第四行物品当前价格，m个数字
 * - 第五行物品10天后价格，m个数字
 * <p>
 * 输出描述:
 * --  10天后资产价值最大值
 * <p>
 * 输入例子1:
 * 11
 * 2
 * 6 5
 * 3 2
 * 5 3
 * <p>
 * 输出例子1:
 * - 18
 * <p>
 * 例子说明1:
 * - 第一种物品买3个，第二种物品买1个，初期资产3*3+2*1=11，10天后资产价值最大5*3+3*1=18
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();//资金

        int count = sc.nextInt();//物品种类

        int[] limits = new int[count];//每种物品限购数量
        for (int i = 0; i < count; i++) {
            limits[i] = sc.nextInt();
        }

        int[] curPrice = new int[count];//当前价格
        for (int i = 0; i < count; i++) {
            curPrice[i] = sc.nextInt();
        }

        int[] futurePrice = new int[count];//10天后价格
        for (int i = 0; i < count; i++) {
            futurePrice[i] = sc.nextInt();
        }


        int[] value = new int[count];
        for (int i = 0; i < count; i++) {
            value[i] = futurePrice[i] - curPrice[i];
        }

        int sum = 0;
        for (int data : limits) {
            sum += data;
        }

        int[] weight = new int[sum];
        int index = 0;
        for (int i = 0; i < count; i++) {
            int temp = limits[i];
            for (int j = 0; j < temp; j++) {
                weight[index++] = curPrice[i];
            }
        }
        //System.out.println(Arrays.toString(weight));
        index = 0;
        int[] values = new int[sum];
        for (int i = 0; i < count; i++) {
            int temp = limits[i];
            for (int j = 0; j < temp; j++) {
                values[index++] = value[i];
            }
        }
        //System.out.println(Arrays.toString(values));
        int[] dp = new int[x + 1];
        for (int i = 0; i < weight.length; i++) {
            for (int j = x; j >= weight[i]; j--) {
                dp[j] = Math.max(dp[j], values[i] + dp[j - weight[i]]);
            }
        }
        //System.out.println(Arrays.toString(dp));
        //System.out.println(dp[sum]);
        //System.out.println(money);
        System.out.println(dp[x] + x);

    }
}
