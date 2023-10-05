package main.java.com.uin.leetcode_100.greedy.leetcode_670;

/**
 * 670. 最大交换
 * 给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。
 */
public class Main {
    /**
     * 贪心
     *
     * @param num
     * @return int
     * @author wanglufei
     * @date 2022/9/13 2:45 PM
     */
    public int maximumSwap(int num) {
        char[] array = String.valueOf(num).toCharArray();
        //0-9
        int[] lastIndex = new int[10];
        for (int i = 0; i < array.length; i++) {
            lastIndex[array[i] - '0'] = i;
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 9; j > array[i] - '0'; j--) {
                if (lastIndex[j] > i) {
                    swap(array, lastIndex[j], i);
                    return Integer.valueOf(String.valueOf(array));
                }
            }
        }
        return num;
    }

    private void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
