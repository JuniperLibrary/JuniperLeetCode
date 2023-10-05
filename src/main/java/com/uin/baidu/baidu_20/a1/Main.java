package main.java.com.uin.baidu.baidu_20.a1;

import java.util.Scanner;

/**
 * 百度2020校招Java研发工程师笔试卷（第二批)--最小值
 * 牛牛给度度熊出了一个数学题，牛牛给定数字，希望度度熊能找到一组非负整数满足且尽量小。
 * 度度熊把这个问题交给了你，希望你能帮他解决。
 * <p>
 * 12 18 100
 * 7
 * 例子说明1:
 * 当\mathit a = 7, b = 0时候, (n-a)(m-b) = 90 \leq k = 100，此时\mathit a + b = 7是最小的解。
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        long m = in.nextLong();
        long n = in.nextLong();
        long k = in.nextLong();

        long min = Math.min(m, n);
        long max = Math.max(m, n);

        if (k >= max) {
            System.out.println(min - k / max);
        } else {
            System.out.println(min);
        }
    }
}
