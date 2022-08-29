package com.uin.litteredbook.a4;

/**
 * 击败魔物
 * 薯队长来到了迷宫的尽头，面前出现了N只魔物，Hi表示第i只魔物的血量，薯队长需要在T个回合内击败所有魔物才能获胜。
 * 每个回合薯队长可 以选择物理攻击一只魔物，对其造成1点伤害（物理攻击次数无上限）;
 * 或者消耗1点法力释放必杀技对其造成固定X点伤害（薯队长开始拥有M 点法力）。
 * 问X至少多大，薯队长才有机会获胜；如果无论如何都无法在T回合内获胜，则输出-1
 * <p>
 * 第一行三个整数分别表示：N，T，M 第二行有N个整数：H1，H2，H3...HN
 * <p>
 * 输出一个整数，表示必杀技一次最少造成多少固定伤害
 * <p>
 * 3 4 3
 * 5 2 1
 * <p>
 * 3
 */
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int t = in.nextInt();
        int m = in.nextInt();
        Integer[] h = new Integer[n];
        int maxH = 0, totalH = 0;
        //获取怪物血量输入，顺便找出最大怪物血量，顺便计算怪物总血量。
        for (int i = 0; i < h.length; i++) {
            int s = in.nextInt();
            h[i] = s;
            maxH = Math.max(maxH, s);
            totalH += s;
        }
        //如果怪物总血量小于回合数，说明平A就能解决所有怪物，所以必杀技伤害为最低0
        if (totalH <= t) {
            System.out.println(0);
            return;
        }
        //把怪物的血量从大到小排序
        Arrays.sort(h, Collections.reverseOrder());
        /*从2到最大怪兽血量maxH，进行升序循环判断，找到第一个伤害就是，最低必杀技伤害
        Q:为什么从2开始？A:因为普工伤害为1，必杀技小于等于普工伤害时，都使用普工解决就可以
        */
        for (int i = 2; i <= maxH; i++) {
            //判断该必杀技伤害是否能够通关
            if (dfs(h, t, m, i, totalH)) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(-1);
    }

    public static boolean dfs(Integer[] h, int t, int m, int x, int totalH) {
        //判断回合数是否大于蓝量
        if (t > m) {
            //看所有蓝量用完后再在回合内使用普工时，所能造成的总血量是否大于怪物总血量，如果不行，则无法通关
            if (t - m + m * x >= totalH) {
                /**
                 怪物血量大于必杀技伤害的，每一个都使用必杀技，确保必杀技伤害不溢出。
                 **/
                Integer[] ht = Arrays.copyOf(h, h.length);
                int j = 0;
                for (int i = 0; i < h.length && m > 0 && h[i] >= x; i++) {
                    int st = h[i] / x;
                    int sx = h[i] % x;
                    if (st <= m) {
                        ht[i] = sx;
                        totalH -= st * x;
                        m -= st;
                        t -= st;
                    } else {
                        ht[i] -= m * x;
                        totalH -= m * x;
                        m = 0;
                        t -= m;
                    }
                }
                //如果必杀技使用完毕，则只能进行平砍，判断怪物总剩余血量是否小于等于剩余回合数就行
                if (m == 0) {
                    return totalH <= t - m;
                } else {
                    //如果必杀技未使用完毕，则直接对剩余血量最多的怪再次使用必杀技，确保必杀技利益最大化。
                    //怪物剩余血量再排序
                    Arrays.sort(ht, Collections.reverseOrder());
                    //由于java最后10%的案例超时，所以判断了一下剩余蓝量是否大于怪物数量的一半
                    if (m > ht.length / 2) {
                        //如果超过一半，则只需计算另外一半未死的怪物血量就是剩余怪物总血量
                        totalH = 0;
                        for (int i = m; i < ht.length; i++) {
                            totalH += ht[i];
                        }
                    } else {
                        //如果没有超过一半，则每一只怪死掉后，总血量减去该怪物的剩余血量就行
                        for (int i = 0; i < m; i++) {
                            totalH -= ht[i];
                        }
                    }
                    //通过以上步骤算出怪物剩余总血量，如果小于使用全部技能后的回合数，就能平A通关了，如果不行则不能进行通关操作
                    return totalH <= t - m;
                }
            } else {
                return false;
            }
        } else {
            //如果回合数小于等于蓝量，则全程使用必杀技，看是否通关。
            //直接回合数*必杀技看是否大于怪物总血量
            return t * x >= totalH;
        }
    }
}

