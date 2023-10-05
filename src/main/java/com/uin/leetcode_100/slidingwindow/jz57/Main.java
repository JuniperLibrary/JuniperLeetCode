package main.java.com.uin.leetcode_100.slidingwindow.jz57;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 57 - II. 和为s的连续正数序列
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(findContinuousSequence(9));
    }

    public static int[][] findContinuousSequence(int target) {
        List<int[]> vec = new ArrayList<>();
        int sum = 0;
        int limit = (target - 1) / 2; // (target - 1) / 2 等效于 target / 2 下取整

        for (int i = 1; i <= limit; ++i) {
            for (int j = i; ; ++j) {
                sum += j;
                if (sum > target) {
                    sum = 0;
                    break;
                } else if (sum == target) {
                    int[] res = new int[j - i + 1];
                    for (int k = i; k <= j; ++k) {
                        res[k - i] = k;
                    }
                    vec.add(res);
                    sum = 0;
                    break;
                }
            }
        }
        return vec.toArray(new int[vec.size()][]);
    }

    public static int[][] sliding(int target) {
        int i = 1;
        int j = 1;
        int sum = 0;
        List<int[]> res = new ArrayList<>();

        while (i <= target / 2) {
            if (sum < target) {
                //向右移动
                sum += j;
                j++;
            } else if (sum > target) {
                //左边界向右移动
                sum -= i;
                i++;
            } else {
                int[] arr = new int[j - i];
                for (int k = i; k < j; k++) {
                    arr[k - i] = k;
                }
                res.add(arr);
                // 左边界向右移动
                sum -= i;
                i++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
