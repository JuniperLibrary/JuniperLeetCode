package main.java.com.uin.leetcode_100.string.leetcode_7;

/**
 * 7.整数反转
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * 如果反转后整数超过 32 位的有符号整数的范围[−231, 231− 1] ，就返回 0。
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 */
public class Main {
    public static void main(String[] args) {
        int x = 123;
        System.out.println(helper(x));
    }

    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            //每次取末尾数字
            int tmp = x % 10;
            //判断是否 大于 最大32位整数
            if (res > 214748364 || (res == 214748364 && tmp > 7)) {
                return 0;
            }
            //判断是否 小于 最小32位整数
            if (res < -214748364 || (res == -214748364 && tmp < -8)) {
                return 0;
            }
            res = res * 10 + tmp;
            x /= 10;
        }
        return res;
    }
    /**
     *
     * @author wanglufei
     * @date 2022/9/12 2:28 PM
 * @param x
 * @return int
     */
    public static int helper(int x) {
        int res = 0;
        int last = 0;
        while (x != 0) {
            //每次取末尾数字
            int tmp = x % 10;
            last = res;
            res = res * 10 + tmp;
            //判断整数溢出
            if (last != res / 10) {
                return 0;
            }
            x /= 10;
        }
        return res;
    }
}
