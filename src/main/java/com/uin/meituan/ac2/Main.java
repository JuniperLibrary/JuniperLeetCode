package com.uin.meituan.ac2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 小美开的西点屋举办一周年活动，她准备制作一批礼盒作为对消费者的回馈，每个礼盒中都有三枚西点屋的招牌点心。西点屋共有A和B两种招牌点心，
 * 为了让消费者都能品尝到两种点心，因此每个礼盒中都要包含至少一枚A点心和一枚B点心。现在小美的西点屋内共有x枚A点心和y枚B点心，请问小美最多可以制作多少个礼盒。
 * <p>
 * <p>
 * 输入第一行包含一个正整数T，表示数据组数。(1<=T<=10000)
 * <p>
 * 然后有T行，每行包含两个整数x和y，空格隔开，表示有x枚A点心和y枚B点心。(1<=x,y<=10^9)
 * <p>
 * 输出包含T行，每行一个整数，表示最多可以制作的礼盒数量。
 *
 * @author wanglufei
 * @date 2022/8/6 10:01 AM
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
        System.out.println(helper(nums1));
        System.out.println(helper(nums2));
    }

    public static int helper(int[] nums) {
        //A
        int x = nums[0];
        //B
        int y = nums[1];

        if (y >= x) {
            if (x % y >= 0) {
                return x - (x % y);
            }
        }
        return x;
    }
}
