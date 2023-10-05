package com.uin.leetcode_100.array.leetcode_1806;

/**
 * 1806. 还原排列的最少操作步数
 * 给你一个偶数 n ，已知存在一个长度为 n 的排列 perm ，其中 perm[i] == i​（下标 从 0 开始 计数）。
 *
 * 一步操作中，你将创建一个新数组 arr ，对于每个 i ：
 *
 * 如果 i % 2 == 0 ，那么 arr[i] = perm[i / 2]
 * 如果 i % 2 == 1 ，那么 arr[i] = perm[n / 2 + (i - 1) / 2]
 * 然后将 arr 赋值给 perm 。
 *
 * 要想使 perm 回到排列初始值，至少需要执行多少步操作？返回最小的 非零 操作步数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 2
 * 输出：1
 * 解释：最初，perm = [0,1]
 * 第 1步操作后，perm = [0,1]
 * 所以，仅需执行 1 步操作
 * 示例 2：
 *
 * 输入：n = 4
 * 输出：2
 * 解释：最初，perm = [0,1,2,3]
 * 第 1步操作后，perm = [0,2,1,3]
 * 第 2步操作后，perm = [0,1,2,3]
 * 所以，仅需执行 2 步操作
 * 示例 3：
 *
 * 输入：n = 6
 * 输出：4
 *
 *
 * 提示：
 *
 * 2 <= n <= 1000
 * n 是一个偶数
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/minimum-number-of-operations-to-reinitialize-a-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(reinitializePermutation(4));
    }

    public static int reinitializePermutation(int n) {
        // perm[n],perm[i]=i
        // 一步操作中，你讲创建一个新的数组arr
        // 对于每个i ：
        // - i % 2 ==0  arr[i]= perm[i/2]
        // - i % 2 ==1 arr[i]= perm[n/2+(i-1)/2]
        // 然后将arr赋值给perm
        // 要想使perm会到排列初始值，至少需要执行多少步操作
        // N =2
        // perm[i]= [0,1]
        // [0,1]
        // 返回最小非零的操作


//        新数组的偶数位数字依次是原数组的前半段数字；
//        新数组的奇数位数字依次是原数组的后半段数字。

        // 如果原数组的某个数字下标
        // n >> i = n按位右移i位 = n / (2^i)
        // 同理 n << i = n按位左移i位 = n * (2^i)

        int ans = 0;
        if (n == 2) {
            return 1;
        }
        int start = 1;  // 考虑1的下标变换
        int tar = n / 2;    // 最终的位置
        while (start != tar) {
            if (start < tar) {
                start <<= 1;
            } else {
                start -= tar;
                start = start * 2 + 1;
            }
            ans++;
        }
        return ans + 1;

        // n >> i = n 按位右移i位 = n / (2^i)
        // 同理 n << i = n 按位左移i位 = n * (2^i)

//        int ans = 0;
//        for (int i = 1; ; ) {
//            ++ans;
//            if (i < (n >> 1)) {
//                i <<= 1;
//            } else {
//                i = (i - (n - i >> 1) << 1 | 1);
//            }
//
//            if (i==1){
//                return ans;
//            }
//        }
    }
}
