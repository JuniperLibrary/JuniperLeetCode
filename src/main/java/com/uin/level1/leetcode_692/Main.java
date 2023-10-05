package main.java.com.uin.level1.leetcode_692;

import java.util.*;

/**
 * 692. 前K个高频单词
 * 给定一个单词列表words和一个整数 k ，返回前k个出现次数最多的单词。
 * <p>
 * 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率， 按字典顺序 排序。
 * <p>
 * 输入: words = ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * 输出: ["i", "love"]
 * 解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
 * 注意，按字母顺序 "i" 在 "love" 之前。
 */
public class Main {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        //记录每个字符出现的次数
        for (String word : words) {
            // map.getOrDefault(word, 0) + 1
            //如果map里边没有这个word，就给默认值0，如果有就加1
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        //对次数进行排序
        Queue<String> heap = new PriorityQueue<>(
                (a, b) ->
                        map.get(a) == map.get(b) ?
                                //相等的话字典顺序排序
                                b.compareTo(a)
                                :
                                //不想等就按次数
                                map.get(a) - map.get(b)
        );
        //遍历map给堆里边存值
        for (String word : map.keySet()) {
            heap.offer(String.valueOf(word));
            //  保证堆里边有k个元素
            if (heap.size() > k) {
                heap.remove();
            }

        }
        //处理返回结果
        List<String> res = new ArrayList<>();

        while (heap.size() > 0) {
            res.add(heap.poll());
        }

        Collections.reverse(res);
        return res;
    }
}
