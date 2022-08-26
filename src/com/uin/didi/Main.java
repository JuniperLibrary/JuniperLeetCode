package com.uin.didi;

/**
 * 序列拆分：
 * 给出一个由正整数组成的序列。
 * 请判断能否将其中的每个数染成红色或蓝色，使得染成红色的数按顺序构成一个单调递增的序列，
 * 且染成蓝色的数按顺序构成一个单调递减的序列。
 */

import com.sun.org.apache.xpath.internal.operations.String;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 第一行有一个正整数T(1<=T<=10)，代表测试数据的组数。
 * <p>
 * 每组测试数据的第一行有一个正整数n(1<=n<=500)，代表序列的长度。
 * <p>
 * 第二行有n个互不相同的范围在1到n之间的正整数，代表该序列。
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = 0;
        int n = 0;
        int[] nums = new int[n];

        T = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < T; i++) {
            nums[i] = scanner.nextInt();
        }
        solution(nums, T);

    }

    public static ArrayList<String> solution(int[] nums, int T) {
        ArrayList<String> result = new ArrayList<>();


        int left = 0;
        int length = nums.length;
        int middle = (left + length) / 2;


        for (int i = 0; i < middle; i++) {
            if (nums[i] > nums[i++]) {
            }
        }
        return null;
    }
}
