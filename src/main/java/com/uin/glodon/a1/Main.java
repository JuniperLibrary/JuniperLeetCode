package main.java.com.uin.glodon.a1;

import java.util.Scanner;

/**
 * 粒子实验  18%
 * 一些科学家在研究X粒子的特性，通常情况下，X粒子在经过加速装置后拥有的速度均为V，
 * 但是加热后，某些粒子的特性发生了变化，在相同情况下经过加速装置后拥有的速度变得大于V了（变化后的速度不一定相同），于是科学家们决定研究这些特别的粒子。
 * <p>
 * 科学家们对n个粒子做了特殊处理，为其从1到n分别编号，为了找出是哪些粒子的特性发生了变化（导致速度变化），他们准备让这些粒子依次通过一段相同长度的距离，速度越高的粒子通过这段距离所需的时间越短，
 * 由于技术问题，只能检测到粒子发射顺序和到达终点的顺序（没有两个粒子同时被发射或同时到达），请你通过这些数据计算出至少有多少个粒子特性发生了变化（即速度大于通常情况）。
 * <p>
 * 输入描述
 * 第一行一个正整数n，表示粒子数量。
 * 接下来一行包含n个正整数s1, s2,...... sn(1≤si≤n)，为按发射顺序给出的粒子编号，s1-sn为1-n的一个排列。
 * 接下来一行包含n个正整数p1,P2 ,...... pn(1≤pi≤n)，为按到达终点顺序给出的粒子编号，p1-pn为1-n的一个排列。
 * 输出描述
 * 输出至少有多少个粒子特性发生了变化（即速度大于通常情况）
 * <p>
 * 样例输入
 * 5
 * 5 4 3 2 1
 * 1 5 3 4 2
 * 样例输出
 * 2
 * <p>
 * 数据范围和说明：对于100%的数据，1 ≤ n ≤ 50000
 * <p>
 * 样例说明：编号为1的粒子最晚发射却最早到达，速度肯定大于通常情况，编号为3的粒子比编号为4的粒子更晚发射却比其更早到达，速度肯定大于通常情况，其余粒子均有可能速度未发生变化，因此至少有2个粒子速度大于通常情况。
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int[] start = new int[n];
        for (int i = 0; i < start.length; i++) {
            start[i] = in.nextInt();
        }

        int[] end = new int[n];
        for (int i = 0; i < end.length; i++) {
            end[i] = in.nextInt();
        }

        System.out.println(helper(start, end));
    }

    public static int helper(int[] start, int[] end) {
        int ans = 0;

        for (int i = start.length - 1; i >= 0; i--) {
            for (int j = 0; j < end.length; j++) {
                if (start[i] == end[j]) {
                    ans++;
                    i--;
                    break;
                }

                if (start[i] == end[j] && start[i - 1] == end[j + 1]) {
                    ans++;
                }

            }
        }
        return ans;
    }
}
