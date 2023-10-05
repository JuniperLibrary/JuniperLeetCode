package main.java.com.uin.leetcode_100.greedy.leetcode_857;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 857.雇佣 K 名工人的最低成本
 * 有 n名工人。给定两个数组quality和wage，其中，quality[i]表示第i名工人的工作质量，其最低期望工资为wage[i]。
 * <p>
 * 现在我们想雇佣k名工人组成一个工资组。在雇佣一组 k名工人时，我们必须按照下述规则向他们支付工资：
 * <p>
 * 对工资组中的每名工人，应当按其工作质量与同组其他工人的工作质量的比例来支付工资。
 * 工资组中的每名工人至少应当得到他们的最低期望工资。
 * 给定整数 k ，返回 组成满足上述条件的付费群体所需的最小金额。在实际答案的10-5以内的答案将被接受。
 * <p>
 * 输入： quality = [10,20,5], wage = [70,50,30], k = 2
 * 输出： 105.00000
 * 解释： 我们向 0 号工人支付 70，向 2 号工人支付 35。
 */
public class Main {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        Integer[] workers = new Integer[n];
        for (int i = 0; i < n; i++) {
            workers[i] = i;
        }
        Arrays.sort(workers, (a, b) -> {
            return quality[b] * wage[a] - quality[a] * wage[b];
        });
        double res = 1e9;
        double totalq = 0.0;
        //
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        for (int i = 0; i < k - 1; i++) {
            totalq += quality[workers[i]];
            pq.offer(quality[workers[i]]);
        }

        for (int i = k - 1; i < n; i++) {
            int idx = workers[i];
            totalq += quality[idx];
            pq.offer(quality[idx]);
            double totalc = ((double) wage[idx] / quality[idx]) * totalq;
            res = Math.min(res, totalc);
            totalq -= pq.poll();
        }
        return res;
    }
}
