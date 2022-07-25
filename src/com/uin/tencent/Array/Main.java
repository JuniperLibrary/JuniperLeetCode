package com.uin.tencent.Array;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * 小红的数组操作
 * <p>
 * 小红拿到了一个数组 a，每次操作小红可以选择数组中的任意一个数减去 x，小红一共能进行 k 次。
 * 小红想在 k 次操作之后，数组的最大值尽可能小。请你返回这个最大值。
 *
 * @author wanglufei
 * @date 2022/7/21 7:24 PM
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(0, 7);
        a.add(1, 2);
        a.add(2, 1);
        int x = 3;
        int k = 2;
        System.out.println(solution3(a, x, k));
    }

    public static int solution(ArrayList<Integer> a, int x, int k) {

        int max = a.get(0);
        for (int j = 0; j < k; j++) {
            int max_index = 0;
            for (int i = 0; i < a.size(); i++) {
                if (a.get(i) > max) {
                    max = a.get(i);
                    max_index = i;
                }
            }
            a.set(max_index, a.get(max_index) - x);
        }
        int newmax = a.get(0);
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) > max) newmax = max;
        }
        return newmax;
    }

    public static int solution2(ArrayList<Integer> a, int x, int k) {
        int c = 0;
        int num = 0;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < a.size(); j++) {
                if (c < a.get(i)) {
                    num = j;
                    c = a.get(j);
                }
            }
            c -= x;
            a.set(num, c);
        }
        Iterator<Integer> iterator = a.iterator();
        while (iterator.hasNext()) {
            Integer next = (int) iterator.next();
            if (next > c) {
                c = next;
            }
        }
        return c;
    }


    public static int solution3(ArrayList<Integer> a, int x, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for (Integer integer : a) {
            queue.offer(integer);
        }

        for (int i = 0; i < k; i++) {
            Integer poll = queue.poll();
            queue.offer(poll-x);
        }
        return queue.peek();
    }
}
