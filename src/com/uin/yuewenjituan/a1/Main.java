package com.uin.yuewenjituan.a1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode 56.合并区间
 * <p>
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main {
    public static void main(String[] args) {
        int[][] nums = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        // [[1,6],[8,10],[15,18]]
        System.out.println(merge(nums));
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param arr int整型二维数组
     * @return int整型二维数组
     */
    public static int[][] merge(int[][] arr) {
        // write code here
        if (arr == null || arr.length == 0) {
            return arr;
        }


        List<int[]> res = new ArrayList<>();
        Arrays.sort(arr, (a, b) -> (a[0] - b[0]));
        int[] curr = arr[0];
        for (int i = 1; i < arr.length; i++) {
            //end>start 说明不需要合并了
            if (arr[i][0] > curr[1]) {
                res.add(curr);
                // 指针向右移动
                curr = arr[i];
            } else {
                curr[1] = Math.max(curr[1], arr[i][1]);
            }
        }
        res.add(curr);

        //[[1,3],[2,6],[8,10],[15,18]]
        //[1,2,3,6]==>[1,6]
        //[[1,6],[8,10],[15,18]]
        return res.toArray(new int[res.size()][2]);
    }
}
