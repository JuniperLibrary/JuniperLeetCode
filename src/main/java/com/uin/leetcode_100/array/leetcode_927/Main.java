package com.uin.leetcode_100.array.leetcode_927;

import java.util.Arrays;

/**
 * 927.三等分
 * 给定一个由0和1 组成的数组，将数组分成3个非空的数组，使的所有的这些部分表示相同的二进制的值
 * 如果可以做到，请返回任何[i, j]，其中 i+1 < j，这样一来：
 * <p>
 * arr[0], arr[1], ..., arr[i]为第一部分；
 * arr[i + 1], arr[i + 2], ..., arr[j - 1]为第二部分；
 * arr[j], arr[j + 1], ..., arr[arr.length - 1]为第三部分。
 * 这三个部分所表示的二进制值相等。
 * 如果无法做到，就返回[-1, -1]。
 * <p>
 * 注意，在考虑每个部分所表示的二进制时，应当将其看作一个整体。例如，[1,1,0]表示十进制中的6，而不会是3。
 * 此外，前导零也是被允许的，所以[0,1,1] 和[1,1]表示相同的值。
 */
public class Main {
    public static void main(String[] args) {

    }

    public static int[] threeEqualParts(int[] arr) {
        int sum = Arrays.stream(arr).sum();

        if (sum % 3 != 0) {
            return new int[]{-1, 1};
        }
        if (sum == 0) {
            return new int[]{0, 2};
        }

        int partial = sum / 3;
        int first = 0, second = 0, third = 0, cur = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                if (cur == 0) {
                    first = i;
                } else if (cur == partial) {
                    second = i;
                } else if (cur == 2 * partial) {
                    third = i;
                }
                cur++;
            }
        }
        int len = arr.length - third;
        if (first + len <= second && second + len <= third) {
            int i = 0;
            while (third + i < arr.length) {
                if (arr[first + 1] != arr[second + 1] || arr[first + 1] != arr[third + 1]) {
                    return new int[]{-1, -1};
                }
                i++;
            }
            return new int[]{first + len - 1, second + len};
        }
        return new int[]{-1, -1};
    }

    public int[] helper(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        if (sum == 0) {
            return new int[]{0, 2};
        }
        if (sum % 3 != 0) {
            return new int[]{-1, -1};
        }
        sum /= 3;
        int r = arr.length - 1, l = 0;
        while (arr[r] == 0) {
            r--;
        }
        int end = r;
        int zero = arr.length - 1 - r;//最后一个数末尾0的个数，其他俩数的末尾0应该不少
        int count = 0;
        while (count < sum) {
            count += arr[l];
            l++;
        }
        //此时的l是第一组1的末尾后边
        r = l;
        while (count < sum * 2) {
            count += arr[r];
            r++;
        }
        //此时的r是第二组1的末尾后边
        //先验证末尾0是否数量足够：
        for (int i = l; i < l + zero; i++) {
            if (arr[i] == 1) {
                return new int[]{-1, -1};
            }
        }
        for (int i = r; i < r + zero; i++) {
            if (arr[i] == 1) {
                return new int[]{-1, -1};
            }
        }
        //再验证其他位是否一致：
        count = 0;
        for (int i = 0; count < sum; i++) {
            if (arr[end - i] != arr[r - 1 - i] || arr[end - i] != arr[l - 1 - i]) {
                return new int[]{-1, -1};
            }
            count += arr[end - i];
        }
        return new int[]{l + zero - 1, r + zero};
    }
}
