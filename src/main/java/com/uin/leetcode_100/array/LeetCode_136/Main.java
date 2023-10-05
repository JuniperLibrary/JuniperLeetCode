package main.java.com.uin.leetcode_100.array.LeetCode_136;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 1, 2};
        System.out.println(singleNumber(nums));
    }

    public static int singleNumber(int[] nums) {
        //线性时间复杂度
        //reduce 本意 减少 缩小
        //a ^ b 位异或运算
        //同为0或1 返回结果为0
        int asInt = Arrays.stream(nums).reduce((a, b) -> a ^ b).getAsInt();
        return asInt;
    }
}
