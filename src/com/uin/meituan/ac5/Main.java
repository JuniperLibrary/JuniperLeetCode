package com.uin.meituan.ac5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 题目描述：
 * 小美非常热衷于数据竞赛，数据竞赛是当下非常流行的一种比赛形式，在这种比赛中往往会给出一个训练集和一个测试集，由于测试集是没有标注的，因此大家为了线下评测模型的性能，通常会将训练集拆分成两个部分，即自建的训练集和测试集。
 * <p>
 * 现在给出某比赛的一个训练集，小美需要按照如下规则将其拆分为训练集和测试集。
 * <p>
 * 已知该训练集包含n个样本，每个样本有一个样本编号和一个类别编号。假设某一类别的样本共有m个，则将编号最小的m/2(向上取整)个样本作为训练集，将其他样本作为测试集。
 * <p>
 * 输入描述
 * 输入第一行包含两个正整数n和k，分别表示样本数量和类别数量。(1<=n<=10000,1<=k<=100)
 * <p>
 * 输入第二行包含n个正整数，第i个正整数j表示第i个样本的类别编号是j。
 * <p>
 * 输出描述
 * 输出包含两行，第一行是训练集样本编号，编号从小到大输出，中间用空格隔开。
 * 第二行是测试集的样本编号，编号从小到大输出，中间用空格隔开。
 * <p>
 * 样例输入
 * 10 3
 * 3 2 2 1 2 3 1 3 3 3
 * 样例输出
 * 1 2 3 4 6 8
 * 5 7 9 10
 *
 * @author wanglufei
 * @date 2022/8/6 10:56 AM
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //样本数量
        int n = in.nextInt();
        //类别
        int k = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = in.nextInt();
        }
    }

    /**
     * @param k
     * @param nums
     * @return 第一行是训练集样本编号，编号从小到大输出，中间用空格隔开。
     * 第二行是测试集的样本编号，编号从小到大输出，中间用空格隔开。
     */
    public static List<int[]> helper(int k, int[] nums) {
        ArrayList<int[]> res = new ArrayList<>();

        //已知该训练集包含n个样本，每个样本有一个样本编号和一个类别编号
        //某一类别的样本共有k个，则将编号最小的k/2(向上取整)个样本作为训练集，将其他样本作为测试集。
        int n = nums.length;
        //训练集
        int exec = k / 2;
        //测试集
        int test = n - exec;

        for (int i = 0; i < nums.length; i++) {
            if (i == exec) {
                int[] execId = new int[n - test];
                for (int i1 = 0; i1 < execId.length; i1++) {
                    execId[i1] = i;
                }
                res.add(execId);
            } else {
                int[] testId = new int[test];
                for (int i1 = 0; i1 < testId.length; i1++) {
                    testId[i1] = i;
                }
                res.add(testId);
            }
        }
        return res;
    }
}
