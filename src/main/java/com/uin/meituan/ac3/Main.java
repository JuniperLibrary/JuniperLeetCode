package main.java.com.uin.meituan.ac3;

import java.util.Scanner;

/**
 * 小美在做一个实验，这个实验会在纸带上打印出若干个数字，已知该实验所呈现出的正确结果应该是存在某一个分割处k，
 * 在k之前打印出的数字都是小于0的，而在k之后的数字应该都是大于0的，那么在k之前如果某一个数据大于等于0，
 * 那么我们认为这个数据是异常的，同理，在k之后如果某一个数据小于等于0，那么我们也认为这个数据是异常的。
 * <p>
 * 现在给出小美打印的纸带，且k是未知的，那么请问在最乐观的情况下至少有多少个实验数据是异常的。
 * (显然如果出现0，无论k为哪个时刻，这个0数据都是异常的)
 * <p>
 * 输入描述
 * 输入第一行包含一个正整数n，表示小美在纸带上打印的数字数量。(1<=n<=100000)
 * <p>
 * 输入第二行包含n个整数 ，即小美在纸带上打印的数字，中间用空格隔开。数字仅会为 -1，0，1中的一个。
 * <p>
 * 输出描述
 * 输出仅包含一个整数，表示至少有多少个实验数据是异常的。
 *
 *
 * @author wanglufei
 * @date 2022/8/6 10:22 AM
 */

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        int helper = helper(nums);
        System.out.println(helper);
    }

    public static int helper(int[] nums) {
        if (nums == null || nums.length == 0) return nums.length;

        int left = 0;
        int right = nums.length - 1;

        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[left] >= 0) {
                res++;
                left++;
            }
            if (nums[right] <= 0) {
                res++;
                right--;
            }
        }
        return res;
    }
}
