package main.java.com.uin.leetcode_100.string.leetcode_777;

/**
 * 777. 在LR字符串中交换相邻字符
 * 在一个由 'L' , 'R' 和 'X' 三个字符组成的字符串（例如"RXXLRXRXL"）中进行移动操作。
 * 一次移动操作指用一个"LX"替换一个"XL"，或者用一个"XR"替换一个"RX"。现给定起始字符串start和结束字符串end，请编写代码，当且仅当存在一系列移动操作使得start可以转换成end时， 返回True。
 * <p>
 * 输入: start = "RXXLRXRXL", end = "XRLXXRRLX"
 * 输出: True
 * 解释:
 * 我们可以通过以下几步将start转换成end:
 * RXXLRXRXL ->
 * XRXLRXRXL ->
 * XRLXRXRXL ->
 * XRLXXRRXL ->
 * XRLXXRRLX
 */
public class Main {
    public static void main(String[] args) {
        String start = "RXXLRXRXL", end = "XRLXXRRLX";
        System.out.println(canTransform(start, end));
    }

    public static boolean canTransform(String start, String end) {
        char c1[] = start.toCharArray(), c2[] = end.toCharArray();
        int p1 = 0, p2 = 0;
        while (p1 < c1.length && p2 < c1.length) {
            while (p1 < c1.length && c1[p1] == 'X') {
                p1++;
            }
            while (p2 < c1.length && c2[p2] == 'X') {
                p2++;
            }
            if (p1 == p2 && p1 == c1.length) {
                return true;
            }
            if (p1 == c1.length || p2 == c2.length || c1[p1] != c2[p2]) {
                return false;
            }
            if (c1[p1] == 'L') {
                if (p1 < p2) {
                    return false;
                }
            } else if (p1 > p2) {
                return false;
            }
            p1++;
            p2++;
        }
        for (int i = p1; i < c1.length; i++) {
            if (c1[i] != 'X') {
                return false;
            }
        }
        for (int i = p2; i < c1.length; i++) {
            if (c2[i] != 'X') {
                return false;
            }
        }
        return true;
    }

    public static boolean helper(String start, String end) {
        int n = start.length();
        int i = 0, j = 0;
        while (i < n && j < n) {
            while (i < n && start.charAt(i) == 'X') {
                i++;
            }
            while (j < n && end.charAt(j) == 'X') {
                j++;
            }
            if (i < n && j < n) {
                if (start.charAt(i) != end.charAt(j)) {
                    return false;
                }
                char c = start.charAt(i);
                if ((c == 'L' && i < j) || (c == 'R' && i > j)) {
                    return false;
                }
                i++;
                j++;
            }
        }
        while (i < n) {
            if (start.charAt(i) != 'X') {
                return false;
            }
            i++;
        }
        while (j < n) {
            if (end.charAt(j) != 'X') {
                return false;
            }
            j++;
        }
        return true;
    }
}
