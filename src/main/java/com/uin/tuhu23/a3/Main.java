package main.java.com.uin.tuhu23.a3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 【2023届途虎校招】Java开发工程师笔试01卷----最小不兼容性
 * 给你一个整数数组nums和一个整数k。你需要将这个数组划分到k个相同大小的子集中，使得一个子集里面没有两个相同的元素。
 * 一个自己的不兼容性 是该子集最大值和最小值的差。
 * 请你返回数据分成k个子集后，各子集 不兼容性的 和 的最小值。
 * 如果无法分成 返回-1
 */
public class Main {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * 返回将数组分成 k 个子集后，各子集 不兼容性 的 和 的 最小值 ，如果无法分成分成 k 个子集，返回 -1
     *
     * @param nums int整型一维数组
     * @param k int整型
     * @return int整型
     */

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    public int minimumIncompatibility(int[] nums, int k) {
        // write code here
        Arrays.sort(nums);
        helper(nums, 0, k);
        return res.size();
    }

    private void helper(int[] nums, int start, int k) {
        if (k == 0) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i - 1] == nums[i]) {
                break;
            }
            list.add(nums[i]);
            helper(nums, i + 1, k--);
            list.remove(list.size() - 1);
        }
    }
}
