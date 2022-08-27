package com.uin.bs_360.a1;

import java.util.Scanner;

/**
 * DNA匹配
 * 时间限制： 3000MS
 * 内存限制： 589824KB
 * 题目描述：
 * 有一种特殊的DNA，仅仅由核酸A和T组成，长度为n，顺次连接
 * <p>
 * 科学家有一种新的手段，可以改变这种DNA。每一次，科学家可以交换该DNA上两个核酸的位置，也可以将某个特定位置的核酸修改为另一种核酸。
 * <p>
 * 现在有一个DNA，科学家希望将其改造成另一种DNA，希望你计算最少的操作次数。
 * <p>
 * 输入描述
 * 输入包含两行，第一行为初始的DNA，第二行为目标DNA，保证长度相同。
 * <p>
 * 输出描述
 * 输出最少的操作次数
 * <p>
 * 样例输入
 * ATTTAA
 * TTAATT
 * 样例输出
 * 3
 * <p>
 * 对于100%的数据，DNA长度小于等于100000
 * 样例解释：
 * 1.首先修改第一个位置的核酸（从A修改为T）T T T T A A
 * 2.交换3和5位置的核酸
 * 3.交换4和6位置的核酸
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String init = in.nextLine();
        String target = in.nextLine();
    }

    public static int helper(String init, String target) {
        if (init == null || init.length() == 0 || init.length() != target.length()) return 0;

        char[] initC = init.toCharArray();
        char[] targetC = target.toCharArray();


        int m = initC.length;
        int n = targetC.length;

//        int init_count_T=0;
//        int init_count_A=0;
//        for (int i = 0; i < m; i++) {
//            if (initC[i]=='A'){
//                init_count_A++;
//            }
//            if (initC[i]=='T'){
//                init_count_T++;
//            }
//        }
//
//        int target_count_T=0;
//        int target_count_A =0;
//        for (int i = 0; i < m; i++) {
//            if (initC[i]=='A'){
//                target_count_A++;
//            }
//            if (initC[i]=='T'){
//                target_count_T++;
//            }
//        }

        //替换
        int replace = 0;
        //交换
        int swap = 0;
        int ans = 0;


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (initC[i] == targetC[j]) {
                    break;
                } else {

                }
            }
        }
        return ans;
    }
}
