package com.uin.leetcode_100.dp.leetcode_788;

/**
 * 788 旋转数字
 * 我们称一个数 X 为好数, 如果它的每位数字逐个地被旋转 180 度后，我们仍可以得到一个有效的，且和 X 不同的数。要求每位数字都要被旋转。
 * <p>
 * 如果一个数的每位数字被旋转以后仍然还是一个数字，则这个数是有效的。0, 1, 和 8 被旋转后仍然是它们自己；2 和 5 可以互相旋转成对方（在这种情况下，它们以不同的方向旋转，换句话说，2 和 5 互为镜像）；
 * 6 和 9 同理，除了这些以外其他的数字旋转以后都不再是有效的数字。
 * <p>
 * 现在我们有一个正整数N, 计算从1 到N 中有多少个数X 是好数？
 * <p>
 * 示例：
 * <p>
 * 输入: 10
 * 输出: 4
 * 解释:
 * 在[1, 10]中有四个好数： 2, 5, 6, 9。
 * 注意 1 和 10 不是好数, 因为他们在旋转之后不变
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(rotatedDigits(10));
    }

    // 0 1 8 旋转之后还是他们自己 不能称为好数
    // 2 5 互相旋转 5 2
    // 6 9 互相旋转 9 6
    public static int rotatedDigits(int n) {
        int ans = 0;
        for (int i = 2; i <= n; i++) {
            int num = i;
            int cur = 0;
            int pos = 1;
            while (num > 0) {
                int last = num % 10;
                if (last == 3 || last == 4 || last == 7) {
                    cur = i;
                    break;
                }
                if (last == 2) {
                    last = 5;
                } else if (last == 5) {
                    last = 2;
                } else if (last == 6) {
                    last = 9;
                } else if (last == 9) {
                    last = 6;
                }
                cur += last * pos;
                pos *= 10;
                num /= 10;
            }

            if (cur != i) {
                ans += 1;
            }
        }
        return ans;
    }
}
