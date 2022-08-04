package com.uin.leetcode_100.array.Double_index.LeetCode_11;

/**
 * LeetCode 11 盛最大水的问题
 *
 * @author wanglufei
 * @date 2022/7/10 7:18 PM
 */
public class Main {

    public static void main(String[] args) {
        int[] a = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(solution2(a));
    }

    //暴力解法
    public static int solution1(int[] a) {
        int result = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                result = Math.max(result, Math.min(a[i], a[j]) * (j - i));
            }
        }
        return result;
    }

    //双指针
    public static int solution2(int[] a) {
        int left = 0;
        int right = a.length - 1;
        int result = 0;
        //左右指针 谁小移动谁
        while (left < right) {
            int area = Math.min(a[left], a[right]) *(right-left);
            result=Math.max(result,area);
            if (a[left]<=a[right]){
                left++;
            }else {
                right--;
            }
        }
        return result;
    }
}
