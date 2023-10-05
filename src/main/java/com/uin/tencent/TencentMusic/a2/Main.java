package main.java.com.uin.tencent.TencentMusic.a2;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 腾讯音乐娱乐集团2022暑期实习生招聘技术类岗位编程题合集--出现至少k次的小写字母--小红的数组操作
 * 小红拿到了一个数组 a，每次操作小红可以选择数组中的任意一个数减去 x，小红一共能进行 k 次。
 * 小红想在 k 次操作之后，数组的最大值尽可能小。请你返回这个最大值。
 * <p>
 * [7,2,1],3,2
 * 2
 */
public class Main {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param a int整型ArrayList
     * @param k int整型
     * @param x int整型
     * @return int整型
     */
    public int minMax(ArrayList<Integer> a, int k, int x) {
        // write code here
        Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (Integer integer : a) {
            queue.offer(integer);
        }
        for (int i = 0; i < k; i++) {
            Integer poll = queue.poll();
            queue.offer(poll - x);
        }
        return queue.peek();
    }
}
