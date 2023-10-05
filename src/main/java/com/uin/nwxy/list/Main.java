package com.uin.nwxy.list;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 统计每个数组中所有元素出现的次数
 *
 * @author wanglufei
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 2, 3, 2, 4, 5};
        HashMap<Integer, Integer> map = solution2(nums);
        System.out.println(map);
    }

    public static HashMap<Integer, Integer> solution2(int[] nums) {
        HashMap<Integer, Integer> res = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            int count = 0;
            boolean add = set.add(num);
            if (add == false) {
                Integer integer = res.get(num);
                integer++;
                res.put(num, integer);
            } else {
                count = 1;
                res.put(num, count);
            }
        }
        return res;
    }
}
