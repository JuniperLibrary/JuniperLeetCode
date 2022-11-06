package com.weekendAC.weenkend_318.ac3;


import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 6231. 雇佣 K 位工人的总代价
 * 给你一个下标从 0开始的整数数组costs，其中costs[i]是雇佣第 i位工人的代价。
 * <p>
 * 同时给你两个整数k 和candidates。我们想根据以下规则恰好雇佣k位工人：
 * <p>
 * 总共进行k轮雇佣，且每一轮恰好雇佣一位工人。
 * 在每一轮雇佣中，从最前面 candidates和最后面 candidates人中选出代价最小的一位工人，如果有多位代价相同且最小的工人，选择下标更小的一位工人。
 * 比方说，costs = [3,2,7,7,1,2] 且candidates = 2，第一轮雇佣中，我们选择第4位工人，因为他的代价最小[3,2,7,7,1,2]。
 * 第二轮雇佣，我们选择第1位工人，因为他们的代价与第4位工人一样都是最小代价，而且下标更小，[3,2,7,7,2]。注意每一轮雇佣后，剩余工人的下标可能会发生变化。
 * 如果剩余员工数目不足 candidates人，那么下一轮雇佣他们中代价最小的一人，如果有多位代价相同且最小的工人，选择下标更小的一位工人。
 * 一位工人只能被选择一次。
 * 返回雇佣恰好k位工人的总代价。
 * 示例 1：
 * <p>
 * 输入：costs = [17,12,10,2,7,2,11,20,8], k = 3, candidates = 4
 * 输出：11
 * 解释：我们总共雇佣 3 位工人。总代价一开始为 0 。
 * - 第一轮雇佣，我们从 [17,12,10,2,7,2,11,20,8] 中选择。最小代价是 2 ，有两位工人，我们选择下标更小的一位工人，即第 3 位工人。总代价是 0 + 2 = 2 。
 * - 第二轮雇佣，我们从 [17,12,10,7,2,11,20,8] 中选择。最小代价是 2 ，下标为 4 ，总代价是 2 + 2 = 4 。
 * - 第三轮雇佣，我们从 [17,12,10,7,11,20,8] 中选择，最小代价是 7 ，下标为 3 ，总代价是 4 + 7 = 11 。注意下标为 3 的工人同时在最前面和最后面 4 位工人中。
 * 总雇佣代价是 11 。
 * 示例 2：
 * <p>
 * 输入：costs = [1,2,4,1], k = 3, candidates = 3
 * 输出：4
 * 解释：我们总共雇佣 3 位工人。总代价一开始为 0 。
 * - 第一轮雇佣，我们从 [1,2,4,1] 中选择。最小代价为 1 ，有两位工人，我们选择下标更小的一位工人，即第 0 位工人，总代价是 0 + 1 = 1 。注意，下标为 1 和 2 的工人同时在最前面和最后面 3 位工人中。
 * - 第二轮雇佣，我们从 [2,4,1] 中选择。最小代价为 1 ，下标为 2 ，总代价是 1 + 1 = 2 。
 * - 第三轮雇佣，少于 3 位工人，我们从剩余工人 [2,4] 中选择。最小代价是 2 ，下标为 0 。总代价为 2 + 2 = 4 。
 * 总雇佣代价是 4 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= costs.length <= 105
 * 1 <= costs[i] <= 105
 * 1 <= k, candidates <= costs.length
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/total-cost-to-hire-k-workers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(helper(new int[]{1, 2, 4, 1}, 3, 3));
    }

    public static long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        Queue<Pair> queue = new PriorityQueue<>(n, (o1, o2) -> {
            if (o1.x != o2.x) {
                return o1.x - o2.x;
            }
            return o1.y - o2.y;
        });

        for (int i = 0; i < candidates; i++) {
            queue.offer(new Pair(costs[i], 0));
        }

        int l = candidates;
        for (int i = n - 1, j = 0; i >= l && j < candidates; i--, j++) {
            queue.offer(new Pair(costs[i], 1));
        }
        int r = n - candidates - 1;
        long res = 0;
        while (k-- > 0) {
            Pair pair = queue.poll();
            res += pair.x;
            int t = pair.y;
            if (l > r) {
                continue;
            }
            if (t == 0) queue.offer(new Pair(costs[l++], 0));
            else queue.offer(new Pair(costs[r--], 1));
        }
        return res;
    }

    /**
     * 两个优先级队列去维护两端最小值，然后取出 k 位工人即可
     *
     * @param costs
     * @param k
     * @param candidates
     * @return
     */
    public static long helper(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> leftQueue = new PriorityQueue<>();
        PriorityQueue<Integer> rightQueue = new PriorityQueue<>();

        int n = costs.length, l = 0, r = n - 1;
        for (int i = 0; i < candidates; i++) {
            if (l <= r) {
                leftQueue.offer(costs[l++]);
            }
            if (l <= r) {
                rightQueue.offer(costs[r--]);
            }
        }

        long totalCost = 0;
        int cnt = 0;
        while (cnt++ < k) {
            int leftMin = leftQueue.isEmpty() ? Integer.MAX_VALUE : leftQueue.peek();
            int rightMin = rightQueue.isEmpty() ? Integer.MAX_VALUE : rightQueue.peek();

            if (leftMin <= rightMin) {
                leftQueue.poll();

                if (l <= r) {
                    leftQueue.offer(costs[l++]);
                }
            } else {
                rightQueue.poll();
                if (l <= r) {
                    rightQueue.offer(costs[r--]);
                }
            }

            totalCost += Math.min(leftMin, rightMin);
        }

        return totalCost;
    }
}


class Pair {
    int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}


