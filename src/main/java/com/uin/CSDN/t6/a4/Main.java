package main.java.com.uin.CSDN.t6.a4;

import java.util.ArrayList;
/**
 * 最长递增的区间长度
 */
public class Main {
    public static void main(String[] args) {
    }
    public static int helper(ArrayList<Integer> list, int n) {
        int result = 0;
        int max = -1;
        int len = list.size();

        for (int i = 0; i < len; i++) {
            int res = list.get(i);
            int r = i;
            while ((r + 1) < len && list.get(r + 1) > list.get(r)) {
                res += list.get(r + 1);
                r++;
            }
            if (res > max) {
                result = Math.max(r - i - 1, result);
            }
            i = r;
        }
        return result;
    }
}
