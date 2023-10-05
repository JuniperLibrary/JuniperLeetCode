package com.uin.tuhu21.a2;

/**
 * 途虎养车2021秋招Java笔试试卷A-合并两个有序数组
 * 现给出两个有序整型数组，其中array1按升序（从小到大）排序，
 * array2按降序排序，请你将 array1和array2 合并到一个新的数组中，并保持新中的元素按升序排序。
 * <p>
 * 给出 array1 和 array2 及其元素数量n 和 m ，返回合并后的新数组。
 * <p>
 * 输入：
 * [1, 2, 4, 5],4,[6],1
 * 输出：
 * [1,2,4,5,6]
 */
public class Main {
    public int[] arrayMerge(int[] array1, int n, int[] array2, int m) {
        // write code here
        int[] sort = new int[m + n];
        int i = 0;
        int p = m - 1;
        int si = 0;

        while (i < n && p >= 0) {
            if (array1[i] < array2[p]) {
                sort[si++] = array1[i++];
            } else if (array1[i] > array2[p]) {
                sort[si++] = array2[p--];
            } else {
                sort[si++] = array1[i++];
            }
        }

        if (p <= 0) {
            for (int j = i; j < n; j++) {
                sort[si++] = array1[j++];
            }
        }
        if (i >= n) {
            for (int j = p; j >= 0; j--) {
                sort[si++] = array2[j];
            }
        }
        return sort;
    }
}
