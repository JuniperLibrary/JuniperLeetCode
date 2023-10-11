package com.uin.day;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author lin.liu
 */
public class LeetCode2512 {

  /**
   * 2512 奖励最顶尖的k名学生
   * <p>
   * 给你两个字符串数组 positive_feedback 和 negative_feedback ，分别包含表示正面的和负面的词汇。不会 有单词同时是正面的和负面的。
   * <p>
   * 一开始，每位学生分数为 0 。每个正面的单词会给学生的分数 加 3 分，每个负面的词会给学生的分数 减  1 分。
   * <p>
   * 给你 n 个学生的评语，用一个下标从 0 开始的字符串数组 report 和一个下标从 0 开始的整数数组 student_id 表示，其中 student_id[i] 表示这名学生的 ID
   * ，这名学生的评语是 report[i] 。每名学生的 ID 互不相同。
   * <p>
   * 给你一个整数 k ，请你返回按照得分 从高到低 最顶尖的 k 名学生。如果有多名学生分数相同，ID 越小排名越前。
   * <p>
   * 输入：positive_feedback = ["smart","brilliant","studious"], negative_feedback = ["not"], report =
   * ["this student is not studious","the student is smart"], student_id = [1,2], k = 2
   * <p>
   * 输出：[2,1]
   * <p>
   * 解释：
   * <p>
   * - ID 为 1 的学生有 1 个正面词汇和 1 个负面词汇，所以得分为 3-1=2 分。
   * <p>
   * - ID 为 2 的学生有 1 个正面词汇，得分为 3 分。
   * <p>
   * 学生 2 分数更高，所以返回 [2,1] 。
   */

  public List<Integer> toStudents(String[] positive_feedback, String[] negative_feedback,
      String[] report, int[] student_id, int k) {
    // 从大到小 int[]{student_id,score}
    PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(
        (a, b) -> a[1] == b[1] ? a[0] - b[0] : b[1] - a[1]);
    Map<String, Integer> posMap = new HashMap<>();
    for (String s : positive_feedback) {
      posMap.put(s, 0);
    }
    Map<String, Integer> negMap = new HashMap<>();
    for (String s : negative_feedback) {
      negMap.put(s, 0);
    }

    for (int i = 0; i < report.length; i++) {
      String[] words = report[i].split(" ");
      int score = 0;
      for (String word : words) {
        if (posMap.containsKey(word)) {
          score += 3;
        } else if (negMap.containsKey(word)) {
          score--;
        }
      }
      priorityQueue.offer(new int[]{student_id[i], score});
    }

    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < k; i++) {
      list.add(priorityQueue.poll()[0]);
    }
    return list;
  }
}
