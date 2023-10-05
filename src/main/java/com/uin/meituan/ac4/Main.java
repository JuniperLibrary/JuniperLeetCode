package main.java.com.uin.meituan.ac4;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 题目描述：
 * 小美有n块魔法石，每块魔法石都有正反两面，每一面上都刻有一个魔法阵，初始状态下，n块魔法石都是正面向上。这n块魔法石的能量刚好可以构建一个大型魔法阵，
 * 但是需要至少一半的魔法石向上的一面铭刻的阵法相同才能触发大型魔法阵的效果。
 * <p>
 * 小美希望翻转最少数量的魔法石，使得这个大型魔法阵被触发，请问她最少需要翻转多少块魔法石。
 * <p>
 * <p>
 * <p>
 * 输入描述
 * 输入第一行包含一个正整数n，表示魔法石的数量。(1<=n<=100000)
 * <p>
 * 输入第二行包含n个正整数，表示n块魔法石正面铭刻的魔法阵种类，由于魔法书上记载的魔法阵数量太多，所以魔法阵编号可能是从1到10^9中的任何一个正整数。
 * <p>
 * 输入第三行包含n个正整数，表示n块魔法石反面铭刻的魔法阵种类，魔法阵编号同样在1到10^9之间。
 * <p>
 * 数字间两两有空格隔开
 * <p>
 * 输出描述
 * 输出仅包含一个整数，如果有解则输出最少翻转的魔法石数量，如果无解则输出-1。
 * <p>
 * 样例输入
 * 5
 * 1 5 7 5 5
 * 10 5 5 9 10
 * 样例输出
 * 0
 *
 * @author wanglufei
 * @date 2022/8/6 10:50 AM
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        String[] s1 = in.nextLine().split(" ");
        int[] nums1 = Arrays.stream(s1).mapToInt(Integer::parseInt).toArray();
        String[] s2 = in.nextLine().split(" ");
        int[] nums2 = Arrays.stream(s2).mapToInt(Integer::parseInt).toArray();
        int helper = helper(n, nums1, nums2);
        System.out.println(helper);
    }

    public static int helper(int n, int[] up, int[] down) {
        int res = 0;
        for (int i = 0; i < up.length; i++) {
            for (int j = 0; j < down.length; j++) {
                if (up[i] == down[j] && up[i] == n && down[j] == n) {
                    return res;
                }
                //初始状态都是向上
                if (down[j] <= n && down[i]<=n) {
                    res=res+(n-down[j]);
                }
            }
        }
        return res;
    }
}
