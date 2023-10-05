package com.uin.baidu.baidu_20.a2;

import java.util.*;

/**
 * 百度2020校招Java研发工程师笔试卷（第二批)--返回公司
 * 度度熊迷路了他想返回他的公司，他现在在 1号点，他的公司在n号点。
 * 度度熊所在的城市由n个点和m条边组成，因为度度熊走了一天了很累，他还有走两条边的体力，度度熊想知道他能否回到公司呢？
 * 每组数据一行如果能回到公司输出“POSSIBLE”，不能输出"IMPOSSIBLE"。
 * 1
 * 4 3
 * 1 2
 * 2 3
 * 3 4
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        for (int i = 0; i < t; i++) {
            // n个点，m个边
            int n = in.nextInt();
            int m = in.nextInt();

            HashSet<Integer> visited = new HashSet<>();
            Map<Integer, List<Integer>> neighbors = new HashMap<>();

            for (int j = 0; j < n; j++) {
                neighbors.put(j + 1, new ArrayList<>());
            }

            for (int j = 0; j < m; j++) {
                int point1 = in.nextInt();
                int point2 = in.nextInt();

                List<Integer> list1 = neighbors.get(point1);
                list1.add(point2);
                neighbors.put(point1, list1);
                List<Integer> list2 = neighbors.get(point2);
                list2.add(point1);
                neighbors.put(point2, list2);
            }

            boolean flag = false;

            int length = 0;
            Queue<Integer> queue = new LinkedList<>();
            queue.add(1);
            while (!queue.isEmpty() && !flag) {
                int size = queue.size();
                length++;
                for (int j = 0; j < size; j++) {
                    int point = queue.poll();
                    if (point == n && length == 3) {
                        flag = true;
                    }
                    visited.add(point);
                    List<Integer> nexts = neighbors.get(point);
                    for (int k = 0; k < nexts.size(); k++) {
                        int next = nexts.get(k);
                        if (!visited.contains(next)) {
                            queue.add(next);
                        }
                    }
                }
            }
            if (flag) {
                System.out.println("POSSIBLE");
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }
    }
}
